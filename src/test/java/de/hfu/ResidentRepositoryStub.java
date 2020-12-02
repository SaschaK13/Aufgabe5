package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository {

    List<Resident> residentList = new ArrayList<Resident>();

    @Override
    public List<Resident> getResidents() {
        return residentList;
    }

    public void createResidents() {
        residentList.add(new Resident("Thomas", "Heid", "Hauptstrasse", "Furtwangen", new Date(2000, Calendar.DECEMBER, 5)));
        residentList.add(new Resident("John", "Heder", "Baumstrasse", "Hamburg", new Date(1993, Calendar.MARCH, 19)));
        residentList.add(new Resident("Timo", "Bleiber", "Schnitzelgasse", "Stuttgart", new Date(1989, Calendar.APRIL, 23)));
    }
}
