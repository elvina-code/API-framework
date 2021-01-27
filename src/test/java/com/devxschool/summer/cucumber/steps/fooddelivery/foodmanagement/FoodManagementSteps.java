package com.devxschool.summer.cucumber.steps.fooddelivery.foodmanagement;


import com.devxschool.summer.cucumber.steps.common.CommonData;
import com.devxschool.summer.cucumber.steps.fooddelivery.FoodDeliveryEndPoints;
import com.devxschool.summer.pojo.fooddelivery.FoodRequest;
import com.devxschool.summer.pojo.fooddelivery.FoodResponse;
import com.devxschool.summer.utility.ObjectConverter;
import com.devxschool.summer.utility.PropertiesReader;
import com.devxschool.summer.utility.RestHttpRequest;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.List;


public class FoodManagementSteps {
    private CommonData commonData;
   // private Gson gson;
    //private Response response;

    public FoodManagementSteps(CommonData commonData){
        this.commonData = commonData;
    }

    @Before
    public void setUp(){
        //gson = new Gson();
        RestAssured.baseURI = PropertiesReader.getPropertiesValue("foodDeliveryBaseUrl");
    }

    @Given("^add new food to FoodDelivery with the following fields$")
    public void add_new_food_to_FoodDelivery_with_the_following_fields(List<FoodRequest> foodRequest) throws Throwable {
        String foodRequestJson = ObjectConverter.convertObjectToJson(foodRequest.get(0));

        //RestHttpRequest.addHeaders();

        commonData.response = FoodDeliveryEndPoints.addFood(foodRequestJson);

    }


    @Then("^the following food has been added$")
    public void theFollowingFoodhasbeenAdded(List<FoodRequest> expectedFood){
        FoodResponse actualFood = ObjectConverter.convertJsonToObject(commonData.response.body().asString(), FoodResponse.class);
        Assert.assertEquals(expectedFood.get(0).getDescription(), actualFood.getFoodCached().get(0).getDescription());
    }

    @Then("^verify response error message \"([^\"]*)\"$")
    public void verify_response_error_message(String expectedErrorMessage) throws Throwable {
        Assert.assertEquals(expectedErrorMessage, commonData.response.body().jsonPath().getString("errorMessage"));
    }


    @When("^food entry \"([^\"]*)\" is updated with following fields$")
    public void food_entry_is_updated_with_following_fields(String fieldName, List<FoodRequest> foodRequest) throws Throwable {
        String foodRequestJson = ObjectConverter.convertObjectToJson(foodRequest.get(0));

        RestHttpRequest.addHeaders();

        commonData.response = RestHttpRequest
                .requestSpecification
                .queryParam("name", foodRequest.get(0).getName())
                .queryParam("field", fieldName)
                .body(foodRequestJson)
                .when()
                .request(String.valueOf(RestHttpRequest.HttpMethods.PUT), "/food/cache/update");

    }
    private void clearFoodCache(){
      FoodDeliveryEndPoints.commitFood();
        //when().request("POST", "food/commit");
    }

    @After
    public void cleanUp(){
        clearFoodCache();
    }




}
