package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = {"@UC_01,@UC_02,@UC_03,@UC_04,@cmr1,@cmr2,@cmr3"},
    strict = true,
    plugin = { "pretty", "html:target/cucumber-reports/reports" },
    monochrome = true
)

public class ActivitiesRunner {

}
