package pages.testSite;

import com.microsoft.playwright.Locator;
import utils.TestMain;

public class MyAccountPage extends TestMain {

    public Locator pageTitle = page.locator("h1.page-heading").filter(new Locator.FilterOptions().setHasText("My account"));

}
