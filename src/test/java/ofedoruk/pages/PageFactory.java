package ofedoruk.pages;

import ofedoruk.components.BaseDialog;

import java.util.HashMap;
import java.util.Map;

/**
 * @author - Oleksandr Fedoruk on 27.12.2020
 * @project shopTool_qaa_testTask.
 */
public class PageFactory {

  private static final ThreadLocal<Map<String, Object>> pageMapper = new ThreadLocal<>();
  private static final ThreadLocal<Map<String, Object>> dialogMapper = new ThreadLocal<>();

  public static BasePage getPageByIdentifier(String identifier) {
    Object obj = getPageByClassIdentifier(identifier);
    if (obj instanceof BasePage) {
      return (BasePage) obj;
    } else {
      throw new IllegalArgumentException(String.format("Page '%s' does not extend class BasePage", obj.getClass().getName()));
    }
  }

  public static BaseDialog getDialogByIdentifier(String identifier) {
    Object obj = getDialogByClassIdentifier(identifier);
    if (obj instanceof BaseDialog) {
      return (BaseDialog) obj;
    } else {
      throw new IllegalArgumentException(String.format("Page '%s' does not extend class BasePage", obj.getClass().getName()));
    }
  }


  private static Object getPageByClassIdentifier(String classIdentifier) {
    if (pageMapper.get() == null) {
      pageMapper.set(new HashMap<>());
    }
    return pageMapper.get().computeIfAbsent(classIdentifier, PageFactory::initPage);
  }

  private static Object getDialogByClassIdentifier(String classIdentifier) {
    if (dialogMapper.get() == null) {
      dialogMapper.set(new HashMap<>());
    }
    return dialogMapper.get().computeIfAbsent(classIdentifier, PageFactory::initDialog);
  }

  private static Object initPage(String identifier) {
    switch (identifier) {
      case MainPage.PAGE_IDENTIFIER:
        return new MainPage();
      case ElektroinstrumentPage.PAGE_IDENTIFIER:
        return new ElektroinstrumentPage();
      case PerforatoryPage.PAGE_IDENTIFIER:
        return new PerforatoryPage();
      case ItemsCardPage.PAGE_IDENTIFIER:
        return new ItemsCardPage();
      case DreliPage.PAGE_IDENTIFIER:
        return new DreliPage();
      case SearchResultPage.PAGE_IDENTIFIER:
        return new SearchResultPage();
      default:
        throw new IllegalArgumentException(
                String.format("Page identifier '%s' is not found", identifier));
    }
  }

  private static Object initDialog(String identifier) {
    switch (identifier) {
      case ModalDialog.DIALOG_IDENTIFIER:
        return new ModalDialog();
      default:
        throw new IllegalArgumentException(
                String.format("Dialog identifier '%s' is not found", identifier));
    }
  }
}
