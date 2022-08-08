package Pages;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:test/report/cucumber_report.json","pretty", "html:target/cucumber"},
        features = {"src/test/resources/features/"},
        glue = {"Steps"},
        tags = ""
)
public class Runner {
    @AfterClass
    public static void clearDriver() {
        BasePage.closeBrowser();
    }

}


