package ofedoruk.pages;

import ofedoruk.browser.Browser;
import helpers.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class SearchResultPage extends BasePage {

  public static final String PAGE_IDENTIFIER = "Результаты поиска";

  private static final String SEARCH_RESULT_PAGE_TITLE_XPATH = "//div[contains(@class,'ty-mainbox-container')]/h1/span[@class='ty-mainbox-title__left']";

  @Override
  public boolean verify() {
    return getPageHeader().getText().equalsIgnoreCase(PAGE_IDENTIFIER);
  }

  @Override
  public void waitForPageLoaded() {
    Browser.waiter().waitForElementDisplayed(getPageHeader(), TimeOutConstants.DEFAULT_TIMEOUT_5_000_MS);
  }

  public WebElement getPageHeader() {
    return Browser.getDriver().findElement(getPageTitleXpath());
  }

  private By getPageTitleXpath() {
    return By.xpath(SEARCH_RESULT_PAGE_TITLE_XPATH);
  }
}
