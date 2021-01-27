package com.devxschool.summer.cucumber.steps.gorest;

import com.devxschool.summer.cucumber.steps.common.CommonData;
import com.devxschool.summer.pojo.gorest.UserData;
import com.devxschool.summer.pojo.gorest.UserResponse;
import com.devxschool.summer.utility.ObjectConverter;
import com.devxschool.summer.utility.PropertiesReader;
import com.devxschool.summer.utility.RestHttpRequest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import cucumber.api.java.After;
import org.junit.Assert;

import java.util.List;

public class UserSteps {
    private CommonData commonData;
    //private Response response;

    public UserSteps(CommonData commonData){
        this.commonData = commonData;
    }

    @Before
    public void setUp(){
        RestAssured.baseURI = PropertiesReader.getPropertiesValue("gorestBaseUrl");
        RestHttpRequest.requestSpecification.header("Authorization", PropertiesReader.getPropertiesValue("gorestBearerToken"));

    }

    @Given("^add new user to GoRest with the following fields$")
    public void add_new_user_to_GoRest_with_the_following_fields(List<UserData> userRequest) throws Throwable {
        // if is List<Map<String, String>> userRequest
//        UserRequest user = new UserRequest();
//        UserData userData = new UserData();
//        userData.setEmail(userRequest.get(0).get("email"));
//        userData.setName(userRequest.get(0).get("name"));
//        userData.setGender(userRequest.get(0).get("gender"));
//        userData.setStatus(userRequest.get(0).get("status"));
//        user.setData(userData);
        String json = ObjectConverter.convertObjectToJson(userRequest.get(0));
        RestHttpRequest.addHeaders();

        commonData.response = RestHttpRequest.requestSpecification

                .body(json)
                .when()
                .request(String.valueOf(RestHttpRequest.HttpMethods.POST), "/users");


    }


    @Then("^verify that user has been successfully added$")
    public void verify_that_user_has_been_successfully_added(List<UserData> expectedData) throws Throwable {
        UserResponse userResponse = ObjectConverter.convertJsonToObject(commonData.response.body().asString(),UserResponse.class);
        Assert.assertEquals(expectedData.get(0).getEmail(), userResponse.getData().getEmail());
        Assert.assertEquals(expectedData.get(0).getName(), userResponse.getData().getName());
        Assert.assertEquals(expectedData.get(0).getGender(), userResponse.getData().getGender());
        Assert.assertEquals(expectedData.get(0).getStatus(), userResponse.getData().getStatus());

    }

    @Then("^update existing user to GoRest with the following fields$")
    public void update_existing_user_to_GoRest_with_the_following_fields(List<UserData> updatedUser) throws Throwable {

    }

    private void deleteUser(){
        UserResponse userResponse = ObjectConverter.convertJsonToObject(commonData.response.body().asString(),UserResponse.class);

        RestHttpRequest.requestSpecification
                .pathParam("userId", userResponse.getData().getId())
                .when()
                .request(String.valueOf(RestHttpRequest.HttpMethods.DELETE), "/users/{userId}");
    }

    @After
    public void cleanUp(){
        deleteUser();
    }



}
