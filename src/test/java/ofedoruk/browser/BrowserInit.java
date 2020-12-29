package ofedoruk.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import helpers.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.bonigarcia.wdm.DriverManagerType.*;

/**
 * @author - Oleksandr Fedoruk on 23.12.2020
 * @project shopTool_qaa_testTask.
 */
public class BrowserInit {

  private static String browserName;
  private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
  static final Logger logger = LoggerFactory.getLogger(Browser.class);
  private static String chromeVersion = "87.0.4280.88";


  public enum BrowserName {
    EDGE("edge"),
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String name;

    BrowserName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  public static WebDriver getDriver() {
    if (webdriver.get() == null) {
      browserName = PropertiesLoader.getBrowserName();
      init(browserName);
    }
    return webdriver.get();
  }

  public static void closeDriver() {
    if (webdriver.get() != null) {
      logger.info("======Closing browser======");
      try {
        getDriver().close();
        getDriver().quit();
      } catch (Exception e) {
        logger.warn(e.getMessage());
      } finally {
        webdriver.remove();
        browserName = null;
        logger.info("The driver has been closed.");
      }
    }
  }

  private static void init(String browser) {
    BrowserName name = BrowserName.valueOf(BrowserName.class, browser.toUpperCase());
    switch (name) {
      case FIREFOX:
        logger.info("======Setting up Firefox browser======");
        WebDriverManager.getInstance(FIREFOX).setup();
        webdriver.set(new FirefoxDriver());
        break;
      case CHROME:
        logger.info("======Setting up Chrome browser======");
        WebDriverManager.getInstance(CHROME).version(chromeVersion).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        webdriver.set(new ChromeDriver(options));
        break;
      case EDGE:
        logger.info("======Setting up Edge browser======");
        WebDriverManager.getInstance(EDGE).setup();
        webdriver.set(new EdgeDriver());
        break;
      default:
        logger.error(String.format("Can't find driver for '%s' browser", browser));
        throw new IllegalArgumentException(String.format("Can't initialize browser '%s'", browser));
    }
  }
}
