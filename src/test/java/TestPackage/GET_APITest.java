package TestPackage;

import org.testng.annotations.Test;
import VariablesPackage.GET_APIVars;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GET_APITest {
	GET_APIVars getVars;
	@Test
	public void GetPostById () {
		getVars = new GET_APIVars();
		given()
		.get("https://jsonplaceholder.typicode.com/posts/1")
		.then().assertThat()
		.statusCode(200)
		.body("userId",equalTo(getVars.getUserId))
		.body("id",equalTo(getVars.getId))
		.body("title",equalTo(getVars.getTitle))
		.body("body",equalTo(getVars.getBody));
	}
}
