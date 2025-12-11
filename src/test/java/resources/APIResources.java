package resources;

//enum is special class in java which have collection  of constant methods.
//we don't need any return string anything directly declared here.
//here declare constructor
public enum APIResources {

	AddplaceAPI("maps/api/place/add/json"), 
	GetplaceAPI("maps/api/place/get/json"),
	deleteplaceAPI("maps/api/place/delete/json");

	private String resource;

	APIResources(String resource) {

		this.resource = resource;
	}

	public String getresource() {

		return resource;

	}
}
