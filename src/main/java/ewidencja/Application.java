package ewidencja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public interface Application
{
    boolean login(long PESEL, String password) throws IllegalFormatCodePointException;
    boolean verifyData(long PESEL, LocalDate birthDate, boolean sex);
    ArrayList<Record> showData(Record criteria);
    boolean changeData(long PESEL, Record record, boolean newData);
    int createAccount(long PESEL, String password);
    boolean checkPassword(String password);
}
