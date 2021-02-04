Feature: Data Auth scenarios
  Background:
    Given I navigate to Nielsen Sports web app
    When I enter correct "username" and "password"
    Then I am able to successfully log in to the system
@HomePage
    Scenario Outline:
      And I see 3 columns with images on the page
      And each image has a proper "<tag>"
      Examples:
        | tag       |
        | date      |
        | location  |
        | team name |

