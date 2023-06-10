package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hook {
	
	@Before("@DeletePlace")
	public void beforScenario() throws IOException
	{
		stepDefinition m=new stepDefinition();
		if(stepDefinition.placeid==null)
		{
		m.add_place_payload("Radha", "gb-GB", "Australia");
		m.user_calls_api_with_http_request("AddPlace", "POST");
		m.verify_place_id_created_maps_to_using("Radha", "getPlace");
		}
		
	}

}
