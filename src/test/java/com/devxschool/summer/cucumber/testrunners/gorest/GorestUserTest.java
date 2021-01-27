package com.devxschool.summer.cucumber.testrunners.gorest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { // right click in feature file copyPath from contentRoot
                "src/test/resources/features/gorest/user.feature"
        },
        glue = {"com.devxschool.summer.cucumber.steps.gorest",
                "com.devxschool.summer.cucumber.steps.common"
        },
        tags = {
                "@successfullyCreateUser"
        },
        dryRun = false

)

public class GorestUserTest {
}
