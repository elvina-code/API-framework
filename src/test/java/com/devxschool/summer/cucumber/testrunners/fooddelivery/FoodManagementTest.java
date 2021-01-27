package com.devxschool.summer.cucumber.testrunners.fooddelivery;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features/food_delivery/Food.feature",
                "src/test/resources/features/food_delivery/FoodNegative.feature"

        },
        glue = {"com.devxschool.summer.cucumber.steps.fooddelivery",
                "com.devxschool.summer.cucumber.steps.common"
        },
        tags = {
                "@updateFoodEntry"
        },
        dryRun = false//by default is false when true -->run sanity test
)
public class FoodManagementTest {
}
