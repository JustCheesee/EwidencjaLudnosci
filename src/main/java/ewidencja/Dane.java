package ewidencja;

import java.time.LocalDate;
public class Dane {

    public Record[] recordsToAdd = new Record[2];

    public String[][]loginData = {
        {
            "11111111111",
            "haslo"
        },
        {
            "80567890111",
            "password"
        },
        {
            "8056789011",
            "password"
        },
        {
            "abc",
            "password"
        },

    };
    public String[][] inputData = {
        {
                "11111111111",
                "1990",
                "10",
                "20",
                "0",
                "Jan",
                "Kowalski",
                "Warszawa"
        },
        {
                "80567890111",
                "1980",
                "10",
                "20",
                "1",
                "Julia",
                "Kowalska",
                "Wroclaw"
        }
    };

    public Long[] PESELS = {
            11111111111L,
            1234567890L,
            8056789011L,
    };

    public Dane()
    {
        Record record1 = new Record();
        record1.PESEL = 11111111111L;
        record1.name = "Jan";
        record1.surname = "Kowalski";
        record1.sex = false;
        record1.birthDate = LocalDate.of(1999, 1, 1);
        record1.domicile = "Warszawa";
        recordsToAdd[0] = record1;

        Record record2 = new Record();
        record2.PESEL = 12345678901L;
        record2.birthDate = LocalDate.of(1980, 5, 23);
        record2.sex = true;
        record2.name = "Julia";
        record2.surname = "Kowalska";
        record2.domicile = "Wroclaw";
        recordsToAdd[1] = record2;
    }
}
