package chaining;

import static io.restassured.RestAssured .*;

import java.io.File;

import org.testng.annotations.Test;

public class CreateChangeRequest extends BaseTest {
	
	@Test
	public void createCR() {
	
			 chgreqsys_id = given()
			.pathParam("table_name", "change_request")
			.header("Content-Type", "application/json")
			.when()
			.body(new File("src/main/resources/RequestPayload/CreateChangeRequest.json"))
			.post()
			.then()
			.log()
			.all()
			.assertThat()
			.statusCode(201)
			.extract()
			.jsonPath()
			.getString("result.sys_id");
			
	}

}
