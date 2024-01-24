package testyfitnessefixture;
import fit.ColumnFixture;
public class TestCreateAccount extends ColumnFixture {
    String pesel;
    String password;
    public int createAccount()
    {
        int test = SetUp.aplikacja.createAccount(Long.parseLong(pesel), password);
        return test;
    }
}
