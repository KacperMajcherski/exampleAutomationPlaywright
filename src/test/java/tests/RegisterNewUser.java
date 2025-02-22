package tests;
import org.junit.jupiter.api.Test;
import pages.Pages;
import utils.TestMain;

public class RegisterNewUser extends TestMain {

    String generatedEmail = Pages.tenMinuteMailPage.getRandomEmail();
    String password = "Start123123123!";
    String[] registrationData =  {"Kacper", "Tester", "26", "9", "1999"};

    @Test
    void registerNewUserTest() {
        Pages.mainPage.openMainPage();
        Pages.loginPage.register(generatedEmail, password, registrationData);
        System.out.println("The user has been registered successfully");
    }

}
