package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import pojo.Addplace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.*;

public class StepDefinitions extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	JsonPath jsonPath;

	@Given("Add Place payload")
	@Given("Add Place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		// resspec = new
		// ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		res = given().spec(requestspecification()).body(data.addplacepayload(name, language, address));
	}

	@When("user calls {string} with {string} HTTP request")
	public void user_calls_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions
		//construstuer will be called with valueofresourse
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getresource());

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST")) {
			response = res.when().post(resourceAPI.getresource());
		} else if (method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceAPI.getresource());
		}

//		response = res.when().post(resourceAPI.getresource()).then().log().all().spec(resspec)
//				.body("scope", equalTo("APP")).header("Connection", "Keep-Alive").extract().response();
	}

	@Then("the API call is successful with status code {int}")
	public void the_api_call_is_successful_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String expectedvalue) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(response, keyvalue), expectedvalue);
	}

	@Then("verify Place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		// RequestSpec

		place_id = getJsonPath(response, "place_id");
		res = given().spec(requestspecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualname = getJsonPath(response, "name");
		assertEquals(actualname, expectedname);
	}

	@Given("deleteplace payload")
	public void deleteplace_payload() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		res = given().spec(requestspecification()).body(data.deleteplacepayload(place_id));

	}

}
