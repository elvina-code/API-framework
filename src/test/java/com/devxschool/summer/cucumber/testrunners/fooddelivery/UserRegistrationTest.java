package com.devxschool.summer.cucumber.testrunners.fooddelivery;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/food_delivery/UserRegistration.feature",
                "src/test/resources/features/food_delivery/UserRegistrationNegative.feature"

        },
        glue = {"com.devxschool.summer.cucumber.steps.fooddelivery",
                "com.devxschool.summer.cucumber.steps.common"
        },
        tags = {
                "@userRegisteredWithEmptyOrNullPassword"
        },
        dryRun = false //by default is false when true -->run and check make sure all steps in features are define.
)
public class UserRegistrationTest {

}
