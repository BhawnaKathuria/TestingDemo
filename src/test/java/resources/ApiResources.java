package resources;

public enum ApiResources {
	
	AddPlace("maps/api/place/add/json"),
	getPlace("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");
	private String resources;

	ApiResources(String resource) {
		this.resources=resource;
		
	}
	
	
	public String getResources() {
		// TODO Auto-generated method stub
		return resources;
	}
	
	
	
	
	

}
