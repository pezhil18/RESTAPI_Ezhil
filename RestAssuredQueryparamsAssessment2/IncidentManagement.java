package RestAssuredQueryparamsAssessment2;

import java.util.HashMap;
import java.util.Map;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured .*;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class IncidentManagement extends BaseTest {
	
    @Test
	public void getallincident() {
//		Set the query parameters for filtering incidents
		Map <String ,String> queryparam=new HashMap<String,String>();
		queryparam.put("sysparm_fields","sys_id,short_description");
		queryparam.put("sysparm_limit","5");
		
		Response getstatus  = given()
		.pathParam("table_name", "incident")
		.queryParams(queryparam)
		.header("Content-Type", "application/json")
		.when()
		.get();
		Assert.assertEquals(getstatus.getStatusCode(), 200);
		System.out.println(getstatus.getStatusCode());        
		incidentsys_id= getstatus.body().jsonPath().getString("result[0].sys_id");	
		System.out.println("print the sys_id: " +incidentsys_id);
		
		
		}
	    
	@Test
    public void updateIncident() {
	
		Response updatestatus = given()
		.header("Content-Type", "application/json")	
		.pathParam("table_name", "incident")
		.pathParam("sys_id", incidentsys_id)			
		.when()
		.body(new File("src/main/resources/RequestPayload/UpdateIncident.json"))
		.put("/{sys_id}");
		System.out.println(updatestatus.getStatusCode());

	}
	
	@Test(priority=2 )
	public void deleteIncident() {
		
		Response deletestatus=RestAssured.given()
				 .header("Content-Type", "application/json")	
				 .pathParam("table_name", "incident")
				 .pathParam("sys_id", incidentsys_id)
		         .when()
		         .delete("/{sys_id}");
		System.out.println(deletestatus.getStatusCode()); 
		Assert.assertEquals(deletestatus.getStatusCode(), 204);

	}


}
