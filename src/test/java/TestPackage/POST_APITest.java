package TestPackage;

import org.testng.annotations.Test;
import VariablesPackage.POST_APIVars;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class POST_APITest {
	POST_APIVars postVars;
	JSONObject jsnObject;
	
	@Test
	public void CreatePost () {
		postVars = new POST_APIVars ();
		jsnObject = new JSONObject();
		jsnObject.put("title", postVars.postTitle);
		jsnObject.put("body", postVars.postBody);
		jsnObject.put("userId", postVars.postUserId);
		jsnObject.put("id", postVars.postId);	
		
		given()
		.body(JSONObject.toJSONString(jsnObject))
		.when()
		.post("https://jsonplaceholder.typicode.com/posts")
		.then()
		.assertThat()
		.statusCode(201);
		
		
	

	}
}
