package testyfitnessefixture;
import fit.ColumnFixture;

public class TestLogin extends ColumnFixture
{
    String pesel;
    String haslo;

    public boolean login()
    {
        try
        {
            Long parsedPesel = Long.parseLong(pesel);
            boolean test = SetUp.aplikacja.login(parsedPesel, haslo);
            return test;
        } catch (NumberFormatException exception)
        {
            return false;
        }
    }
}