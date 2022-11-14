package org.orange.hrm.automation.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.orange.hrm.automation.base.TestBase;
import org.orange.hrm.automation.common.Generic;
import org.orange.hrm.automation.constants.GlobalConstants;

import java.util.Random;

public class AddNewEmployeePage extends TestBase {

    GlobalConstants globalConstants;
    Generic generic;
    public AddNewEmployeePage.AddNewEmployeePageObjects addNewEmployeePageObjects;
    public LoginPage.LoginPageObjects loginPageObjects;
    public String FirstName ;
    public String LastName ;
    public int employeeId;

    /**
     * Constructor
     * @param
     */
    public AddNewEmployeePage()
    {
        globalConstants = new GlobalConstants();
        generic = new Generic(TestBase.driver);
        addNewEmployeePageObjects = new AddNewEmployeePage.AddNewEmployeePageObjects();
        loginPageObjects = new LoginPage.LoginPageObjects();
    }

    /**
     * Description: Method is used to launch application url and login as admin user
     * @throws Exception
     */
    public void launchAndLogin() throws Exception {
        PageFactory.initElements(getDriver(),addNewEmployeePageObjects);
        PageFactory.initElements(getDriver(),loginPageObjects);
        generic.waitForMediumTimeOut();
        loginPageObjects.username.sendKeys(globalConstants.userName);
        loginPageObjects.password.sendKeys(globalConstants.passWord);
        loginPageObjects.loginBtn.click();
        generic.waitForMediumTimeOut();
        addNewEmployeePageObjects.pimModule.click();
        generic.waitForMediumTimeOut();

    }

    public void addEmployeeInformation(DataTable dataTable) throws InterruptedException {
        addNewEmployeePageObjects.addEmployeeButton.click();
        generic.waitForLongTimeOut();
        FirstName = dataTable.asLists().get(1).get(0);
        LastName = dataTable.asLists().get(1).get(2);
        addNewEmployeePageObjects.employeeFirstNameTxtBox.sendKeys(FirstName);
        addNewEmployeePageObjects.employeeMiddleNameTxtBox.sendKeys(dataTable.asLists().get(1).get(1));
        addNewEmployeePageObjects.employeeLastNameTxtBox.sendKeys(LastName);
        addNewEmployeePageObjects.employeeLastNameTxtBox.sendKeys(Keys.TAB);
        Random rand = new Random();
        employeeId = rand.nextInt(1000);
        addNewEmployeePageObjects.employeeIDTextBox.sendKeys(Integer.toString(employeeId));
        generic.waitForMediumTimeOut();
    }

    public void saveEmployeeInformation() throws InterruptedException {
        addNewEmployeePageObjects.saveButton.click();
        generic.waitForLongTimeOut();
    }

    public Boolean verifyEmployeeInformationSaved() throws InterruptedException {
        Boolean isEmployeeInformationSaved =  false;
        generic.waitForLongTimeOut();
        isEmployeeInformationSaved = addNewEmployeePageObjects.personalDetails.isDisplayed();
        return isEmployeeInformationSaved;

    }

    public void searchForEmployee(String employeeName) throws InterruptedException {
        addNewEmployeePageObjects.employeeListButton.click();
        generic.waitForLongTimeOut();
        addNewEmployeePageObjects.employeeNameTextBox.sendKeys(employeeName);
        addNewEmployeePageObjects.employeeNameTextBox.sendKeys(Keys.TAB);
        generic.waitForLongTimeOut();
        addNewEmployeePageObjects.employeeIDBox.sendKeys(Integer.toString(employeeId));
    }

    public Boolean uponSearchEmployeeDetailsAreDisplayed() throws InterruptedException {
        Boolean employeeRecordDisplayed = false;
        addNewEmployeePageObjects.employeeSearchButton.click();
        generic.waitForLongTimeOut();
        if(addNewEmployeePageObjects.employeeFrank.isDisplayed())
        {
            employeeRecordDisplayed = true;
        }
        return employeeRecordDisplayed;
    }
        /*
       ###################################################################################
       ######################                                         ####################
       ######################    Add Employee Page   -  WebElements   ####################
       ######################                                         ####################
       ###################################################################################
   */


    class AddNewEmployeePageObjects {

        @FindBy(xpath = "//a[contains(.,'PIM')]")
        @CacheLookup
        private WebElement pimModule;

        @FindBy(xpath = "//li[contains(.,'Add Employee')]")
        @CacheLookup
        private WebElement addEmployeeButton;

        @FindBy(xpath = "//a[contains(.,'Employee List')]")
        @CacheLookup
        private WebElement employeeListButton;

        @FindBy(xpath = "//input[@name='firstName']")
        @CacheLookup
        private WebElement employeeFirstNameTxtBox;

        @FindBy(xpath = "//input[@name='middleName']")
        @CacheLookup
        private WebElement employeeMiddleNameTxtBox;

        @FindBy(xpath = "//input[@name='lastName']")
        @CacheLookup
        private WebElement employeeLastNameTxtBox;

        @FindBy(xpath = "//button[contains(.,'Save')]")
        @CacheLookup
        private WebElement saveButton;

        @FindBy(xpath ="//a[contains(.,'Personal Details')]")
        @CacheLookup
        private  WebElement personalDetails;

        @FindBy(xpath ="//input[@class='oxd-input oxd-input--focus']")
        @CacheLookup
        private  WebElement employeeIDTextBox;

        @FindBy(xpath = "(//input[contains(@placeholder,'Type for hints...')])[1]")
        @CacheLookup
        private WebElement employeeNameTextBox;

        @FindBy(xpath ="//input[@class='oxd-input oxd-input--focus']")
        @CacheLookup
        private  WebElement employeeIDBox;

        @FindBy(xpath = "//button[contains(.,'Search')]")
        @CacheLookup
        private WebElement employeeSearchButton;

        @FindBy(xpath = "//div[@class='oxd-table-cell oxd-padding-cell'][contains(.,'Frank Finn')]")
        @CacheLookup
        private WebElement employeeFrank;
    }
}
