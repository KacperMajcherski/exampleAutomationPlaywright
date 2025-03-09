package pages.testSite;

import com.microsoft.playwright.Locator;
import pages.Pages;
import utils.TestMain;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MainPage extends TestMain {

    public Locator signInBtn = page.locator("a.login");
    public Locator signoutBtn = page.locator("a[class='logout']");
    public Locator womenCategory = page.locator("//a[contains(@class, 'sf-with-ul') and text()='Women']");
    public Locator dressesSubcategory = page.locator("//a[contains(@class, 'sf-with-ul') and text()='Dresses']").first();
    public Locator eveningDresses = page.locator(("//a[contains(@title, 'Evening Dresses') and text()='Evening Dresses']")).first();
    public Locator eveningDressesPageTitle = page.locator("//span[contains(@class, 'category-name') and normalize-space(text())='Evening Dresses']");
    public List<Locator> products = page.locator(".product-container").all();

    void clickSignInBtn() {
        assertThat(signInBtn).isEnabled();
        signInBtn.click();
        assertThat(Pages.loginPage.loginPageTitle).isVisible();
    }

    public void openMainPage() {
        page.navigate("http://www.automationpractice.pl/index.php");
        assertThat(page.locator("#header_logo")).isVisible();
    }

    public void navigateToEveningDresses() {
        assertThat(womenCategory).isVisible();
        womenCategory.hover();
        page.waitForTimeout(500);
        assertThat(dressesSubcategory).isVisible();
        assertThat(eveningDresses).isVisible();
        assertThat(eveningDresses).isEnabled();
        eveningDresses.click();
        assertThat(eveningDressesPageTitle).isVisible();
        for (Locator product : products) {
            assertThat(product).isVisible();
            System.out.println(product + " is available");
        }
    }
}
