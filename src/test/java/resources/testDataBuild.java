package resources;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import pojo.AppPlace;
import pojo.Location;

public class testDataBuild {
	
	public AppPlace AddPlacePayload(String name, String language, String address)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		AppPlace place=new AppPlace();
		place.setAccuracy(50);
		place.setAddress(address);
		place.setLanguage(language);
		place.setPhone_number("9891173456");
		place.setWebsite("www.rahulshetty.com");
		place.setName(name);
		List<String> types=new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		place.setTypes(types);
		Location loc=new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		place.setLocation(loc);
		
		return place;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}

}
