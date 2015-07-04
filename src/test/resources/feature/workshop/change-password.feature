@screen
Feature: As a logged in user I can change my password

  Scenario: Change password successfully
    Given I successfully login
    When I click on Preferences button
    And I input current password
    And I input new password
    And I confirmed the new password
    And I click on the Save button
    Then I should see "Your password has been sucessfully changed." message
    And I close Preferences window
    And I can relogin with the new credentials
