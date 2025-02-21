package pages.tenMinuteMail;

import com.microsoft.playwright.Locator;
import utils.TestMain;

public class TenMinuteMailPage extends TestMain {

    public Locator tenMinuteMailMenuBar = page.locator("#menu");
    public Locator emailAddressField = page.locator("#fe_text");
    public Locator consentBtn = page.locator("[aria-label='Consent']");

}
