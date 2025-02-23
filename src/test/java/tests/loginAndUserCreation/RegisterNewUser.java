package tests.loginAndUserCreation;
import org.junit.jupiter.api.Test;
import pages.Pages;
import utils.TestMain;

public class RegisterNewUser extends TestMain {

    String generatedEmail = Pages.tenMinuteMailPage.getRandomEmail();
    String password = "Start123123123!";
    String[] registrationData =  {"Kacper", "Tester", "26", "9", "1999"};

    @Test
    void registerNewUserTest() {
        //1. Navigate to the test site
        Pages.mainPage.openMainPage();
        //2. Register the user using the provided userdata and assert that the user is logged in
        Pages.loginPage.register(generatedEmail, password, registrationData);
        System.out.println("The user has been registered successfully");
    }

}
