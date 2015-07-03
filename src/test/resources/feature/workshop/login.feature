Feature: Login

  Scenario: Login successfully
    Given I aaccess the login page
    And I insert valid credentials
    When I click on login button
    Then I except successful login message


  Scenario:Log in with wrong credentials
    Given I access the login page
    And I insert invalid credentials
    When I click on login button
    Then I expect invalid credentials message