package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	
	
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null)
		{
			System.out.println("Execution of file");
		PrintStream stream=new PrintStream(new FileOutputStream("logging.txt"));
	     req= new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123").
				setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(stream)).addFilter(ResponseLoggingFilter.logResponseTo(stream)).build();
	     
	     return req;
		}
		return req;
	}
	
	public String getGlobalValue(String Key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\kamal\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(Key);
		
		
	}
	
	public String getJsonPath(Response response, String key)
	{
		String res=response.asString();
		JsonPath js=new JsonPath(res);
		return js.get(key).toString();
	}
	public String getUserpath(Response response, String key)
	{
		return "Hello user";
		
	}

}
