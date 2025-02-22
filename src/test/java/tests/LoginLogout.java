package tests;

import org.junit.jupiter.api.Test;
import pages.Pages;
import utils.DataLoader;
import utils.TestMain;

public class LoginLogout extends TestMain {

    DataLoader.UserData testUser = DataLoader.loadUserData("testUser1");
    String firstName = testUser.firstName;
    String lastName = testUser.lastName;
    String username = testUser.username;
    String password = testUser.password;
    String email = testUser.email;

    @Test
    void loginLogoutTest() {
        //1. Navigate to the test site
        Pages.mainPage.openMainPage();
        Pages.loginPage.login(firstName, lastName, email, password);
        System.out.println("The user logged in successfully");
        Pages.loginPage.logout();
        System.out.println("The user logged out successfully");
    }

}
