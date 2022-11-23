package org.orange.hrm.automation.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddNewEmployeeSteps extends StepManager
{

    @Given("Logged into the application as admin")
    public void loggedIntoTheApplicationAsAdmin() throws Exception
    {
        addNewEmployeePage.launchAndLogin();
        System.out.println("login successful");
    }

    @When("Added the New Employee information First Name,Middle Name and Last Name")
    public void addedTheNewEmployeeInformationFirstNameMiddleNameAndLastName(DataTable dataTable) throws InterruptedException {
        addNewEmployeePage.addEmployeeInformation(dataTable);
        System.out.println("Inserted Employee Information");
    }

    @And("Saved the employee details")
    public void savedTheEmployeeDetails() throws InterruptedException {
        addNewEmployeePage.saveEmployeeInformation();
        System.out.println("Saving employee information");
    }

    @When("Searched for the Employee <{string}>in the Employee List")
    public void searchedForTheEmployeeInTheEmployeeList(String Name) throws InterruptedException {
        Assert.assertTrue(addNewEmployeePage.verifyEmployeeInformationSaved(),"Employee Information is not saved");
        addNewEmployeePage.searchForEmployee(Name);
    }

    @Then("The Employee details should be displayed")
    public void theEmployeeDetailsShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(addNewEmployeePage.uponSearchEmployeeDetailsAreDisplayed(),"Employee Information is not displayed");
    }
}
