package ofedoruk.components;

import ofedoruk.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author - Oleksandr Fedoruk on 26.12.2020
 * @project shopTool_qaa_testTask.
 */
public class NavigationComponent implements WithNavigationComponent {
  private static final String BUTTON_NAVIGATION_XPATH = "//div[@class='ty-pagination']//a[text()='%s']";

  @Override
  public void clickButton(String buttonName) {
    getNavigationButton(buttonName).click();
  }

  public WebElement getNavigationButton(String buttonName) {
    return Browser.getDriver().findElement(getButton(buttonName));
  }

  private By getButton(String buttonName) {
    String xpath = String.format(BUTTON_NAVIGATION_XPATH, buttonName);
    return By.xpath(xpath);
  }
}
