//Ed McCluskey
//cs1632
//Deliverable 2 - CitySim9001


import java.util.*;

public class CitySim9001 {
	Random rand;
	
public int random_start_location() {
	//choose a random number between 0-4
	int rndm;
	rndm=rand.nextInt(5);
	return (rndm);
}

public int random_move() {
	//choose a random number between 0-1
	int rndm;
	rndm=rand.nextInt(2);
	return (rndm);
}

public String move_driver(Driver driver, Location[] location, Road[] road) {
	int count=0;
	String destination1="ERROR";
	String destination2="ERROR";
	String roadtravelled1="ERROR";
	String roadtravelled2="ERROR";
	String roadtravelled="ERROR";
		
	for (int x=0; x<=7; x++) {
		if (road[x].get_location1().equals(driver.get_location()))
		{
			if (count==0) {
				destination1=road[x].get_location2();
				roadtravelled1=road[x].get_name();
				count++;
			}
			else {
				destination2=road[x].get_location2();
				roadtravelled2=road[x].get_name();
			}
		}
	}
	
	//get random 0 or 1 to decide move
	int choice=random_move();
	
	if (choice==0) {
		driver.MoveTo(destination1);
		roadtravelled=roadtravelled1;
	}
	if (choice==1) {
		driver.MoveTo(destination2);
		roadtravelled=roadtravelled2;
	}
	return (roadtravelled);
}

public String move_driver_fromoutside(Driver driver, Location[] location, Road[] road) {
	String roadtravelled="ERROR";

	//get random 0 or 1 to decide move
	int choice=random_move();
	
	if (choice==0) {
		driver.MoveTo("Hotel");
		roadtravelled="Fourth Ave";
	}
	if (choice==1) {
		driver.MoveTo("College");
		roadtravelled="Fifth Ave";
	}
	
	return (roadtravelled);
	
}

public static void main(String[] args) {
	CitySim9001 citysim = new CitySim9001();
	citysim.start(args);
}

public void start(String[] args) {
	
	int rndm_seed=0;
	String seed_input;
	String road_travelled="ERROR";
	int turn;

	seed_input=args[0].toString();
	rndm_seed=Integer.parseInt(seed_input);
	rand= new Random(rndm_seed);

	Location[] location;
	location = new Location[5];
    location[0] = new Location("Hotel","Fourth Ave","Bill St");
    location[1] = new Location("Diner","Fourth Ave","Phil St");
    location[2] = new Location("Library","Fifth Ave", "Bill St");
    location[3] = new Location("College","Fifth Ave", "Phil St");
    location[4] = new Location("Outside","---","---");
    

	Road [] road;
	road = new Road[8];
	road[0] = new Road("Fourth Ave","Hotel","Diner");
	road[1] = new Road("Fourth Ave","Diner","Outside");
	road[2] = new Road("Fifth Ave","College","Library");
	road[3] = new Road("Fifth Ave","Library","Outside");
	road[4] = new Road("Bill St","Library","Hotel");
	road[5] = new Road("Bill St","Hotel","Library");
	road[6] = new Road("Phil St","College","Diner");
	road[7] = new Road("Phil St","Diner","College");
    

	Driver [] driver;
	driver = new Driver[5];
	int start_location=random_start_location();
	String location_name = location[start_location].get_name();
	for (int x=0; x<=4; x++)
	{
		driver[x] = new Driver(location_name);
	}
	
	turn=0;
	for (int x=0; x<=4; x++) {
		
		//loop while driver is not outside the city
		//unless its the first turn
		while ((turn==0)||!(driver[x].get_location().equals("Outside")))
		{
			System.out.print("Driver ");
			System.out.print(x);
			System.out.print(" heading from ");
			System.out.print(driver[x].get_location());
			System.out.print(" to ");
			if (driver[x].get_location().equals("Outside"))
				road_travelled=move_driver_fromoutside(driver[x], location, road);
			else
				road_travelled=move_driver(driver[x], location, road);
			System.out.print(driver[x].get_location());
			System.out.print(" via ");
			System.out.print(road_travelled);
			System.out.println(".");
			turn++;
		}
		
		//end of turn
		System.out.print("Driver ");
		System.out.print(x);
		System.out.print(" has gone to ");
		if (road_travelled.equals("Fifth Ave"))
			System.out.println("Cleveland!");
		if (road_travelled.equals("Fourth Ave"))
			System.out.println("Philadelphia!");
		System.out.println("-----");
		turn=0;
	}
	
	
	
	
	
}


}