package ofedoruk.tests.stepsdef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ofedoruk.pages.ItemsCardPage;
import ofedoruk.pages.PageFactory;
import org.testng.Assert;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class ItemsCardPageStepsDef {

  private ItemsCardPage itemsCardPage = (ItemsCardPage) PageFactory.getPageByIdentifier(ItemsCardPage.PAGE_IDENTIFIER);

  @When("^I add an item to cart$")
  public void iAddAnItemToBasket() {
    itemsCardPage.getSubmitButton().click();
  }

  @Then("^I check items card is \"?(opened|closed)\"?$")
  public void iCheckItemsCardIs(String state) {
    boolean isOpened = "opened".equals(state);
    Assert.assertEquals(itemsCardPage.verify(), isOpened, String.format("Items card page is not '%s'", state));
  }

  @Then("^I check items price with discount is \"?(displayed|not displayed)\"? on items card$")
  public void iCheckItemsPriceIsOnItemsCard(String state) {
    boolean isDisplayed = "displayed".equals(state);
    Assert.assertEquals(itemsCardPage.getItemDiscountedPrice().isDisplayed(), isDisplayed,
            String.format("Items price page is not '%s'", state));
  }

  @Then("^I check items old price is \"?(displayed|not displayed)\"? on items card$")
  public void iCheckItemsOldPriceIsOnItemsCard(String state) {
    boolean isDisplayed = "displayed".equals(state);
    Assert.assertEquals(itemsCardPage.getOldItemsPrice().isDisplayed(), isDisplayed,
            String.format("Items price page is not '%s'", state));
  }

  @Then("^I check the discounted price is less then old price$")
  public void iCheckTheDiscountedPriceIsLessThenOldPrice() {
    double dicountedPrice = Double.parseDouble((itemsCardPage.getItemDiscountedPrice().getText()).replace(",", ""));
    double oldPrice = Double.parseDouble(itemsCardPage.getOldItemsPrice().getText().replace(",", "").replace("грн", ""));
    Assert.assertTrue(oldPrice > dicountedPrice,
            String.format("Old price '%s' is less than discounted price '%s'",
                    oldPrice, dicountedPrice));
  }
}
