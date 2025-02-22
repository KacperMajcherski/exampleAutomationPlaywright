package tests;
import core.Constants;
import org.junit.jupiter.api.Test;
import pages.Pages;
import utils.TestMain;

public class RegisterNewUser extends TestMain {

    String generatedEmail = Pages.tenMinuteMailPage.getRandomEmail();
    String password = Constants.password;
    String[] registrationData = Constants.registrationData;

    @Test
    void testRegisterNewUser() {
        Pages.mainPage.openMainPage();
        Pages.loginPage.register(generatedEmail, password, registrationData);
        System.out.println("The user has been registered successfully");
    }


}
