package ofedoruk.pages;

import ofedoruk.browser.Browser;
import helpers.PropertiesLoader;
import helpers.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class PerforatoryPage extends BasePage {

  public static final String PAGE_IDENTIFIER = "Перфораторы";
  private static final String PAGE_URL = PropertiesLoader.getBaseUrl() + "/elektroinstrument/perforatory/";

  private static final String PAGE_TITLE_XPATH = "//div[@class='ut2-extra-block-title']/h1/span";
  private static final String LIST_OF_LINKS_WITH_DISCOUNT_XPATH = "//div[contains(@class,'ty-product-labels__item--discount')]//ancestor::div[@class='ut2-gl__body']";

  @Override
  public boolean verify() {
//    return Browser.getDriver().getCurrentUrl().equals(PAGE_URL)
    return getPageHeader().isDisplayed();
  }

  @Override
  public void waitForPageLoaded() {
    Browser.waiter().waitForElementDisplayed(getPageHeader(), TimeOutConstants.DEFAULT_TIMEOUT_5_000_MS);
  }

  public WebElement getPageHeader() {
    return Browser.getDriver().findElement(getPageTitleXpath());
  }

  public List<WebElement> getDiscountLink = Browser.getDriver().findElements(getLinksWithDiscountXpath());

  private By getPageTitleXpath() {
    return By.xpath(PAGE_TITLE_XPATH);
  }

  private By getLinksWithDiscountXpath() {
    return By.xpath(LIST_OF_LINKS_WITH_DISCOUNT_XPATH);
  }
}
