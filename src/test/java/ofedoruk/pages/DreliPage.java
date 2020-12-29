package ofedoruk.pages;

import ofedoruk.browser.Browser;
import helpers.PropertiesLoader;
import helpers.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class DreliPage extends BasePage {

  public static final String PAGE_IDENTIFIER = "Дрели";
  private static final String PAGE_URL = PropertiesLoader.getBaseUrl() + "/elektroinstrument/dreli/";

  private static final String PAGE_TITLE_XPATH = "//div[@class='ut2-extra-block-title']/h1/span";
  private static final String ITEM_NAME_XPATH = "//div[@class='ut2-gl__name']/a[text()='%s']";

  @Override
  public boolean verify() {
    return Browser.getDriver().getCurrentUrl().contains(PAGE_URL)
            && getPageHeader().isDisplayed();
  }

  @Override
  public void waitForPageLoaded() {
    Browser.waiter().waitForElementDisplayed(getPageHeader(), TimeOutConstants.DEFAULT_TIMEOUT_5_000_MS);
  }

  public WebElement getPageHeader() {
    return Browser.getDriver().findElement(getPageTitleXpath());
  }

  public WebElement getCard(String itemName) {
    return Browser.getDriver().findElement(getItemCardXpath(itemName));
  }


  private By getPageTitleXpath() {
    return By.xpath(PAGE_TITLE_XPATH);
  }

  private By getItemCardXpath(String itemName) {
    String xpath = String.format(ITEM_NAME_XPATH, itemName);
    return By.xpath(xpath);
  }
}
