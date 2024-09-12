package chaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class RetrieveChangeRequest extends BaseTest {

	  @Test(dependsOnMethods ="chaining.CreateChangeRequest.createCR")
	  public void getCR() {
		
		  System.out.println("sys_id from CreateCR: "+chgreqsys_id);
		  given()
		  .header("Content-Type", "application/json")
		  .pathParam("table_name", "change_request")
		  .pathParam("sys_id", chgreqsys_id)
		  .when()
		  .get("/{sys_id}")
		  .then()
		  .log()
		  .all()
		  .assertThat()
		  .statusCode(200);

	}
	
}
