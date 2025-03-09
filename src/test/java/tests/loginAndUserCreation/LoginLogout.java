package tests.loginAndUserCreation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.Pages;
import utils.DataLoader;
import utils.TestMain;

public class LoginLogout extends TestMain {

    String firstName;
    String lastName;
    String email;
    String password;
    String user = "testUser1";

    @BeforeEach
    void setup() {
        DataLoader.UserData testUser = DataLoader.loadUserData(user);
        firstName = testUser.firstName;
        lastName = testUser.lastName;
        password = testUser.password;
        email = testUser.email;
    }

    @Test
    void loginLogoutTest() {
        //1. Navigate to the test site
        Pages.mainPage.openMainPage();
        //2. Login using the user credentials and assert that the user is logged in
        Pages.loginPage.login(firstName, lastName, email, password);
        System.out.println("The user logged in successfully");
        //3. Logout and assert that the user is logged out
        Pages.loginPage.logout();
        System.out.println("The user logged out successfully");
    }

}
