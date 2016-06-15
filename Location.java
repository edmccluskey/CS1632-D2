//Ed McCluskey
//cs1632
//Deliverable 2 - CitySim9001

//LOCATION
public class Location
{
	//name
	String name;
	//roads to another location
	String road1;
	String road2;
	
	//initialize location with name
	public Location(String name, String road1, String road2)
	{
		this.name = name;
		this.road1 = road1;
		this.road2 = road2;
	}
	
	public String get_name() {
		return (name);
	}
	
	public String get_road1() {
		return (road1);
	}
	
	public String get_road2() {
		return (road2);
	}
}
