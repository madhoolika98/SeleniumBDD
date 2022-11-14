package org.orange.hrm.automation.stepDefinitions;

import org.orange.hrm.automation.pages.AddNewEmployeePage;
import org.orange.hrm.automation.pages.HomePage;
import org.orange.hrm.automation.pages.LoginPage;
import org.orange.hrm.automation.pages.PageManager;

public class StepManager {

    PageManager pageManager;
    HomePage homePage;
    LoginPage loginPage;
    AddNewEmployeePage addNewEmployeePage;

    public StepManager() {
        initializePages();
    }

    public void initializePages() {
        pageManager = new PageManager();
        loginPage = pageManager.getLoginPage();
        homePage = pageManager.getHomePage();
        addNewEmployeePage = pageManager.getAddNewEmployeePage();
    }



}
