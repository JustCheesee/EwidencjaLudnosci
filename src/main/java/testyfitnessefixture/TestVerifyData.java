package testyfitnessefixture;
import fit.ColumnFixture;

import java.time.LocalDate;

public class TestVerifyData extends ColumnFixture {
    String pesel;
    String date;
    boolean sex;
    public boolean verifyData()
    {
        boolean test = SetUp.aplikacja.verifyData(Long.parseLong(pesel), LocalDate.parse(date), sex);
        return test;
    }
}
