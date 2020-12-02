package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ResidentsTest {

    ResidentRepositoryStub residentRepositoryStub = new ResidentRepositoryStub();
    BaseResidentService baseResidentService = new BaseResidentService();


    @Test
    public void testGetFilteredResidentsList() {
        residentRepositoryStub.createResidents();
        baseResidentService.setResidentRepository(residentRepositoryStub);

        //One Test Result
        Resident testFilterResident = new Resident();
        testFilterResident.setGivenName("Thomas");
        testFilterResident.setDateOfBirth(new Date(2000, Calendar.DECEMBER, 5));
        Resident result = residentRepositoryStub.residentList.get(0);
        Assert.assertEquals(result, baseResidentService.getFilteredResidentsList(testFilterResident).get(0));

        Resident testFilterResidentStreet = new Resident();
        testFilterResidentStreet.setStreet("Hauptstrasse");
        Assert.assertEquals(result, baseResidentService.getFilteredResidentsList(testFilterResidentStreet).get(0));

        //No Test Result
        Resident testFilterResident2 = new Resident();
        testFilterResident2.setFamilyName("Moin");
        Assert.assertEquals(0, baseResidentService.getFilteredResidentsList(testFilterResident2).size());

        //Two Test Results
        List<Resident> resultList = new ArrayList<>();
        resultList.add(residentRepositoryStub.residentList.get(0));
        resultList.add(residentRepositoryStub.residentList.get(1));

        Resident testFilterResident3 = new Resident();
        testFilterResident3.setFamilyName("H*");

        Assert.assertEquals(resultList, baseResidentService.getFilteredResidentsList(testFilterResident3));
    }

    @Test
    public void testGetUniqueResident() throws ResidentServiceException {
        residentRepositoryStub.createResidents();
        baseResidentService.setResidentRepository(residentRepositoryStub);

        Resident testFilterResident = new Resident();
        testFilterResident.setGivenName("Thomas");
        Resident result = residentRepositoryStub.residentList.get(0);
        Assert.assertEquals(result, baseResidentService.getUniqueResident(testFilterResident));

        Resident testFilterResident2 = new Resident();
        testFilterResident2.setFamilyName("Bleiber");
        Resident result2 = residentRepositoryStub.residentList.get(2);
        Assert.assertEquals(result2, baseResidentService.getUniqueResident(testFilterResident2));
    }

    @Test(expected = ResidentServiceException.class)
    public void testGetUniqueResidentException() throws ResidentServiceException {
        residentRepositoryStub.createResidents();
        baseResidentService.setResidentRepository(residentRepositoryStub);

        Resident testFilterResident = new Resident();
        testFilterResident.setDateOfBirth(new Date(34714, Calendar.DECEMBER, 5));
        baseResidentService.getUniqueResident(testFilterResident);
    }

    @Test(expected = ResidentServiceException.class)
    public void testGetUniqueResidentWildcard() throws ResidentServiceException {
        residentRepositoryStub.createResidents();
        baseResidentService.setResidentRepository(residentRepositoryStub);

        Resident testFilterResident = new Resident();
        testFilterResident.setCity("F*");
        testFilterResident.setFamilyName("G*");
        baseResidentService.getUniqueResident(testFilterResident);
    }
}
