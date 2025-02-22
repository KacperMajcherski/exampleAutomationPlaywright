package pages.testSite;

import com.microsoft.playwright.Locator;
import pages.Pages;
import utils.TestMain;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage extends TestMain {

    public Locator loginPageTitle = page.locator("//h1[contains(@class, 'page-heading') and text()='Authentication']");
    public Locator loginRegisterForms = page.locator("#center_column");
    public Locator emailField = page.locator("#email");
    public Locator passwordField = page.locator("#passwd");
    public Locator registerEmailField = page.locator("#email_create");
    public Locator registerBtn = page.locator("#SubmitCreate");
    public Locator loginBtn = page.locator("#SubmitLogin");
    //Registration-specific:
    public Locator createAccountSectionTitle = page.locator("//h1[@class='page-heading' and text()='Create an account']");
    public Locator genderMaleRadioBtn = page.locator("#id_gender1");
    public Locator firstNameField = page.locator("#customer_firstname");
    public Locator lastNameField = page.locator("#customer_lastname");
    public Locator birthDaySelect = page.locator("select#days");
    public Locator birthMonthSelect = page.locator("select#months");
    public Locator birthYearSelect = page.locator("select#years");
    public Locator submitRegisterBtn = page.locator("#submitAccount");

    public Locator loggedUserName = page.locator(".account");


    public void login(String firstName, String lastName, String email, String password) {
        assertThat(Pages.mainPage.signInBtn).isVisible();
        Pages.mainPage.clickSignInBtn();
        assertThat(loginRegisterForms).isVisible();
        assertThat(emailField).isVisible();
        assertThat(passwordField).isVisible();
        assertThat(loginBtn).isVisible();
        emailField.fill(email);
        passwordField.fill(password);
        assertThat(loginBtn).isEnabled();
        loginBtn.click();
        assertThat(Pages.myAccountPage.pageTitle).isVisible();
        assertThat(loggedUserName).containsText(firstName+" "+lastName);
    }

    public void logout() {
        assertThat(Pages.mainPage.signoutBtn).isVisible();
        Pages.mainPage.signoutBtn.click();
        assertThat(loginPageTitle).isVisible();
        assertThat(loginRegisterForms).isVisible();
    }

    public void register(String email, String password, String[] personalData) {
        Pages.mainPage.clickSignInBtn();
        assertThat(loginRegisterForms).isVisible();
        assertThat(registerEmailField).isVisible();
        //Enter the generated e-mail
        registerEmailField.fill(email);
        assertThat((registerEmailField)).hasValue(email);
        assertThat(registerBtn).isEnabled();
        registerBtn.click();
        //Fields are visible
        assertThat(createAccountSectionTitle).isVisible();
        assertThat(genderMaleRadioBtn).isEnabled();
        assertThat(firstNameField).isVisible();
        assertThat(lastNameField).isVisible();
        assertThat(birthDaySelect).isEnabled();
        assertThat(birthMonthSelect).isEnabled();
        assertThat(birthYearSelect).isEnabled();
        //Fill all fields
        genderMaleRadioBtn.click();
        firstNameField.fill(personalData[0]);
        lastNameField.fill(personalData[1]);
        passwordField.fill(password);
        birthDaySelect.selectOption(personalData[2]);
        birthMonthSelect.selectOption(personalData[3]);
        birthYearSelect.selectOption(personalData[4]);
        assertThat(submitRegisterBtn).isEnabled();
        //Submit
        submitRegisterBtn.click();
        assertThat(Pages.myAccountPage.pageTitle).isVisible();
        //Make sure that we are logged in as our user
        assertThat(loggedUserName).hasText(personalData[0]+" "+personalData[1]);
    }

}
