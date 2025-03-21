package utils;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pages.Pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestMain {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;

    @BeforeAll
    public static void setupBeforeTest() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }


    @AfterAll
    public static void tearDown() {
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    public String getRandomEmail() {
        page.navigate("https://10minutemail.net");
        assertThat(Pages.tenMinuteMailPage.consentBtn).isEnabled();
        Pages.tenMinuteMailPage.consentBtn.click();
        assertThat(Pages.tenMinuteMailPage.tenMinuteMailMenuBar).isVisible();
        String generatedEmail = Pages.tenMinuteMailPage.emailAddressField.inputValue();
        return generatedEmail;
    }

}
