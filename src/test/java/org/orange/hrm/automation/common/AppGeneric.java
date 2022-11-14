package org.orange.hrm.automation.common;

import org.openqa.selenium.WebDriver;
import org.orange.hrm.automation.constants.GlobalConstants;

import java.util.concurrent.TimeUnit;

public class AppGeneric {

    public WebDriver driver;
    GlobalConstants globalConstants;

    public AppGeneric(WebDriver driver) {
        this.driver = driver;
    }

}
