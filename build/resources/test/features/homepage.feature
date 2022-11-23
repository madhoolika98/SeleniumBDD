@home
Feature: Home
  Search for Employee

  Background:
    Given Logged in as admin into the application

  Scenario:Search for an Employee
    When Searched for Employee "<Frank Finn Hill>"
    Then Employee should be displayed successfully