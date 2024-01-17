package ewidencja;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.floor;

public class App implements Application
{
    private Login login;
    private Data data;
    public App()
    {
        login = new Login();
        data = new Data();
    }
    
    public static void main(String[] args) throws IOException
    {
        System.out.println("Jak chcesz się zalogować?\n");
        System.out.println("1. Obywatel");
        System.out.println("2. Urzędnik");

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        switch (input)
        {
            case 1:
                CitizenView citizen = new CitizenView();
                break;
            case 2:
                ClerkView clerk = new ClerkView();
                break;
        }

    }

    public boolean login(long PESEL, String password)
    {
        return login.checkPesel(PESEL) && login.getPassword(PESEL).equals(password);
    }

    public boolean verifyData(long PESEL, LocalDate birthDate, boolean sex)
    {
        if(PESEL >= 11111111111L)
        {
            int yearDigits = birthDate.getYear() % 100;
            if(floor(PESEL / 1000000000.0) == yearDigits)return  true;
            //TODO implement rest of the verification
        }
        return false;
    }

    public ArrayList<Record> showData(Record criteria)
    {
        if(criteria.citizenLogin)
        {
            ArrayList<Record> records = new ArrayList<>();
            records.add(data.getData(criteria.PESEL));
            return records;
        }
        else
        {
            ArrayList<Record> records = new ArrayList<>();
            records.add(data.getData(criteria.PESEL));
            //TODO get records from database and make arraylist of them
            return records;
        }
    }

    public boolean changeData(long PESEL, Record record, boolean newData)
    {
        if(newData)
        {
            return data.accountFirstInput(record);
        }
        else
        {
            return data.changeData(PESEL, record);
        }
    }

    public int createAccount(long PESEL, String password)
    {
        if(!login.checkPesel(PESEL) && checkPassword(password))
        {
            login.createAccount(PESEL, password);
            return 0;
        }
        return 1;
    }

    public  boolean checkPassword(String password)
    {
        return password.length() >= 8;
    }
}
