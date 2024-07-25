package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class UserTest {
	Faker fake;
	UserPayload userpayload; 
	
	@BeforeClass
	public void generateCreateUserData() {
		
		 fake = new Faker();
		 userpayload = new UserPayload();
		 userpayload.setId(fake.idNumber().hashCode());
		 userpayload.setUsername(fake.name().username());
		 userpayload.setFirstName(fake.name().firstName());
		 userpayload.setLastName(fake.name().lastName());
		 userpayload.setEmail(fake.internet().emailAddress());
		 userpayload.setPassword(fake.internet().password(5, 10));
		 userpayload.setPhone(fake.phoneNumber().cellPhone());
	}

	
	@Test (priority=1)
	public void testcreateUser() {
		Response response= UserEndPoints.createUser(userpayload);
		//log repsonse
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test (priority=2)
	public void testgetUserData() {
		Response response= UserEndPoints.getUser(this.userpayload.getUsername());
		//log repsonse
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test (priority=3)
	public void testupdateUser() {
		userpayload.setFirstName(fake.name().firstName());
		
		
		Response response= UserEndPoints.updateUser(userpayload,this.userpayload.getUsername());
		//log repsonse
		response.then().log().all();
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

	@Test(priority=4)
	public void testdeleteUser() {
		
		
		Response response= UserEndPoints.deleteUser(this.userpayload.getUsername());
		
		//log repsonse
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
