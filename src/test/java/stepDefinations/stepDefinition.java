package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AppPlace;
import pojo.Location;
import resources.ApiResources;
import resources.Utils;
import resources.testDataBuild;

public class stepDefinition extends Utils {
	
	RequestSpecification res;
	Response response;
	static String placeid;
	testDataBuild place=new testDataBuild();
	
	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {

		
		
		
		   res=  given().log().all().spec(requestSpecification())
			       .body(place.AddPlacePayload(name,language,address));
		
	   
	}
	@When("User calls {string} API with {string} http request")
	public void user_calls_api_with_http_request(String resource, String method) {

		
		ApiResources resourceAPi= ApiResources.valueOf(resource);
		System.out.println(resourceAPi.getResources());
		if(method.equalsIgnoreCase("POST"))
		response=  res.when().post(resourceAPi.getResources());
			    //   .then().log().all().extract().response();
		else if(method.equalsIgnoreCase("GET"))
			response=  res.when().get(resourceAPi.getResources());
		      // .then().log().all().extract().response();
		else if(method.equalsIgnoreCase("DELETE"))
			response=  res.when().delete(resourceAPi.getResources());
		     //  .then().log().all().extract().response();
		
	   
	}
	
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer statusCode) {
		 // Write code here that turns the phrase above into concrete actions
	//	assertEquals(response.getStatusCode(), statusCode);
		//System.out.println(statusCode);
		assertEquals(response.getStatusCode(), 200);
	}


	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String value) {
		
		assertEquals(getJsonPath(response,keyValue), value);
		
	    
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resouce) throws IOException {
		
		placeid= getJsonPath(response, "place_id");
		res=  given().spec(requestSpecification()).queryParam("place_id", placeid);
		user_calls_api_with_http_request(resouce,"GET");
		String actualname= getJsonPath(response,"name");
		assertEquals(actualname, expectedName);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res= given().spec(requestSpecification()).body(place.deletePlacePayload(placeid));
	}




}
