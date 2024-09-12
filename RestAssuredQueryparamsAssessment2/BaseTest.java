package RestAssuredQueryparamsAssessment2;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;

import org.testng.annotations.BeforeMethod;


public class BaseTest {
	
public static String incidentsys_id;	
	
	@BeforeMethod
	public void beforeMethod() {
	baseURI = "https://dev282483.service-now.com";
	basePath = "/api/now/table/{table_name}";
	authentication = basic("admin", "cv-H00neFIF@");

}
	
}
