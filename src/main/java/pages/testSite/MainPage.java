package pages.testSite;

import com.microsoft.playwright.Locator;
import pages.Pages;
import utils.TestMain;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MainPage extends TestMain {

    Locator signInBtn = page.locator("a[class='login']");

    void clickSignInBtn() {
        assertThat(this.signInBtn).isEnabled();
        this.signInBtn.click();
        assertThat(Pages.loginPage.loginPageTitle).isVisible();
    }

    public void openMainPage() {
        page.navigate("http://www.automationpractice.pl/index.php");
        assertThat(page.locator("#header_logo")).isVisible();
    }

}
