package AutomationAPI.RestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {

@Test(dataProvider="Book",groups="smoke")
public void addBook(String isbn,String aisle) {
	RestAssured.baseURI="http://216.10.245.166";
	String response= given().header("Content-Type","application/json").body(Payload.BookData(isbn,aisle))
	.when().post("Library/Addbook.php")
	.then().log().all().assertThat().statusCode(200).extract().asString();		
	JsonPath js=new JsonPath(response);
	String id=js.getString("ID");
	System.out.println(id);
	
	
}
@DataProvider(name="Book")
public Object[][] getData() {
	
	
	return new Object[][] {{"abcdd","8988"},{"cfdg","1243"},{"ghdt","3456"}};
	
	
}

}
