package com.devxschool.summer.cucumber.steps.fooddelivery.userregistration;

import com.devxschool.summer.cucumber.steps.common.CommonData;
import com.devxschool.summer.cucumber.steps.fooddelivery.FoodDeliveryEndPoints;
import com.devxschool.summer.pojo.fooddelivery.UserRegistrationRequest;
import com.devxschool.summer.pojo.fooddelivery.UserRegistrationResponse;
import com.devxschool.summer.utility.ObjectConverter;
import com.devxschool.summer.utility.PropertiesReader;
import com.devxschool.summer.utility.RestHttpRequest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert; // has to come from cucumber because we run features



import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;



public class UserRegistrationSteps {
    private CommonData commonData;

    //private Response response;
   // private Gson gson;  // for serialization and deserialization


    public UserRegistrationSteps(CommonData commonData){
        this.commonData = commonData;
    }


    @Before
    public void setUp(){
       // gson = new Gson();
        RestAssured.baseURI = PropertiesReader.getPropertiesValue("foodDeliveryBaseUrl");
    }

    @Given("^user registers to food delivery app with the following fields:$")
    public void user_registers_to_food_delivery_app_with_the_following_fields(List<UserRegistrationRequest> userToRegister) throws Throwable {

        String userJson = ObjectConverter.convertObjectToJson(userToRegister.get(0));

        commonData.response = FoodDeliveryEndPoints.registerUser(userJson);
    }

    @Then("^verify that response message is \"([^\"]*)\"$")
    public void verify_that_response_message_is(String responseMessage) throws Throwable {
        //Assert.assertEquals(responseMessage, response.body().jsonPath().getString("status"));
        // convert into POJO deserialiaze
        // create the object save converted json what type of class
        commonData.response.body().prettyPrint();
        UserRegistrationResponse userRegistrationResponse = ObjectConverter.convertJsonToObject(commonData.response.body().asString(), UserRegistrationResponse.class);

        //System.out.println(userRegistrationResponse.toString());
        Assert.assertEquals(responseMessage, userRegistrationResponse.getStatus());

    }

    /**
     * Cucumber can't technically convert complex jsons/data into POJO. Use List of maps.
     * @param expectedUser
     * @throws Throwable
     */
    @Then("^the folowing user has been registered:$")
    public void verify_that_response_message_is(List<Map<String, String>> expectedUser) throws Throwable {
        //Deserializing response body JSON String to userRegistResponse object
        commonData.response.body().prettyPrint();
        UserRegistrationResponse userRegistrationResponse = ObjectConverter.convertJsonToObject(commonData.response.body().asString(), UserRegistrationResponse.class);

        //System.out.println(userRegistrationResponse.toString());
        Assert.assertEquals(expectedUser.get(0).get("status"), userRegistrationResponse.getStatus());
        Assert.assertEquals(expectedUser.get(0).get("username"), userRegistrationResponse.getUserInfo().getUsername());
        Assert.assertEquals(expectedUser.get(0).get("fullName"), userRegistrationResponse.getUserInfo().getUserProfile().getFullName());
    }


    @Then("^the following error message has been returned:$")
    public void the_following_error_message_has_been_returned(List<Map<String, String>> expectedErrorMessage) throws Throwable {
        UserRegistrationResponse userRegistrationResponse = ObjectConverter.convertJsonToObject(commonData.response.body().asString(), UserRegistrationResponse.class);
        Assert.assertEquals(expectedErrorMessage.get(0).get("status"), userRegistrationResponse.getStatus());
        Assert.assertEquals(expectedErrorMessage.get(0).get("errorMessage"), userRegistrationResponse.getErrorMessage());

    }



    }
