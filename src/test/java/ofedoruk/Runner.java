package ofedoruk;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author - Oleksandr Fedoruk on 26.12.2020
 * @project shopTool_qaa_testTask.
 */
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepsdef"},
        tags = {"not @Ignore"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)

public class Runner extends AbstractTestNGCucumberTests {
}