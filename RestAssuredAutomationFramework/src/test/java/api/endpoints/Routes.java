package api.endpoints;
/*This class is to maintain only URLs of every module and not any methods*/
public class Routes {
	/*Base URL: https://petstore.swagger.io/v2 */
	//Post to Create User
	//endpoint: user 
	//url :https://petstore.swagger.io/v2/user
	
	//Get to get user 
		//endpoint: user
	    //path parameter: {username} 
		//url :https://petstore.swagger.io/v2/user/{username}
	
	//Put to update user
		//endpoint: user
		//path parameter: {username} 
		//url :https://petstore.swagger.io/v2/user/{username}	
	
	//Delete for deleting user
	    //endpoint: user
	    //path parameter: {username} 
	    //url :https://petstore.swagger.io/v2/user/{username}	
	
	
	public static String base_url ="https://petstore.swagger.io/v2";
	
	//user module urls	
	public static String post_url = base_url+"/user";
	
	public static String get_url = base_url+"/user/{username}";
	
	public static String put_url = base_url+"/user/{username}";
	
	public static String delete_url = base_url+"/user/{username}";
	
	// pet module urls
	
	// Store module urls
}

