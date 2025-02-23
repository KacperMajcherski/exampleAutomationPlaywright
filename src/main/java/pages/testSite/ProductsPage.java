package pages.testSite;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import pages.Pages;
import utils.TestMain;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsPage extends TestMain {

    public Locator item(String productName) {
        return page.locator("//a[contains(@class, 'product-name') and normalize-space(text()) = '" + productName.trim() + "']");
    }

    public Locator itemPage(String productName) {
        return page.locator("//h1[contains(@itemprop, 'name') and normalize-space(text()) = '" + productName.trim() + "']");
    }

    public Locator itemColor(String color) {
        return page.locator("//a[contains(@title, '" + color + "')]");
    }
    public Locator itemSize = page.locator("select#group_1");
    public Locator inStockLabel = page.locator("#availability_value");
    public Locator addToCart = page.locator("//button[@name='Submit' and contains(@class, 'exclusive')]");
    public Locator quantityField = page.locator("#quantity_wanted");
    public Locator itemsAvailable = page.locator("#quantityAvailable");
    public Locator successPopup = page.locator("div#layer_cart");
    public Locator checkoutBtn = page.locator("//span[contains(normalize-space(text()), 'Proceed to checkout')]");

    public void addItemToCart(String productName, int quantity, String size, String color) {
        assertThat(item(productName)).isVisible();
        item(productName).click();
        assertThat(itemPage(productName)).isVisible();
        itemSize.selectOption(new SelectOption().setLabel(size));
        page.waitForTimeout(500);
        assertThat(itemColor(color)).isVisible();
        itemColor(color).click();
        page.waitForTimeout(500);
        assertThat(inStockLabel).isVisible();
        assertThat(quantityField).isVisible();
        assertThat(itemsAvailable).isVisible();
        String quantityText = itemsAvailable.textContent();
        int itemsInStock = Integer.parseInt(quantityText.trim());
        if (itemsInStock >= quantity) {
            quantityField.fill(String.valueOf(quantity));
            page.waitForTimeout(500);
            assertThat(addToCart).isVisible();
            addToCart.click();
            assertThat(successPopup).isVisible();
            assertThat(checkoutBtn).isVisible();
            checkoutBtn.click();
            assertThat(Pages.checkoutPage.pageTitle).isVisible();
        }
        else System.out.println("Not enough items in stock");

    }

}
