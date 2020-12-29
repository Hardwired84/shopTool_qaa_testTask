package ofedoruk.pages;

import ofedoruk.browser.Browser;
import helpers.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class ItemsCardPage extends BasePage {

  public static final String PAGE_IDENTIFIER = "Карточка товара";

  private static final String ITEMS_CARD_TITLE_XPATH = "//h1[@class='ut2-pb__title']/bdi";
  private static final String ITEM_PRICE_WITH_DISCOUNT_XPATH = "//div[@class='ut2-pb__price-actual']//span[contains(@id,'sec_discounted_price')]";
  private static final String ITEM_OLD_PRICE_XPATH = "//div[@class='ty-product-prices']//span[contains(@id,'line_old_price')]";
  private static final String BUTTON_SUBMIT_XPATH = "//button[@type='submit']//i[@class='ut2-icon-outline-cart']";


  @Override
  public boolean verify() {
    return getPageHeader().isDisplayed();
  }

  @Override
  public void waitForPageLoaded() {
    Browser.waiter().waitForElementDisplayed(getPageHeader(), TimeOutConstants.DEFAULT_TIMEOUT_5_000_MS);
  }

  public WebElement getPageHeader() {
    return Browser.getDriver().findElement(getPageTitleXpath());
  }

  public WebElement getItemDiscountedPrice() {
    return Browser.getDriver().findElement(getDiscountedPriceXpath());
  }

  public WebElement getOldItemsPrice() {
    return Browser.getDriver().findElement(getOldPriceXpath());
  }

  public WebElement getSubmitButton() {
    return Browser.getDriver().findElement(getSubmitButtonXpath());
  }

  private By getPageTitleXpath() {
    return By.xpath(ITEMS_CARD_TITLE_XPATH);
  }

  private By getDiscountedPriceXpath() {
    return By.xpath(ITEM_PRICE_WITH_DISCOUNT_XPATH);
  }

  private By getOldPriceXpath() {
    return By.xpath(ITEM_OLD_PRICE_XPATH);
  }

  private By getSubmitButtonXpath() {
    return By.xpath(BUTTON_SUBMIT_XPATH);
  }

}
