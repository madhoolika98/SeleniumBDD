package org.orange.hrm.automation.base;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.orange.hrm.automation.constants.GlobalConstants;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    GlobalConstants globalConstants;
    String browserMode = null;
    String targetBrowser = null;
    String environment = null;

    public void initSetup() throws Exception {
        globalConstants = new GlobalConstants();
        browserMode = System.getProperty("mode");
        targetBrowser = System.getProperty("browser");
        environment = System.getProperty("env");
        if(browserMode!=null && targetBrowser!=null && environment!=null)
        {
            if (targetBrowser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", globalConstants.chromeDriverPath);
                driver = new ChromeDriver(this.getChromeWebDriverOptions(browserMode));
            } else if (targetBrowser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", globalConstants.edgeDriverPath);
                //Headless version is not supported for edge as of now so test case runs on a head mode
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            Thread.sleep(1000);
            switch (environment)
            {
                case "qa": driver.get(globalConstants.appURLQA);
                            break;
                case "prod": driver.get(globalConstants.appURLProd);
                            break;
            }
            Thread.sleep(1000);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown() throws Exception {
        System.out.println("Scenario Execution Completed Successfully");
        //Closing the WebDriver
        driver.close();
        driver.quit();
    }

    public String[] getBrowserArguments(String browserMode) {
        String[] browserArguments = null;

        String argumentsString= null;
        switch(browserMode)
        {
            case "headless": argumentsString = globalConstants.HeadlessMode;
                            break;

            case "headmode": argumentsString = globalConstants.HeadMode;
                            break;
        }
        if (argumentsString != null && (argumentsString = argumentsString.trim()).length() > 0) {
            browserArguments = argumentsString.split(";");

            if (browserArguments != null && browserArguments.length == 0) {
                // Return null instead of empty array.
                browserArguments = null;
            }
        }

        argumentsString = null;

        return browserArguments;
    }

    public ChromeOptions getChromeWebDriverOptions(String browserMode) {
        ChromeOptions chromeBrowserOptions = null;
        String[] browserArguments = getBrowserArguments(browserMode);
        chromeBrowserOptions = new ChromeOptions();
        if (browserArguments != null && browserArguments.length > 0) {
            chromeBrowserOptions.addArguments(browserArguments);
        }

        browserArguments = null;

        return chromeBrowserOptions;
    }

    public EdgeOptions getEdgeWebDriverOptions(String browserMode) {
        EdgeOptions edgeBrowserOptions = null;
        String[] browserArguments = getBrowserArguments(browserMode);
        edgeBrowserOptions = new EdgeOptions();
        if (browserArguments != null && browserArguments.length > 0) {
            edgeBrowserOptions.addArguments(browserArguments);
        }

        browserArguments = null;

        return edgeBrowserOptions;
    }

    public static byte[] getByteScreenshot ()
    {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

}
