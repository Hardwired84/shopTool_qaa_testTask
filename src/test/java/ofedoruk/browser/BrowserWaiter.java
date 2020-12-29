package ofedoruk.browser;

import helpers.TimeOutConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

/**
 * @author - Oleksandr Fedoruk on 23.12.2020
 * @project shopTool_qaa_testTask.
 */
public class BrowserWaiter extends Browser {

  public void waitForElementDisplayed(final WebElement element, final long... msToWait) {
    long msToWaitLoc = msToWait.length > 0 ? msToWait[0] : TimeOutConstants.DEFAULT_TIMEOUT_10_000_MS;
    try {
      Waiter waiter = () -> waitUntilExpected(WebDriver -> {
        try {
          if (element.isDisplayed()) {
            logger.info(String.format("The element '%s' has been displayed.", element.toString()));
            return true;
          } else {
            logger.info(String.format("The element '%s' isn't displayed on the page. Waiting...", element.toString()));
            return false;
          }
        } catch (NoSuchElementException e) {
          logger.error(String.format("No such element '%s' exception: %s.", element.toString(), e.toString()));
          return false;
        } catch (StaleElementReferenceException e) {
          logger.error(String.format("Stale Element Reference Exception for element '%s': %s.", element.toString(), e.toString()));
          return false;
        }
      }, msToWaitLoc);
      waiter.applyWait();
    } catch (TimeoutException e) {
      throw new TimeoutException(String.format("The element '%s' is not displayed after timeout '%d' millisec(s).", element, msToWaitLoc));
    }
  }

  public <T> void waitUntilExpected(Function<WebDriver, T> function, final long... msToWait) {
    long msToWaitLoc = msToWait.length > 0 ? msToWait[0] : TimeOutConstants.DEFAULT_TIMEOUT_10_000_MS;
    WebDriverWait wait = new WebDriverWait(getDriver(), msToWaitLoc / 1000);
    long pollingInterval = TimeOutConstants.DEFAULT_POLLING_INTERVAL_500_MS;
    wait.pollingEvery(Duration.of(pollingInterval, ChronoUnit.MILLIS));
    wait.until(function);
  }
}
