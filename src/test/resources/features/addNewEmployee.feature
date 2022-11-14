@addEmployee
Feature: Add Employee
  Verifies the employee is added successfully

  Background:
    Given Logged into the application as admin

  Scenario:Adding a new employee
    When Added the New Employee information First Name,Middle Name and Last Name
    |First Name|Middle Name|Last Name|
    |Frank     |Finn       |Hill     |
    And Saved the employee details
    When Searched for the Employee <"Frank Finn Hill">in the Employee List
    Then The Employee details should be displayed
