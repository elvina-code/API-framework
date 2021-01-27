@GorestUsers @Regression @Smoke
Feature: User Functionality

  @successfullyCreateUser
  Scenario: Adding a new user - Happy Path
    Given add new user to GoRest with the following fields
      | name        | email                  | gender | status |
      | Kannan Jain | v_kannan_jai@rempel.co | Male   | Active |
    Then verify that status code is 200
    Then verify that user has been successfully added
      | name        | email                  | gender | status |
      | Kannan Jain | v_kannan_jai@rempel.co | Male   | Active |


  @successfullyUpdateUser
  Scenario: Update a existing user - Happy Path
    Given add new user to GoRest with the following fields
      | name        | email                  | gender | status |
      | Kannan Jain | v_kannan_jai@rempel.co | Male   | Active |
    Then verify that status code is 200
    Then verify that user has been successfully added
      | name        | email                  | gender | status |
      | Kannan Jain | v_kannan_jai@rempel.co | Male   | Active |

    Then update existing user to GoRest with the following fields
      | name   | email                  | gender | status |
      | Elvina | v_kannan_jai@rempel.co | Male   | Active |
    Then verify that status code is 200
    Then verify that user has been successfully added
      | name   | email                  | gender | status |
      | Elvina | v_kannan_jai@rempel.co | Male   | Active |





