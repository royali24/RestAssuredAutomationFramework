package api.endpoints;
import com.aventstack.extentreports.gherkin.model.Given;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserEndPoints {

	//Post - create user
	//Payload :
	/*
	 *
		[
		  {
		    "id": 0,
		    "username": "string",
		    "firstName": "string",
		    "lastName": "string",
		    "email": "string",
		    "password": "string",
		    "phone": "string",
		    "userStatus": 0
		  }
		]
	 */
	
	public static Response createUser(UserPayload payload)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	public static Response getUser(String userName)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(Routes.get_url);
		
		return response;
	}
	
	public static Response updateUser(UserPayload payload, String userName)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		.when()
		.put(Routes.put_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
	
		
		.when()
		.delete(Routes.delete_url);
	
		
		return response;
	}
}
