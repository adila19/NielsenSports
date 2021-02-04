Feature: Login Scenarios
  Background:
    Given I navigate to Nielsen Sports web app
@Login
  Scenario: Verify user can successfully login
    When I enter correct "username" and "password"
    Then I am able to successfully log in to the system
@Login
  Scenario Outline:Verify error states for incorrect login attempts
      When I enter wrong "<username>" and "<password>"
      Then I get a warning message
    Examples:
      | username   | password  |
      | someone    | something |
      | wrongName  | */555489  |
      |            | something |
      | wrongName  |           |


