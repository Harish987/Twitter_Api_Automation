import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Trending_Hashtag_Twitter {
	int[] k = {1,2295383,28218,23424977,23424852};
	String ConsumerKey="2Xtd4ILUtinfACHehAvCNcbjW";
	String ConsumerSecret="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	@Test
	public void get_hashtag_Tweet()
{
		
		for(int i=0;i<k.length;i++)
	{
		RestAssured.baseURI="https://api.twitter.com/1.1/trends";
		Response resp=given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
		queryParam("id",k[i])
		.when().get("/place.json").then().extract().response();
		
		String response=resp.asString();
		System.out.println(response);
		JsonPath json=new JsonPath(response);
		String id=json.get("name").toString();
		System.out.println(id);
			
	}
}
	}

