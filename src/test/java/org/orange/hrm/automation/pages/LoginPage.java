package org.orange.hrm.automation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.orange.hrm.automation.base.TestBase;
import org.orange.hrm.automation.common.Generic;
import org.orange.hrm.automation.constants.GlobalConstants;

public class LoginPage extends TestBase {

    GlobalConstants globalConstants;
    Generic generic;
    public LoginPage.LoginPageObjects loginPageObjects;

    /**
     * Constructor
     * @param
     */
    public LoginPage()
    {
        globalConstants = new GlobalConstants();
        generic = new Generic(TestBase.driver);
        loginPageObjects = new LoginPage.LoginPageObjects();
        PageFactory.initElements(getDriver(),loginPageObjects);
    }

    /**
     * Description: Method is used to verify Page Title
     * @return
     * @throws Exception
     */
    public boolean verifyPageTitle() throws Exception {
        generic.waitForLongTimeOut();
        boolean retval = false;
        try {
            retval = generic.verifyText(getDriver().getTitle(),globalConstants.orangeHRMTitle,globalConstants.VERIFY_TEXT_EXACTMATCH);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return retval;
    }


    /**
     * Description: This is method is created for login
     * @throws Exception
     */
    public void login(String uname , String password) throws Exception {
        try {
                loginPageObjects.username.sendKeys(uname);
                loginPageObjects.password.sendKeys(password);
                loginPageObjects.loginBtn.click();
                generic.waitForLongTimeOut();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Description: This is method is created for login
     * @throws Exception
     */
    public void login() throws Exception {
        try {
            loginPageObjects.username.sendKeys(globalConstants.userName);
            loginPageObjects.password.sendKeys(globalConstants.passWord);
            loginPageObjects.loginBtn.click();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Description: Validate user is logged into the application
     * @throws Exception
     */
    public Boolean validateUserLogin() throws Exception
    {
        Boolean profileIsDisplayed = false;
        try {
           profileIsDisplayed = loginPageObjects.employeeProfile.isDisplayed();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return profileIsDisplayed;
    }

    /*
       ###################################################################################
       ######################                                      #######################
       ######################    Login Page   -  WebElements      #######################
       ######################                                      #######################
       ###################################################################################
   */
    static class LoginPageObjects {

        @FindBy(how= How.XPATH,using = "//input[@name='username']")
        WebElement username;

        @FindBy(xpath = "//input[@name='password']")
        WebElement password;

        @FindBy(xpath = "//button[@type='submit'][contains(.,'Login')]")
        WebElement loginBtn;

        @FindBy(xpath = "//img[contains(@alt,'profile picture')]")
        WebElement employeeProfile;
    }

}
