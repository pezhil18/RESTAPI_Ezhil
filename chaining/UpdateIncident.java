package chaining;

import static io.restassured.RestAssured . *;
import java.io.File;

import org.testng.annotations.Test;

public class UpdateIncident extends BaseTest {
	
	@Test(dependsOnMethods={"chaining.CreateIncident.createIncident"})
	public void update() {	
		
		System.out.println("sys_id from CreateInc"+incsys_id);
		given()
		.header("Content-Type", "application/json")	
		.pathParam("table_name", "incident")
		.pathParam("sys_id", incsys_id)			
		.log().uri()
		.when()
		.body(new File("src/main/resources/RequestPayload/UpdateIncident.json"))
		.put("/{sys_id}")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);

	}
			   

}
