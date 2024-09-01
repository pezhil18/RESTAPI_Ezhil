package week2.day2;

import io.restassured.RestAssured;

public class PatchChangeRequest {

	public static void main(String[] args) {

	String url = "https://dev282483.service-now.com/api/now/table/change_request/cc482ff283d01e10c6e1c5d6feaad388";
	String patchupdatereqpayload = """
			{
				"short_description": "Request for Postman Application",
				" description": "Postman Application Request"
			}

			""";
	RestAssured.given()
			   .auth()
			   .basic("admin", "cv-H00neFIF@")
			   .header("Content-Type", "application/json")
			   .log()
			   .all()
			   .when()
			   .body(patchupdatereqpayload)
			   .patch(url)
			   .then()
			   .log()
			   .all();
			   

	}

}
