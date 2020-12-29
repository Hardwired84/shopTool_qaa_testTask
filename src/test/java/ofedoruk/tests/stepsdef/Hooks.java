package ofedoruk.tests.stepsdef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import ofedoruk.browser.Browser;

/**
 * @author - Oleksandr Fedoruk on 26.12.2020
 * @project shopTool_qaa_testTask.
 */
public class Hooks {
  @Before
  public void setUp() {
    Browser.setBrowserPosition();
    Browser.setBrowserSize();
  }

  @After
  public void tearDown() {
    Browser.closeDriver();
  }
}
