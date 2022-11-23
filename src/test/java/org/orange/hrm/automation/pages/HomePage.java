package org.orange.hrm.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage {


    /*
       ###################################################################################
       ######################                                      #######################
       ######################    Home Page   -  WebElements      #######################
       ######################                                      #######################
       ###################################################################################
   */


    class HomePageObjects {

        @FindBy(xpath = "(//p[@class='oxd-userdropdown-name']")
        @CacheLookup
        private WebElement employeeDropDown;

        @FindBy(xpath = "(//a[contains(.,'Logout')]")
        @CacheLookup
        private WebElement logoutOption;
    }
}
