package testyfitnessefixture;
import fit.ColumnFixture;
public class TestCheckPassword extends ColumnFixture{
    String password;
    public boolean checkPassword()
    {
        boolean test = SetUp.aplikacja.checkPassword(password);
        return test;
    }
}
