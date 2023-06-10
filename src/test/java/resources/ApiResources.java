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
	
	public void getdetails() {
		// TODO Auto-generated method stub
		System.out.println("print all details");
		System.out.println("print all details for git");
		System.out.println("print all details for Testing");
	}
	public void getdetailsUser() {
		// TODO Auto-generated method stub
		System.out.println("print all details-User");
		System.out.println("print all details for git-User");
		System.out.println("print all details for Testing-User");
		System.out.println("print all details for APIFRAMEWORK USER");
	}
	
	
	
	

}
