package org.orange.hrm.automation.common;

import org.openqa.selenium.WebDriver;
import org.orange.hrm.automation.base.TestBase;
import org.orange.hrm.automation.constants.GlobalConstants;

import java.util.concurrent.TimeUnit;

public class Generic {

    GlobalConstants globalConstants;
    WebDriver driver;

    public Generic(WebDriver ldriver){

        this.driver = ldriver;
        globalConstants = new GlobalConstants();
    }

    /**
     * Description: Method to verify Text
     * @param sActualText
     * @param sExpectedText
     * @param verifyTextOptions
     * @return
     */
    public boolean verifyText(String sActualText, String sExpectedText, String verifyTextOptions){
        boolean result=true;
        try{
            switch (verifyTextOptions.toUpperCase()) {
                case "EXACTMATCH":
                    result = sActualText.equals(sExpectedText);
                    break;
                case "EXACTMATCHIGNORECASE":
                    sActualText=sActualText.trim();
                    sExpectedText=sExpectedText.trim();
                    result=sActualText.equalsIgnoreCase(sExpectedText);
                    break;
                case "PARTIAL":
                    sActualText=sActualText.trim().toLowerCase();
                    sExpectedText=sExpectedText.trim().toLowerCase();
                    result = sActualText.contains(sExpectedText);
                    break;
            }

        }catch (Exception e) {
            result=false;
        }
        return result;
    }

    /**
     * Description: Validate current page url
     * @param pageName
     * @return
     */

    public boolean validatePageUrl(String pageName) throws Exception{
        boolean retVal = false;
        try {
            if(driver.getCurrentUrl().contains(pageName)) {
                retVal = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return retVal;
    }

    public void waitForShortTimeOut() throws InterruptedException {
        long timeUnit = globalConstants.SHORT_TIMEOUT * 1000;
        Thread.sleep(timeUnit);
    }

    public void waitForMediumTimeOut() throws InterruptedException {
        long timeUnit = globalConstants.MEDIUM_TIMEOUT * 1000;
        Thread.sleep(timeUnit);
    }

    public void waitForLongTimeOut() throws InterruptedException {
        long timeUnit = globalConstants.LONG_TIMEOUT * 1000;
        Thread.sleep(timeUnit);
    }
}
