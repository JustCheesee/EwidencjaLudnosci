import java.time.LocalDate;

public class Data {
    public boolean accountFirstInput(Record record){
        //Wprowadzanie danych uzytkownika po raz pierwszy do bazy
        return true;
    }

    public boolean changeData(long PESEL, Record record){
        //Zmiana danych w rubryce z PESEL danymi z record
        return true;
    }

    public boolean checkPESEL(long PESEL){
        //Sprawdzenie czy jest rubryka z danym PESELem
        if(PESEL >= 11111111111L)
            return true;
        return false;
    }

    public Record getData(long PESEL){
        Record record = new Record();
        record.PESEL = PESEL;
        record.birthDate = LocalDate.of(1980, 5, 23);
        record.sex = true;
        record.name = "Julia";
        record.surname = "Kowalska";
        record.domicile = "Wroclaw";

        return record;
    }

    public Data(){};
}
