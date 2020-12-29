package ofedoruk.pages;

import ofedoruk.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public abstract class BasePage {
  private static final String HEADER_XPATH = "//div//h1[@class='ty-mainbox-title']/span";
  private static final String LIST_OF_LINKS_WITH_DISCOUNT_XPATH = "//div[contains(@class,'ty-product-labels__item--discount')]//ancestor::div[@class='ut2-gl__body']";
  private static final String LINK_ITEM_XPATH = "//div[@class='ut2-gl__name']//a[@title='%s']";
  private static final String BUTTON_HEADER_XPATH = "//div[@class='ty-dropdown-box']//span[text()='%s']//i[@class='ut2-icon-outline-expand_more']";
  private static final String LABEL_ITEMS_COUNT_XPATH = "//div[@class='ty-dropdown-box']//span[@class='ty-minicart-count']";
  private static final String INPUT_FIELD_XPATH = "//form//input[@id='search_input']";
  private static final String LIST_OF_LABELS_XPATH = "//div[@class='brand-img']";

  public abstract boolean verify();

  public abstract void waitForPageLoaded();

  public WebElement getPageHeader() {
    return Browser.getDriver().findElement(getHeaderXpath());
  }

  public List<WebElement> getDiscountLink = Browser.getDriver().findElements(getLinksWithDiscountXpath());

  public WebElement getLinkItem(String itemName) {
    return Browser.getDriver().findElement(getLinkItemXpath(itemName));
  }

  public WebElement getButtonHeader(String buttonName) {
    return Browser.getDriver().findElement(getHeaderButtonXpath(buttonName));
  }

  public WebElement getItemsCount() {
    return Browser.getDriver().findElement(getItemsCountXpath());
  }

  public WebElement getSearchInputField() {
    return Browser.getDriver().findElement(getInputSearchFieldXpath());
  }

  public List<WebElement> getLabelsList = Browser.getDriver().findElements(getLabelsListXpath());

  private By getHeaderXpath() {
    return By.xpath(HEADER_XPATH);
  }

  private By getLinksWithDiscountXpath() {
    return By.xpath(LIST_OF_LINKS_WITH_DISCOUNT_XPATH);
  }

  private By getLinkItemXpath(String itemName) {
    String xpath = String.format(LINK_ITEM_XPATH, itemName);
    return By.xpath(xpath);
  }

  private By getHeaderButtonXpath(String buttonName) {
    String xpath = String.format(BUTTON_HEADER_XPATH, buttonName);
    return By.xpath(xpath);
  }

  private By getItemsCountXpath() {
    return By.xpath(LABEL_ITEMS_COUNT_XPATH);
  }

  private By getInputSearchFieldXpath() {
    return By.xpath(INPUT_FIELD_XPATH);
  }

  private By getLabelsListXpath() {
    return By.xpath(LIST_OF_LABELS_XPATH);
  }
}
