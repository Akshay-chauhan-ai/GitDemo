package resources;

import org.codehaus.groovy.classgen.ReturnAdder;

public class Demo {

	// resource deatil we can fill in different class
	
	//enum use insted of this. because we need to create 100 variable and all methods. and declare.

	//that's why always use enum class.
	String addplaceAPI = "/maps/api/place/add/json";
	String getplaceAPI = "/maps/api/place/get/json";
	String deleteplaceAPI = "/maps/api/place/delete/json";

	public String addplaceAPI() {
		return addplaceAPI;
	}

	public String getplaceAPI() {
		return getplaceAPI;
	}

	public String deleteplaceAPI() {
		return deleteplaceAPI;
	}
}
