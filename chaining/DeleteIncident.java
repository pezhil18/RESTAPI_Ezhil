package chaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteIncident extends BaseTest {
	
	@Test(dependsOnMethods= {"chaining.UpdateIncident.update"})
	public void delete() {

		given()
		.pathParam("table_name", "incident")
		.pathParam("sys_id", incsys_id)
		.header("Content-Type", "application/json")
		.when()
		.delete("/{sys_id}")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(204);

	}

}
