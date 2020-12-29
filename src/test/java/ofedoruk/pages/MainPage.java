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
public class MainPage extends BasePage {

  public static final String PAGE_IDENTIFIER = "Main";
  private static final String PAGE_URL = PropertiesLoader.getBaseUrl();

  private static final String MAIN_PAGE_LOGO_XPATH = "//div[@class='top-logo ']";
  private static final String MAIN_PAGE_BANNER_CSS = "#banner_slider_3331 > div.owl-wrapper-outer > div";
  private static final String MENU_ITEMS_XPAT = "//li[contains(@class,'ty-menu__item')]//span/bdi[text()='%s']";

  public void open() {
    Browser.getDriver().navigate().to(PAGE_URL);
  }

  @Override
  public boolean verify() {
    return getMainPageLogo().isDisplayed()
            && Browser.getDriver().getCurrentUrl().equals(PAGE_URL);
  }

  @Override
  public void waitForPageLoaded() {
    Browser.waiter().waitForElementDisplayed(getMainPageBanner(), TimeOutConstants.DEFAULT_TIMEOUT_5_000_MS);
  }

  public WebElement getMainPageLogo() {
    return Browser.getDriver().findElement(getMainPageLogoXpath());
  }

  public WebElement getMainPageBanner() {
    return Browser.getDriver().findElement(getMainPageBannerCss());
  }

  public WebElement getMenuItem(String itemName) {
    return Browser.getDriver().findElement(getMenuItemsXpath(itemName));
  }


  private By getMainPageLogoXpath() {
    return By.xpath(MAIN_PAGE_LOGO_XPATH);
  }

  private By getMainPageBannerCss() {
    return By.cssSelector(MAIN_PAGE_BANNER_CSS);
  }

  private By getMenuItemsXpath(String itemName) {
    String xpath = String.format(MENU_ITEMS_XPAT, itemName);
    return By.xpath(xpath);
  }
}
