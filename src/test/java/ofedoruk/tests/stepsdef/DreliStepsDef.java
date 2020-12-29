package ofedoruk.tests.stepsdef;

import cucumber.api.java.en.When;
import ofedoruk.browser.Browser;
import ofedoruk.pages.DreliPage;
import ofedoruk.pages.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class DreliStepsDef {

  private DreliPage dreli = (DreliPage) PageFactory.getPageByIdentifier(DreliPage.PAGE_IDENTIFIER);

  @When("^I hover on \"([^\"]*)\" item$")
  public void iHoverOnItem(String itemName) {
    WebDriver driver = Browser.getDriver();
    Actions action = new Actions(driver);
    WebElement card = dreli.getCard(itemName);
    action.moveToElement(card).build().perform();
  }
}
