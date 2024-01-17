package tests;

import ewidencja.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class AppTest {

    static App app;
    public LocalDate birthDate;

    @BeforeAll
    public static void setUp(){
        app = new App();
    }

    @Tag("App")
    @ParameterizedTest
    @CsvSource({"11111111111, 2011, 4, 12, false"})
    void verifyData(long pesel, int year, int month, int day, boolean sex) {
        birthDate = LocalDate.of(year, month, day);
        Assertions.assertTrue(app.verifyData(pesel, birthDate, sex));
    }

    @Tag("App")
    @Test
    void checkPassword() {
        Assertions.assertTrue(app.checkPassword("haslo123"));
    }
}