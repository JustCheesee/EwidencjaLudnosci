package ewidencja;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {
    public Map<Long, Record> records = new HashMap<>();
    public boolean accountFirstInput(Record record){
        //Wprowadzanie danych uzytkownika po raz pierwszy do bazy
        records.put(record.PESEL, record);
        return true;
    }

    public boolean changeData(long PESEL, Record record){
        //Zmiana danych w rubryce z PESEL danymi z record
        records.put(PESEL, record);
        return true;
    }

    public boolean checkPESEL(long PESEL){
        //Sprawdzenie czy jest rubryka z danym PESELem
        if(PESEL >= 11111111111L)
            return true;
        return false;
    }

    public Record getData(long PESEL){
        return records.get(PESEL);
    }

    public Data(){};
}
