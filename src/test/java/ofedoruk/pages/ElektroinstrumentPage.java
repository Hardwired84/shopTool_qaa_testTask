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
public class ElektroinstrumentPage extends BasePage {

  public static final String PAGE_IDENTIFIER = "Электроинструмент";
  private static final String PAGE_URL = PropertiesLoader.getBaseUrl() + "/elektroinstrument/";

  private static final String PAGE_TITLE_XPATH = "//div[@class='ut2-extra-block-title']/h1/span";
  private static final String LINK_ITEMS_XPATH = "//div[@class='cat-title']/a[text()='%s']";

  @Override
  public boolean verify() {
    return Browser.getDriver().getCurrentUrl().equals(PAGE_URL)
            && getPageHeader().isDisplayed();
  }

  @Override
  public void waitForPageLoaded() {
    Browser.waiter().waitForElementDisplayed(getPageHeader(), TimeOutConstants.DEFAULT_TIMEOUT_5_000_MS);
  }

  public WebElement getPageHeader() {
    return Browser.getDriver().findElement(getPageTitleXpath());
  }

  public WebElement getLinks(String linkName) {
    return Browser.getDriver().findElement(getLinksXpath(linkName));
  }

  private By getPageTitleXpath() {
    return By.xpath(PAGE_TITLE_XPATH);
  }

  private By getLinksXpath(String itemName) {
    String xpath = String.format(LINK_ITEMS_XPATH, itemName);
    return By.xpath(xpath);
  }
}
