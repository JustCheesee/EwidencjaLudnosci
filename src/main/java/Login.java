public class Login {
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
        //wysłanie do bazy danych informacji o stworzenie nowej rubryki z danymi
        return true;
    }

    public Login(){};
}
