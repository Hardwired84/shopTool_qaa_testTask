package ofedoruk.components;

import org.openqa.selenium.WebElement;

/**
 * @author - Oleksandr Fedoruk on 26.12.2020
 * @project shopTool_qaa_testTask.
 */
public abstract class BaseDialog {

  public abstract boolean verify();

  public abstract void waitForDialogLoaded();

  public abstract WebElement getModalDialog();
}
