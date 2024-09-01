package week2.day2;

import io.restassured.RestAssured;

public class PutChangeRequest {

	public static void main(String[] args) {
		
		String url = "https://dev282483.service-now.com/api/now/table/change_request/cc482ff283d01e10c6e1c5d6feaad388";
		String jsonupdaterequestpayload = """
				{
					"short_description": "Request for Client Laptop",
					" description": "Client Laptop Request"
				}
		
				""";
		
		RestAssured.given()
		           .auth()
		           .basic("admin", "cv-H00neFIF@")
		           .header("Content-Type", "application/json")
		           .log()
		           .all()
		           .when()
		           .body(jsonupdaterequestpayload)
		           .put(url)
		           .then()
		           .log()
		           .all();
		       
	}

}
