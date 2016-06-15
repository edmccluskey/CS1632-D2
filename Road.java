//Ed McCluskey
//cs1632
//Deliverable 2 - CitySim9001


//ROAD
public class Road
{
	//name
	String name;
	//cities (can travel from 1 to 2 only)
	String location1;
	String location2;
	public Road(String name, String location1, String location2)
	{
		this.name = name;
		this.location1 = location1;
		this.location2 = location2;
	}
	
	public String get_name() {
		return (name);
	}
	public String get_location1() {
		return (location1);
	}
	public String get_location2() {
		return (location2);
	}
	
}
