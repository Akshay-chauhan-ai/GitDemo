package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.Location;

public class TestDataBuild {

	public Addplace addplacepayload(String name, String language, String address) {
		Addplace p = new Addplace();

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setAddress(address);
		p.setLocation(l);
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("8712612615414");
		p.setLanguage(language);
		p.setWebsite("www.akshaychauhan.com");
		List<String> myList = new ArrayList<String>();
		myList.add("shop park");
		myList.add("shop");
		p.setTypes(myList);
		return p;

	}

	public String deleteplacepayload(String place_idd) {
		return"{\r\n\"place_id\": \""+place_idd+"\"\r\n}";
		
	}
}
