package org.orange.hrm.automation.runners;

import io.cucumber.testng.CucumberOptions;
import org.orange.hrm.automation.base.TestBase;
import org.testng.annotations.Test;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(

        features = "src\\test\\resources\\features",
        glue = {"org.orange.hrm.automation.stepDefinitions"},
        tags = "@addEmployee or @login",
        monochrome = true,
        dryRun = false,
        snippets = CAMELCASE,
        plugin = {
                "pretty",
                "html:build/cucumber-reports/cucumber-report.html",
                "json:build/cucumber-report.json",
                "rerun:build/cucumber-report.txt",
        }

)

@Test
public class TestRunner extends TestBase {
}
