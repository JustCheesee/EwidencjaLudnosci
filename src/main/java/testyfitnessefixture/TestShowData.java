package testyfitnessefixture;
import ewidencja.Record;
import fit.ColumnFixture;

import java.util.ArrayList;

public class TestShowData extends ColumnFixture
{
    Record criteria = new Record();
    String pesel;
    public int showData()
    {

        criteria.citizenLogin = true;
        criteria.PESEL = Long.parseLong(pesel);
        ArrayList<Record> test = SetUp.aplikacja.showData(criteria);
        return test.size();
    }

}
