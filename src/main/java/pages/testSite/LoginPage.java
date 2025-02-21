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


    public void login(String email, String password) {
        Pages.mainPage.clickSignInBtn();
        assertThat(this.loginRegisterForms).isVisible();
        assertThat(this.emailField).isVisible();
        assertThat(this.passwordField).isVisible();
        assertThat(this.loginBtn).isVisible();
        this.emailField.fill(email);
        this.passwordField.fill(password);
        assertThat(this.loginBtn).isEnabled();
        this.loginBtn.click();
    }

    public void register(String email, String password, String[] personalData) {
        Pages.mainPage.clickSignInBtn();
        assertThat(this.loginRegisterForms).isVisible();
        assertThat(this.registerEmailField).isVisible();
        this.registerEmailField.fill(email);
        assertThat(this.registerBtn).isEnabled();
        this.registerBtn.click();
        assertThat(this.createAccountSectionTitle).isVisible();
        assertThat(this.genderMaleRadioBtn).isEnabled();
        assertThat(this.firstNameField).isVisible();
        assertThat(this.lastNameField).isVisible();
        assertThat(this.birthDaySelect).isEnabled();
        assertThat(this.birthMonthSelect).isEnabled();
        assertThat(this.birthYearSelect).isEnabled();
        this.genderMaleRadioBtn.click();
        this.firstNameField.fill(personalData[0]);
        this.lastNameField.fill(personalData[1]);
        this.birthDaySelect.selectOption(personalData[2]);
        this.birthMonthSelect.selectOption(personalData[3]);
        this.birthYearSelect.selectOption(personalData[4]);
        assertThat(this.submitRegisterBtn).isEnabled();
        this.submitRegisterBtn.click();
        assertThat(Pages.myAccountPage.pageTitle).isVisible();
        assertThat(this.loggedUserName).hasText(personalData[0]+" "+personalData[1]);
    }

}
