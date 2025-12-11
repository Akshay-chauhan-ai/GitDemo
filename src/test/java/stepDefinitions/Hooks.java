package stepDefinitions;

import java.io.IOException;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.mode_return;
import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		//write a code where we will give you placeid
		//execute this code when place id is null
		if (StepDefinitions.place_id==null) {
			
		
		
		StepDefinitions m = new StepDefinitions();
		m.add_place_payload_with("shetty", "phili", "asia");
		m.user_calls_with_http_request("AddplaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("shetty", "GetplaceAPI");
	}
	
	}
}
