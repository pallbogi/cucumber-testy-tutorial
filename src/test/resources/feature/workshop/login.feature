@screen
Feature: Login

  Scenario: Login successfully
    Given I access the login page
    And I insert valid credentials
    When I click on login button
    Then I except successful login message

  Scenario:Login with wrong credentials
    Given I access the login page
    And I insert invalid credentials
    When I click on login button
    Then I expect invalid credentials message

  Scenario:Login with no password
    Given I access the login page
    When I enter "eghsu@fsast.com"/"" credentials
    And I click on login button
    Then I expect "Please enter your password!" message

  Scenario Outline: Failed login
    Given I access the login page
    When I enter "<email>"/"<pass>" credentials
    And I click on login button
    Then I expect "<message>" message
    Examples:
      | email       | pass   | message                     |
      | aa@fast.com |        | Please enter your password! |
      |             | qwerty | Please enter your email!    |
      |             |        | Please enter your email!    |
      | aa@fast.com | asdsa  | Invalid user or password!   |

  Scenario: Logout success
    Given I successfully login
    When I click on logout button
    Then I should be logged out



