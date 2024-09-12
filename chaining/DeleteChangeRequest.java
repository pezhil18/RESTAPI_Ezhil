package chaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteChangeRequest extends BaseTest {
	
	@Test(dependsOnMethods = "chaining.UpdateChangeRequest.udateCR")
	public void deleteCR() {
			System.out.println("sys_id from UpdateCR: "+chgreqsys_id);
			given()
			.header("Content-Type", "application/json")	
			.pathParam("table_name", "change_request")
			.pathParam("sys_id", chgreqsys_id)
			.when()
			.delete("/{sys_id}")
			.then()
			.log()
			.all()
			.assertThat()
			.statusCode(204);
			
			
			
			

	}

}
