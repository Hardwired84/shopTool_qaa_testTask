package ofedoruk.tests.stepsdef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ofedoruk.browser.Browser;
import ofedoruk.components.NavigationComponent;
import ofedoruk.pages.BasePage;
import ofedoruk.pages.PageFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class CommonStepsDef {

  private static final NavigationComponent component = new NavigationComponent();
  static final Logger logger = LoggerFactory.getLogger(Browser.class);

  @When("^I return on previous page$")
  public void iReturnOnPreviousPage() {
    Browser.getDriver().navigate().back();
  }

  @When("^I select and click on random \"([^\"]*)\" item with discount on \"([^\"]*)\" page$")
  public void iSelectAndClickOnRandomItemWithDiscountOnДрелиPage(int numberOfElements, String identifier) {
    BasePage page = PageFactory.getPageByIdentifier(identifier);
    Random rand = new Random();
    for (int i = 0; i < numberOfElements; i++) {
      List<WebElement> linksToClick = page.getDiscountLink;
      int randomIndex = rand.nextInt(linksToClick.size());
      linksToClick.get(randomIndex).isDisplayed();
      linksToClick.get(randomIndex).click();
    }
  }

  @When("^I click on \"([^\"]*)\" button$")
  public void iClickOnButton(String buttonName) {
    component.getNavigationButton(buttonName).isDisplayed();
    component.clickButton(buttonName);
  }

  @When("^I click on \"([^\"]*)\" on \"([^\"]*)\" page$")
  public void iClickOnOnPage(String itemName, String identifier) throws TimeoutException {
    BasePage page = PageFactory.getPageByIdentifier(identifier);
    page.getLinkItem(itemName).click();
  }

  @When("^I click on header button \"([^\"]*)\" on \"([^\"]*)\"$")
  public void iClickOnHeaderButton(String buttonName, String identifier) {
    BasePage page = PageFactory.getPageByIdentifier(identifier);
    page.getButtonHeader(buttonName).getText();
  }

  @When("^I search for \"([^\"]*)\" item on \"([^\"]*)\"$")
  public void iSearchForItemOn(String searchedText, String identifier) {
    BasePage page = PageFactory.getPageByIdentifier(identifier);
    page.getSearchInputField().sendKeys(searchedText);
    page.getSearchInputField().submit();
  }

  @When("^I click on random \"([^\"]*)\" item on \"([^\"]*)\" page$")
  public void iSelectAndClickOnRandomItemOnPage(int numberOfElements, String identifier) {
    BasePage page = PageFactory.getPageByIdentifier(identifier);
    Random rand = new Random();
    for (int i = 0; i < numberOfElements; i++) {
      List<WebElement> linksToClick = page.getLabelsList;
      int randomIndex = rand.nextInt(linksToClick.size());
      linksToClick.get(randomIndex).isDisplayed();
      linksToClick.get(randomIndex).click();
    }
  }

  @Then("^I check \"([^\"]*)\" page is \"?(opened|closed)\"?$")
  public void iCheckPageIs(String identifier, String state) {
    BasePage page = PageFactory.getPageByIdentifier(identifier);
    boolean isOpened = "opened".equals(state);
    Assert.assertEquals(page.verify(), isOpened, String.format("Page '%s' is not '%s'", identifier, state));
  }

  @Then("^I check the count of items in the cart equal \"([^\"]*)\" on \"([^\"]*)\"$$")
  public void iCheckTheCountOfItemsInTheCartEqual(String expectedItemsCount, String identifier) {
    BasePage page = PageFactory.getPageByIdentifier(identifier);
    String actualItemsCount = page.getItemsCount().getText();
    Assert.assertTrue(expectedItemsCount.equals(actualItemsCount),
            String.format("The actual count of items '%s' doesn't equal to expected count '%s' on '%s' page",
                    actualItemsCount, expectedItemsCount, identifier));
  }

  @Then("^I check that for each searched item on \"([^\"]*)\" the Procraft label is \"?(displayed|not displayed)\"?$")
  public void iCheckThatForEachSearchedItemOnTheProcraftLabelIs(String identifier, String state) {
    BasePage page = PageFactory.getPageByIdentifier(identifier);
    boolean expectedState = "displayed".equals(state);
    page.getLabelsList.stream()
            .forEach(item -> {
              boolean actualState = item.isDisplayed();
              Assert.assertEquals(actualState, expectedState,
                      String.format("Actual state of procraft labels '%s' is not as expected '%s'",
                              actualState, expectedState));
            });
  }
}
