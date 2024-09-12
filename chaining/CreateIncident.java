package chaining;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured .*;

public class CreateIncident extends BaseTest{
	
	@Test
	public void createIncident() {
					
		incsys_id = given()
				   .pathParam("table_name", "incident")
				   .header("Content-Type", "application/json")
				   .when()
				   .body(new File("src/main/resources/RequestPayload/CreateIncident.json"))
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
