package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import ewidencja.CitizenView;
import ewidencja.Dane;

import java.io.*;

import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CitizenViewTest implements TestExecutionExceptionHandler {

    static Dane dane;
    static CitizenView citizenView;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        if (throwable instanceof NumberFormatException) {
            System.err.println("Caught NumberFormatException: " + throwable.getMessage());
        }
        else throw throwable;
    }

    @BeforeAll
    static public void setup() throws IOException {
        dane = new Dane();
        citizenView = new CitizenView();
    }
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    @Tag("Login")
    @Order(2)
    @ExtendWith(CitizenViewTest.class)
    public void testLogin() throws Exception {

        withTextFromSystemIn(dane.loginData[0][0]+"\n"+dane.loginData[0][1])
                .execute(() -> {
                    citizenView.login();
                    String[] lines = outputStreamCaptor.toString().trim().split("\r?\n");
                    String lastLine = lines[lines.length - 1];
                    Assertions.assertEquals("Zalogowano pomyslnie!", lastLine);
                });

        withTextFromSystemIn(dane.loginData[1][0]+"\n"+dane.loginData[1][1])
                .execute(() -> {
                    citizenView.login();
                    String[] lines = outputStreamCaptor.toString().trim().split("\r?\n");
                    String lastLine = lines[lines.length - 1];
                    Assertions.assertEquals("Sprobuj ponownie! Nieprawidlowy PESEL lub haslo.", lastLine);
                });

        withTextFromSystemIn(dane.loginData[2][0]+"\n"+dane.loginData[2][1])
                .execute(() -> {
                    citizenView.login();
                    String[] lines = outputStreamCaptor.toString().trim().split("\r?\n");
                    String lastLine = lines[lines.length - 1];
                    Assertions.assertEquals("Sprobuj ponownie! Nieprawidlowy PESEL lub haslo.", lastLine);
                });

        withTextFromSystemIn(dane.loginData[3][0]+"\n"+dane.loginData[3][1])
                .execute(() -> {
                    Assertions.assertThrows(NumberFormatException.class, () -> citizenView.login());
                });
    }

    @Test
    @Tag("Dane")
    @Order(1)
    void testShowData() {
        citizenView.showData(true);
        String[] lines2 = outputStreamCaptor.toString().trim().split("\r?\n");
        Assertions.assertNotEquals(lines2[0], "PESEL: "+ dane.recordsToAdd[0].PESEL);
        Assertions.assertNotEquals(lines2[1], "Imie: "+ dane.recordsToAdd[0].name);
        Assertions.assertNotEquals(lines2[2], "Nazwisko: "+ dane.recordsToAdd[0].surname);
        Assertions.assertNotEquals(lines2[3], "ewidencja.Data urodzenia: "+ dane.recordsToAdd[0].birthDate);
        Assertions.assertNotEquals(lines2[4], "Plec: "+ dane.recordsToAdd[0].sex);
        Assertions.assertNotEquals(lines2[5], "Miejsce zamieszkania: "+ dane.recordsToAdd[0].domicile);

        citizenView.showData(false);
        String[] lines1 = outputStreamCaptor.toString().trim().split("\r?\n");
        Assertions.assertEquals(lines1[1], "Imie: "+ dane.recordsToAdd[1].name);
        Assertions.assertEquals(lines1[2], "Nazwisko: "+ dane.recordsToAdd[1].surname);
        Assertions.assertEquals(lines1[3], "ewidencja.Data urodzenia: "+ dane.recordsToAdd[1].birthDate);
        Assertions.assertEquals(lines1[4], "Plec: "+ dane.recordsToAdd[1].sex);
        Assertions.assertEquals(lines1[5], "Miejsce zamieszkania: "+ dane.recordsToAdd[1].domicile);
    }

    @Test
    @Tag("Dane")
    @Order(3)
    void inputData() throws Exception {
        withTextFromSystemIn(dane.inputData[0][0]+"\n"+dane.inputData[0][1]+"\n"+dane.inputData[0][2]+"\n"+dane.inputData[0][3]+"\n"
                +dane.inputData[0][4]+"\n"+dane.inputData[0][5]+"\n"+dane.inputData[0][6]+"\n"+dane.inputData[0][7])
                .execute(() -> {
                    citizenView.inputData(false);
                    String[] lines = outputStreamCaptor.toString().trim().split("\r?\n");
                    String lastLine = lines[lines.length - 1];
                    Assertions.assertEquals("Podane dane są nieprawidłowe!", lastLine);
                });

        withTextFromSystemIn(dane.inputData[1][0]+"\n"+dane.inputData[1][1]+"\n"+dane.inputData[1][2]+"\n"+dane.inputData[1][3]+"\n"
                +dane.inputData[1][4]+"\n"+dane.inputData[1][5]+"\n"+dane.inputData[1][6]+"\n"+dane.inputData[1][7])
                .execute(() -> {
                    citizenView.inputData(false);
                    String[] lines = outputStreamCaptor.toString().trim().split("\r?\n");
                    String lastLine = lines[lines.length - 1];
                    Assertions.assertEquals("ewidencja.Dane zostały zmienione!", lastLine);
                });
    }


}