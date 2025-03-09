package pages.testSite;

import com.microsoft.playwright.Locator;
import utils.TestMain;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutPage extends TestMain {

    public Locator pageTitle = page.locator("#cart_title");
    public Locator cartItemQuantity = page.locator("//input[@name='quantity_4_44_0_0']");
    public Locator itemInCart(String itemName) {
        return page.locator("//p//a[text()='" + itemName + "']");
    }
    public Locator itemDescription = page.locator("#product_4_44_0_0 > td.cart_description > small:nth-child(3) > a");
    public Locator proceedToCheckoutBtn = page.locator("//a[@class='button btn btn-default standard-checkout button-medium']");
    public Locator firstName = page.locator("input#firstname");
    public Locator lastName = page.locator("input#lastname");
    public Locator address = page.locator("input#address1");
    public Locator city = page.locator("input#city");
    public Locator state = page.locator("select#id_state");
    public Locator postcode = page.locator("input#postcode");
    public Locator country = page.locator("select#id_country");
    public Locator phoneNumber = page.locator("input#phone_mobile");
    public Locator addressSectionTitle = page.locator("//h1[contains(@class, 'page-subheading') and contains(text(), 'Your addresses')]");
    public Locator saveAddressBtn = page.locator("button#submitAddress");

    public void proceedCheckout(String itemName, int quantity, String size, String color, String[] personalInfo) {
        assertThat(itemInCart(itemName)).isVisible();
        assertThat(cartItemQuantity).hasValue(String.valueOf(quantity));
        assertThat(itemDescription).containsText("Size : "+size+", Color : "+color);
        assertThat(proceedToCheckoutBtn).isEnabled();
        proceedToCheckoutBtn.click();
        assertThat(addressSectionTitle).isVisible();
        assertThat(firstName).isVisible();
        assertThat(lastName).isVisible();
        assertThat(address).isVisible();
        assertThat(city).isVisible();
        assertThat(state).isVisible();
        assertThat(postcode).isVisible();
        assertThat(country).isVisible();
        assertThat(phoneNumber).isVisible();
        firstName.clear();
        firstName.fill(personalInfo[0]);
        lastName.clear();
        lastName.fill(personalInfo[1]);
        address.clear();
        address.fill(personalInfo[2]);
        city.clear();
        city.fill(personalInfo[3]);
        state.selectOption(personalInfo[4]);
        postcode.clear();
        postcode.fill(personalInfo[5]);
        country.selectOption(personalInfo[6]);
        phoneNumber.clear();
        phoneNumber.fill(personalInfo[7]);
        assertThat(saveAddressBtn).isEnabled();
        saveAddressBtn.click();
    }

}
