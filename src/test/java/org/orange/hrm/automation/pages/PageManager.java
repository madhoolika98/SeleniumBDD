package org.orange.hrm.automation.pages;

public class PageManager {

    private AddNewEmployeePage addNewEmployeePage;
    private LoginPage loginPage;
    private HomePage homePage;

    public HomePage getHomePage() { return (homePage==null)?homePage=new HomePage():homePage; }

    public LoginPage getLoginPage() {
        return (loginPage==null)?loginPage=new LoginPage():loginPage;
    }

    public AddNewEmployeePage getAddNewEmployeePage() { return (addNewEmployeePage==null)?addNewEmployeePage=new AddNewEmployeePage():addNewEmployeePage; }

}
