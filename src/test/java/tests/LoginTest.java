package tests;

import ewidencja.Dane;
import ewidencja.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import java.util.IllegalFormatCodePointException;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Tag("Login")
public class LoginTest implements TestExecutionExceptionHandler {
    static Login login;
    static Dane dane;


    static Stream<Integer> longProvider(){
        return Stream.of(0, 1, 2);
    }

    @BeforeEach
    public void setUp(){
        login = new Login();
        dane = new Dane();
    }

    @Test
    @ExtendWith(LoginTest.class)
    void getPassword() {
        Assertions.assertEquals("haslo", login.getPassword(12345678912L));
    }

    @ParameterizedTest()
    @MethodSource("longProvider")
    public void checkPesel(int number) {
        if(number == 0) Assertions.assertTrue(login.checkPesel(dane.PESELS[number]));
        else Assertions.assertFalse(login.checkPesel(dane.PESELS[number]));
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable{
        if(throwable instanceof IllegalFormatCodePointException){

        }else throw throwable;
    }
}