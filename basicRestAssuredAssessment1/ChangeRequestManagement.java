package basicRestAssuredAssessment1;

import static io.restassured.RestAssured.basic;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ChangeRequestManagement {

    public static void main(String[] args) {
    	// Base URI and authentication setup
    	
    	RestAssured.baseURI = "https://dev282483.service-now.com";
    	RestAssured.authentication = basic("admin", "cv-H00neFIF@");
    	
    	// Create a new change request
    	createChangeRequest();
    	
     }
    
  
    public static void createChangeRequest() {
		
    	String changeRequestPayload = """
				{
    			"short_description": "Request for Laptop Access",
    			"description": "Laptop Access",
    			"urgency": 1,
    			"phase_state": "open"
    			}
				""";
    	
    	// Sending POST request to create change request
    	
    	Response response = RestAssured.given()
        .contentType(ContentType.JSON)
        .body(changeRequestPayload)
        .post("/api/now/table/change_request");
    	
    	// Print response to console
    	
        System.out.println("Create Change Request Response: ");
        response.prettyPrint();

    	

	}
}
