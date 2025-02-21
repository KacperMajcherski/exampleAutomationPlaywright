package pages.testSite;

import com.microsoft.playwright.Locator;
import utils.TestMain;

public class MyAccountPage extends TestMain {

    public Locator pageTitle = page.locator("h1[@class='page-heading' and text()='My account']");

}
