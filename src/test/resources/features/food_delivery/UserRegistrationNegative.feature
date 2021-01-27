@UserRegistration @Negative @Regression @Smoke
Feature: User Registration - Negative

  @userRegisteredWithExistingUsername
  Scenario: user Registers With Existing Username
    Given user registers to food delivery app with the following fields:
      | username | password | fullName | address     | city    | state | zip   | phone     |
      | elvina202 | Test123  | John Del | 123 main st | Chicago | IL    | 60625 | 112131321 |
    Then verify that status code is 200

    When user registers to food delivery app with the following fields:
      | username | password | fullName | address     | city    | state | zip   | phone     |
      | elvina201 | Test123  | John Del | 123 main st | Chicago | IL    | 60625 | 112131321 |
    Then verify that status code is 400

    Then the following error message has been returned:
      | status           | errorMessage |
      | Bad Request Body | Username unavailable. Please choose another one   |

  @userRegisteredWithEmptyOrNullUsername
    Scenario: user registers with empty or null username

    Given user registers to food delivery app with the following fields:
      | username | password | fullName | address     | city    | state | zip   | phone     |
      |          | Test123  | John Del | 123 main st | Chicago | IL    | 60625 | 112131321 |
    Then verify that status code is 400

    Then the following error message has been returned:
      | status           | errorMessage |
      | Bad Request Body |Username cannot be null or empty   |

   Given user registers to food delivery app with the following fields:
      | password | fullName | address     | city    | state | zip   | phone     |
      | Test123  | John Del | 123 main st | Chicago | IL    | 60625 | 112131321 |
    Then verify that status code is 400

    Then the following error message has been returned:
      | status           | errorMessage |
      | Bad Request Body |Username cannot be null or empty   |

  @userRegisteredWithEmptyOrNullFullName
  Scenario: user registers with empty or empty fullname

    Given user registers to food delivery app with the following fields:
      | username  | password | fullName | address     | city    | state | zip   | phone     |
      | elvina203 | Test123  |          | 123 main st | Chicago | IL    | 60625 | 112131321 |
    Then verify that status code is 400

    Then the following error message has been returned:
      | status           | errorMessage |
      | Bad Request Body |Fullname cannot be null or empty   |


    When user registers to food delivery app with the following fields:
      | username  | password | address     | city    | state | zip   | phone     |
      | elvina203 | Test123  | 123 main st | Chicago | IL    | 60625 | 112131321 |
    Then verify that status code is 400

    Then the following error message has been returned:
      | status           | errorMessage |
      | Bad Request Body |Fullname cannot be null or empty   |


  @userRegisteredWithEmptyOrNullPassword
  Scenario: user registers with empty or null password

    Given user registers to food delivery app with the following fields:
      | username  | password | fullName | address     | city    | state | zip   | phone     |
      | elvina206 |          | John Del | 123 main st | Chicago | IL    | 60625 | 112131321 |
    Then verify that status code is 500

    Given user registers to food delivery app with the following fields:
      | username  |  fullName | address     | city    | state | zip   | phone     |
      | elvina206 |  John Del | 123 main st | Chicago | IL    | 60625 | 112131321 |
    Then verify that status code is 500







