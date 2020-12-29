package ofedoruk.tests.stepsdef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ofedoruk.components.BaseDialog;
import ofedoruk.pages.ModalDialog;
import ofedoruk.pages.PageFactory;
import org.testng.Assert;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class ModalDialogStepsDef {

  private ModalDialog modalDialog = (ModalDialog) PageFactory.getDialogByIdentifier(ModalDialog.DIALOG_IDENTIFIER);

  @When("^I click on \"([^\"]*)\" footer button$")
  public void iClickOnFooterButton(String buttonName) {
    modalDialog.getFooterButton(buttonName).click();
  }

  @When("^I wait for modal dialog is loaded$")
  public void iWaitForModalDialogIsLoaded() {
    modalDialog.waitForDialogLoaded();
  }

  @Then("^I check the \"([^\"]*)\" modal dialog is \"?(displayed|not displayed)\"?$")
  public void iCheckTheModalDialogIs(String identifier, String state) {
   BaseDialog dialog = PageFactory.getDialogByIdentifier(identifier);
   boolean isDisplayed = "displayed".equals(state);
   Assert.assertEquals(dialog.verify(), isDisplayed, String.format("Dialog '%s' is not '%s'", identifier, state));
    Assert.assertTrue(dialog.getModalDialog().isDisplayed());
  }

  @Then("^I check the modal dialog is \"?(displayed|not displayed)\"?$")
  public void iCheckTheModalDialogIs(String state) {
    ModalDialog dialog = new ModalDialog();
    boolean isDisplayed = "displayed".equals(state);
    Assert.assertEquals(dialog.verify(), isDisplayed, String.format("Dialog is not '%s'", state));
  }
}
