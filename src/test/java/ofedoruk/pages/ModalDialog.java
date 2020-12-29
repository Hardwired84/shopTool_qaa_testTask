package ofedoruk.pages;

import ofedoruk.browser.Browser;
import ofedoruk.components.BaseDialog;
import helpers.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class ModalDialog extends BaseDialog {

  public static final String DIALOG_IDENTIFIER = "Товар добавлен в корзину";

  private static final String MODAL_DIALOG_TITLE_XPATH = "//div[contains(@class,'cm-notification-content')]/h1";
  private static final String BUTTON_FOOTER_XPATH = "//div[contains(@class,'ty-product-notification__buttons')]//a//span[text()='%s']";
  //private static final String BUTTON_CLOSE = "//div[contains(@class,'cm-notification-content')]//span[contains(@class,'cm-notification-close')]";
  private static final String MODAL_DIALOG_COMMON_XPATH = "//div[contains(@class,'cm-notification-content-extended')]";

  @Override
  public boolean verify() {
    return getModalDialog().isDisplayed();
  }

  @Override
  public void waitForDialogLoaded() {
    Browser.waiter().waitForElementDisplayed(getModalDialog(), TimeOutConstants.DEFAULT_POLLING_INTERVAL_30_000_MS);
  }

/*  public WebElement getModalDialogTitle() {
  return Browser.getDriver().findElement(getDialogTitleXpath());
 }*/

  public WebElement getFooterButton(String buttonName) {
    return Browser.getDriver().findElement(getFooterButtonXpath(buttonName));
  }

  @Override
  public WebElement getModalDialog() {
    return Browser.getDriver().findElement(getModalDialogXpath());
  }

  private By getFooterButtonXpath(String buttonNmae) {
    String xpath = String.format(BUTTON_FOOTER_XPATH, buttonNmae);
    return By.xpath(xpath);
  }

  private By getDialogTitleXpath() {
    return By.xpath(MODAL_DIALOG_TITLE_XPATH);
  }

  private By getModalDialogXpath() {
    return By.xpath(MODAL_DIALOG_COMMON_XPATH);
  }
}
