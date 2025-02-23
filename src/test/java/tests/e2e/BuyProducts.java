package tests.e2e;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.Pages;
import utils.DataLoader;
import utils.TestMain;

public class BuyProducts extends TestMain {

    String firstName;
    String lastName;
    String email;
    String password;
    String user = "testUser1";
    String[] personalInfo = {"Kacper", "Tester", "Kraszewskiego 69", "Poznan", "Alabama", "60681", "United States", "1234567890123"};

    @BeforeEach
    void setup() {
        DataLoader.UserData testUser = DataLoader.loadUserData(user);
        firstName = testUser.firstName;
        lastName = testUser.lastName;
        password = testUser.password;
        email = testUser.email;
        Pages.mainPage.openMainPage();
        Pages.loginPage.login(firstName, lastName, email, password);
    }

    @Test
    void buyEveningDresses() {
        Pages.mainPage.navigateToEveningDresses();
        buyDress("Printed Dress", 10, "M", "Pink");
    }

    void buyDress(String dressName, int quantity, String size, String color) {
        Pages.productsPage.addItemToCart(dressName, quantity, size, color);
        Pages.checkoutPage.proceedCheckout(dressName, quantity, size, color, personalInfo);
    }



}
