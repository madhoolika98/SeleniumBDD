package org.orange.hrm.automation.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.orange.hrm.automation.base.TestBase;

public class Hook extends TestBase {

    public static String scenarioName;
    WebDriver driver;
    Scenario lscenario;

    @Before
    public void before(Scenario scenario) throws Exception {
        scenarioName = scenario.getName();
        initSetup();
        driver = getDriver();
        lscenario = scenario;
    }

    @After
    public void after(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            System.out.println("driver::"+driver);
            try {
                scenario.attach(getByteScreenshot(), "image/png", scenario.getName() + " is failed , Please check log output for more details");
            } catch (Exception e) {
                e.getMessage();
            }
        }
        tearDown();
    }

}
