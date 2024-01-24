package testyfitnessefixture;
import ewidencja.Record;
import fit.ColumnFixture;
public class TestChangeData extends ColumnFixture
{
    String pesel;
    Record record = new Record();

    public boolean changeData()
    {
        record.citizenLogin = true;
        record.PESEL = Long.parseLong(pesel);
        boolean test = SetUp.aplikacja.changeData(Long.parseLong(pesel), record, true);
        return test;
    }
}
