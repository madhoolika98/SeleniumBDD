package org.orange.hrm.automation.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.orange.hrm.automation.base.TestBase;
import org.orange.hrm.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSteps extends StepManager{

    @Given("Application is launched in the browser")
    public void applicationIsLaunchedInTheBrowser() throws  Exception{
        System.out.println("app launch");
        loginPage.navigateUrl();
        Assert.assertTrue(loginPage.verifyPageTitle(),"Orange HRM Application is not launched");
    }


    @When("user logged in with valid credentials {string} and {string}")
    public void user_logged_in_with_valid_credentials_and(String uname, String pwd) throws Exception{
        System.out.println(uname);
        System.out.println(pwd);
        loginPage.login(uname,pwd);
    }

    @Then("user should see login is successful")
    public void user_should_see_login_is_successful() throws Exception {
        Assert.assertTrue(loginPage.validateUserLogin(),"Home page is not displayed and Login is not successful");
        System.out.println("login successful");
    }
}
