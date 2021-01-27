@FoodManagement @Regression @Smoke
Feature: Food Management

  @AddNewFoodEntry
  Scenario Outline: Add new food entry
    Given add new food to FoodDelivery with the following fields
      | description | imageUrl        | price | name   | foodType   |
      | Wine        | https:foods.com | 20.00 | Merlot | <foodType> |
    Then verify that status code is 200
#    Then the following food has been added:
#      | description | imageUrl        | price | name   | foodType  |
#      | Wine        | https:foods.com | 20.00 | Merlot | Beverages |
    Examples:
      | foodType   |
      | Beverages  |
      | Appetizers |
      | MainDish   |

  @addNewFoodEntryWithoutDescription
  Scenario: Add new food entry without description
    Given add new food to FoodDelivery with the following fields
      | imageUrl        | price | name   | foodType  |
      | https:foods.com | 20.00 | Merlot | Beverages |
    Then verify that status code is 200
    Then the following food has been added
      | imageUrl        | price | name   | foodType  |
      | https:foods.com | 20.00 | Merlot | Beverages |



  @updateFoodEntry
  Scenario: user updates "skirt steak"'s price to 100.00
    Given add new food to FoodDelivery with the following fields
      | description | imageUrl        | price | name        | foodType |
      | Steak       | https:foods.com | 20.00 | skirt steak | MainDish |

    And verify that status code is 200
    When food entry "price" is updated with following fields
      | description | imageUrl        | price  | name        | foodType |
      | Steak       | https:foods.com | 100.00 | skirt steak | MainDish |
    Then verify that status code is 200

    Then the following food has been added
      | description | imageUrl        | price  | name        | foodType |
      | Steak       | https:foods.com | 100.00 | skirt steak | MainDish |








  Scenario: Add  new food entry

    Given add new food to FoodDelivery with the following fields
      | description | imageUrl        | price | name   | foodType  |
      | Wine        | https:foods.com | 20.00 | Merlot | Beverages |
    Then verify that status code is 200
    Then the following food has been added
      | description | imageUrl        | price | name   | foodType  |
      | Wine        | https:foods.com | 20.00 | Merlot | Beverages |


  Scenario: Add  Appetizers food entry

    Given add new food to FoodDelivery with the following fields
      | description | imageUrl        | price | name   | foodType   |
      | Salad       | https:foods.com | 20.00 | Ceasar | Appetizers |
    Then verify that status code is 200
    Then the following food has been added
      | description | imageUrl        | price | name   | foodType   |
      | Salad       | https:foods.com | 20.00 | Ceasar | Appetizers |


  Scenario: Add  Main Dish food entry

    Given add new food to FoodDelivery with the following fields
      | description | imageUrl        | price | name      | foodType  |
      | Dumplings   | https:foods.com | 20.00 | Dumplings | Main Dish |
    Then verify that status code is 200
    Then the following food has been added
      | description | imageUrl        | price | name      | foodType  |
      | Dumplings   | https:foods.com | 20.00 | Dumplings | Main Dish |



