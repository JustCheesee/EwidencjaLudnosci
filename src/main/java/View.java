import java.io.IOException;
public interface View
{
        void GUI() throws IOException;
        void login() throws IOException;
        void showData(boolean citizenLogin);
        void changeDataRequest() throws IOException;
        void inputData(boolean newData) throws IOException;
}
