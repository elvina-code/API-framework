package com.devxschool.summer.cucumber.steps.common;

import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CommomSteps {

    //create CommonData object
    private CommonData commonData;


    //use contructor
    public CommomSteps(CommonData commonData){
        this.commonData = commonData;
    }


    @Then("^verify that status code is (\\d+)$")
    public void verify_that_status_code_is(int statusCode) throws Throwable {
        Assert.assertEquals(statusCode, commonData.response.getStatusCode());

    }


}
