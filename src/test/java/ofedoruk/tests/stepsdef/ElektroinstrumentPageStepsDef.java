package ofedoruk.tests.stepsdef;

import cucumber.api.java.en.When;
import ofedoruk.pages.ElektroinstrumentPage;
import ofedoruk.pages.PageFactory;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class ElektroinstrumentPageStepsDef {

  private ElektroinstrumentPage electroinstrumentPage = (ElektroinstrumentPage) PageFactory.getPageByIdentifier(ElektroinstrumentPage.PAGE_IDENTIFIER);

  @When("^I click on \"([^\"]*)\" link on 'Электроинструмент' wait for \"([^\"]*)\" page loaded$")
  public void iClickOnLinkOnWaitForPageLoaded(String linkName, String identifier) {
    electroinstrumentPage.getLinks(linkName).click();
    PageFactory.getPageByIdentifier(identifier).waitForPageLoaded();
  }
}
