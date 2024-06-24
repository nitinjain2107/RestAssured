package AutomationAPI.RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import files.Payload;


public class addNewPlaceAPI {
	
	   private String place_ID;
	@Test(groups= "Regression")
	 public void addNewPlace() {
		// TODO Auto-generated method stub
		//add API
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String addResponse=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.addPayload("totten","germany")).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println("--------------------------");
		//System.out.println(addResponse);
		JsonPath jp=new JsonPath(addResponse);
		place_ID=jp.getString("place_id");
//		//update API
//		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
//		.body(Payload.updatePlaceId(place_ID)).when().put("maps/api/place/update/json")
//		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		//Get API
	}	
	    @Test(groups="Regression")
		public void getPlace() {
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_ID).header("Content-Type","application/json")
		.when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).body("address", equalTo("totten"));
	 }

}
