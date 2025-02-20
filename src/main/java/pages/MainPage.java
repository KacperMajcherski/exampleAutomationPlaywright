package pages;

import utils.TestMain;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MainPage extends TestMain {




    public static void openMainPage() {
        page.navigate("http://www.automationpractice.pl/index.php");
        assertThat(page.locator("#header_logo")).isVisible();
    }

}
