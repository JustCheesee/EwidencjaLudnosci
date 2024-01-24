package ewidencja;


import java.util.*;

public class Login {
    public Map<Long, String> logins = new HashMap<>();

    public String getPassword(long PESEL){
        //znalezienie hasla na podstawie peselu
        String password = "haslo";
        return password;
    }

    public boolean checkPesel(long PESEL){
        //sprawdzenie czy w bazie danych ten PESEL juz istnieje
        if(PESEL >= 11111111111L){
            return true;
        }
        return false;
    }

    public boolean createAccount(long PESEL, String Password){
        //wysłanie do bazy danych informacji o stworzenie nowej rubryki z danych
        logins.put(PESEL, Password);
        return true;
    }

    public boolean login(long PESEL, String Password)
    {
        if(logins.containsKey(PESEL) && Objects.equals(logins.get(PESEL), Password))
        {
            return true;
        }
        else return false;
    }


    public Login(){};
}
