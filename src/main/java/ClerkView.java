import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClerkView extends CitizenView implements View
{
    ClerkView() throws IOException
    {
        super();
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
                System.out.println("Co chcesz zrobić?\n");
                System.out.println("1. Wyświetl dane");
                System.out.println("2. Zmień dane");
                System.out.println("3. Utwórz konto obywatela");
                System.out.println("4. Wyloguj się");
                System.out.println("5. Zakończ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int input = Integer.parseInt(br.readLine());
                switch (input)
                {
                    case 1:
                        showData(false);
                        break;
                    case 2:
                        changeDataRequest();
                        break;
                    case 3:
                        createAccount();
                        break;
                    case 4:
                        loggedIn = false;
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public void createAccount() throws IOException
    {
        System.out.println("Podaj dane obywatela:");
        System.out.println("PESEL: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long PESEL = Long.parseLong(br.readLine());

        System.out.println("Haslo: ");
        String haslo = br.readLine();

        //1 - PESEL already exists or password is too short
        if(app.createAccount(PESEL, haslo) == 1)
        {
            System.out.println("Konto nie zostało utworzone");
        }
        else
        {
            System.out.println("Konto zostało utworzone");
        }
    }
}
