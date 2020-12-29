package ofedoruk.tests.stepsdef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ofedoruk.pages.BasePage;
import ofedoruk.pages.MainPage;
import ofedoruk.pages.PageFactory;
import org.testng.Assert;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class MainPageStepDef {
  private MainPage mainPage = (MainPage) PageFactory.getPageByIdentifier(MainPage.PAGE_IDENTIFIER);

  @When("^I open ShopTool Main page$")
  public void i_open_ShopTool_Main_page() {
    mainPage.open();
    mainPage.waitForPageLoaded();
  }

  @When("^I click on \"([^\"]*)\" menu item and wait for \"([^\"]*)\" page loaded$")
  public void iClickOnMenuItemAndWaitForPageLoaded(String itemName, String identifier) {
    mainPage.getMenuItem(itemName).click();
    PageFactory.getPageByIdentifier(identifier).waitForPageLoaded();
  }

  @Then("^I check ShopTool \"([^\"]*)\" page is \"?(opened|closed)\"?$")
  public void iCheckShopToolPageIs(String identifier, String state) {
    BasePage page = PageFactory.getPageByIdentifier(identifier);
    boolean isOpened = "opened".equals(state);
    Assert.assertEquals(page.verify(), isOpened,
            String.format("Page '%s' is not '%s'", identifier, state));
  }
}
