package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResidentsTestMock {

    List<Resident> residentList = new ArrayList<Resident>();
    @Before
    public void init() {
        residentList.add(new Resident("Thomas", "Heid", "Hauptstrasse", "Furtwangen", new Date(2000, Calendar.DECEMBER, 5)));
        residentList.add(new Resident("John", "Heder", "Baumstrasse", "Hamburg", new Date(1993, Calendar.MARCH, 19)));
        residentList.add(new Resident("Timo", "Bleiber", "Schnitzelgasse", "Stuttgart", new Date(1989, Calendar.APRIL, 23)));
    }

    @Test
    public void testGetUniqueResident() throws ResidentServiceException {
        ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);

        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryMock);

        expect(residentRepositoryMock.getResidents()).andReturn(residentList);
        replay(residentRepositoryMock);

        Resident testFilterResident = new Resident();
        testFilterResident.setGivenName("Thomas");

        Resident result = baseResidentService.getUniqueResident(testFilterResident);

        verify(residentRepositoryMock);

        assertThat(result, equalTo(residentList.get(0)));
    }

    @Test
    public void testGetFilteredResidentsList() {
        ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);

        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryMock);

        expect(residentRepositoryMock.getResidents()).andReturn(residentList);
        replay(residentRepositoryMock);

        Resident testFilterResident = new Resident();
        testFilterResident.setGivenName("Thomas");

        Resident result = baseResidentService.getFilteredResidentsList(testFilterResident).get(0);

        verify(residentRepositoryMock);

        assertThat(result, equalTo(residentList.get(0)));
    }
}
