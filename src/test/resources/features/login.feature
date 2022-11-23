@login
Feature: Login
  Login Functionality in the Orange HRM Application

  Background: App launch
    Given Application is launched in the browser

  Scenario Outline: Valid Login Test
    When user logged in with valid credentials "<username>" and "<password>"
    Then user should see login is successful

    Examples:
      | username | password |
      | admin    | admin123 |

