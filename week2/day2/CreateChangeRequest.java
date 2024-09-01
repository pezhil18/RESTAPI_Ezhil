package week2.day2;

import io.restassured.RestAssured;

public class CreateChangeRequest {

	public static void main(String[] args) {
		
		String url = "https://dev282483.service-now.com/api/now/table/change_request";
		String jsonrequestpayload = """
					{
							"short_description": "RequestforVDIAccess",
							"description": "VDIAccess"
					}
					""";
		RestAssured.given()
				   .auth()
				   .basic("admin", "cv-H00neFIF@")
				   .header("Content-Type", "application/json")
				   .log()
				   .all()
				   .when()
				   .body(jsonrequestpayload)
				   .post(url)
				   .then()
				   .log()
				   .all();
				   
				   
	}

}
