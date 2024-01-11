import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class CitizenView implements View
{
    public App app;
    private  long PESEL;
    private boolean newAccount;

    //Constructor
    CitizenView() throws IOException {
        app = new App();
        newAccount = true;
        GUI();
    }

    public void GUI() throws IOException
    {
        boolean running = true;
        while (running)
        {
            login();
            boolean loggedIn = true;
            while (loggedIn)
            {
                if(newAccount)
                {
                    System.out.println("Podaj swoje dane:");
                    inputData(true);
                    newAccount = false;
                }
                System.out.println("Co chcesz zrobić?\n");
                System.out.println("1. Wyświetl dane");
                System.out.println("2. Zmień dane");
                System.out.println("3. Wyloguj się");
                System.out.println("4. Zakończ");

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int input = Integer.parseInt(br.readLine());
                switch (input)
                {
                    case 1:
                        showData(true);
                        break;
                    case 2:
                        changeDataRequest();
                        break;
                    case 3:
                        loggedIn = false;
                        break;
                    case 4:
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public void login() throws IOException
    {
        while(true)
        {
            System.out.println("LOGIN");
            System.out.println("Podaj PESEL:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            long PESEL = Long.parseLong(br.readLine());
            this.PESEL = PESEL;
            System.out.println("\nPodaj haslo:");
            String password = br.readLine();
            boolean loginSuccessfull = app.login(PESEL, password);
            if (loginSuccessfull)
            {
                System.out.println("Zalogowano pomyslnie!");
                break;
            } else
            {
                System.out.println("Sprobuj ponownie! Nieprawidlowy PESEL lub haslo.");
            }
        }
    }

    public void showData(boolean citizenLogin)
    {
        Record record = new Record();
        record.PESEL = PESEL;
        record.citizenLogin = citizenLogin;

        ArrayList<Record> records = app.showData(record);
        for(int i = 0; i  < records.size(); i++)
        {
            System.out.println("PESEL: " + records.get(i).PESEL);
            System.out.println("Imie: " + records.get(i).name);
            System.out.println("Nazwisko: " + records.get(i).surname);
            System.out.println("Data urodzenia: " + records.get(i).birthDate);
            System.out.println("Plec: " + records.get(i).sex);
            System.out.println("Miejsce zamieszkania: " + records.get(i).domicile);
        }
    }

    public void changeDataRequest() throws IOException
    {
        inputData(false);
    }

    public void inputData(boolean newData) throws IOException
    {
        Record record = new Record();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        record.PESEL = this.PESEL;
        if(!newData)
        {
            System.out.println("Podaj PESEL:");
            record.PESEL = Long.parseLong(br.readLine());
        }
        System.out.println("Podaj rok urodzenia:");
        int year = Integer.parseInt(br.readLine());

        System.out.println("Podaj miesiac urodzenia:");
        int month = Integer.parseInt(br.readLine());

        System.out.println("Podaj dzien urodzenia:");
        int day = Integer.parseInt(br.readLine());
        record.birthDate = LocalDate.of(year, month, day);

        System.out.println("Podaj plec:");
        if(Integer.parseInt(br.readLine()) == 0) record.sex = false;
        else record.sex= true;

        System.out.println("Podaj imie:");
        record.name = br.readLine();

        System.out.println("Podaj nazwisko:");
        record.surname = br.readLine();

        System.out.println("Podaj miasto zamieszkania:");
        record.domicile = br.readLine();

        if(app.verifyData(record.PESEL, record.birthDate, record.sex))
        {
            app.changeData(record.PESEL, record, newData);
        }
        else
        {
            System.out.println("Podane dane są nieprawidłowe!");
            if(newData)inputData(true);
            else inputData(false);
        }
    }
}
