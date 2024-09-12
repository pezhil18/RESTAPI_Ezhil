package chaining;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

public class UpdateChangeRequest extends BaseTest {
	
	@Test(dependsOnMethods = "chaining.RetrieveChangeRequest.getCR" )
	public void udateCR() {
	
		System.out.println("sys_id from CreateCR: "+chgreqsys_id);
		given()
		.header("Content-Type", "application/json")	
		.pathParam("table_name", "change_request")
		.pathParam("sys_id", chgreqsys_id)
		.when()
		.body(new File("src/main/resources/RequestPayload/UpdateChangeRequest.json"))
		.put("/{sys_id}")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
		
		
		

	}

}
