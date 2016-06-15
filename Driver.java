//Ed McCluskey
//cs1632
//Deliverable 2 - CitySim9001


//DRIVER
public class Driver
{
	//current location
	String location;
	String location_old;
	
	//initialize driver with starting location
	public Driver(String location) {
		this.location = location;
		this.location_old = "";
	}
	
	public void MoveTo(String location){
		this.location_old=this.location;
		this.location = location;
	}

	public String get_location() {
		return (location);
	}
	
	public String get_location_old() {
		return (location);
	}
	
}
