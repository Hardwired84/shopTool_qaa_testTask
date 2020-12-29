package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author - Oleksandr Fedoruk on 23.12.2020
 * @project shopTool_qaa_testTask.
 */
public class PropertiesLoader {
  private static final String pathToBrowserPropertyFile = "src/test/resources/properties/browser.properties";
  private static final String pathToShopToolPropertyFile = "src/test/resources/properties/shoptool.properties";

  public static String getBaseUrl() {
    return getProperty(pathToShopToolPropertyFile, "baseUrl");
  }

  public static String getBrowserName() {
    return getProperty(pathToBrowserPropertyFile, "browserName");
  }

  public static String getBrowserWidth() {
    return getProperty(pathToBrowserPropertyFile, "resolutionWidth");
  }

  public static String getBrowserHeight() {
    return getProperty(pathToBrowserPropertyFile, "resolutionHeight");
  }

  public static String getProperty(String pathToPropertyFile, String key) {
    return getValuePipeline(pathToPropertyFile, key);
  }

  public static Properties getPropertyFile(String pathToPropertyFile) {
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream(pathToPropertyFile));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties;
  }

  private static String getPropertyValueFromFile(String pathToPropertyFile, String key) {
    return getPropertyFile(pathToPropertyFile).getProperty(key);
  }

  private static String getValuePipeline(String pathToPropertyFile, String key) {
    String localProperty = getPropertyValueFromFile(pathToPropertyFile, key);
    if (localProperty != null) {
      return localProperty;
    }
    return "Property Value is not defined";
  }
}