package AutomationAPI.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class staticJson {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			//add API
			RestAssured.baseURI="https://rahulshettyacademy.com";
			String addResponse=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\nitjain4\\OneDrive - Publicis Groupe\\Documents\\Addplace.json")))).when().post("maps/api/place/add/json")
			.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
			.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
			System.out.println("--------------------------");
			//System.out.println(addResponse);
			JsonPath jp=new JsonPath(addResponse);
			String place_ID=jp.getString("place_id");

}
	}
