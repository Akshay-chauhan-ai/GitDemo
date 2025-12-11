package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
//static so each time testrun it will not null previous value
	public RequestSpecification requestspecification() throws IOException {

		if (req == null) {
//so we created a condition so req it will be null for each condition
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			// RestAssured.baseURI = "https://rahulshettyacademy.com";
			req = new RequestSpecBuilder().setBaseUri(getGloblevalue("baseUrl")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();

			return req;
		}
		return req;
	}

	public String getGloblevalue(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Akshay chauhan\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}
	
	
	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath jsonPath = new JsonPath(resp);
	return jsonPath.get(key).toString();
		
	}

}
