import static org.junit.Assert.*;

import java.util.Random;

//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CityTest {

	//Tests creation of Road and that the name is set correctly
	@Test
	public void testRoad() {
		Road r = new Road("a","b","c");
		assertEquals("a", r.get_name());
	}

	//Tests creation of Location and that the name is set correctly
	@Test
	public void testLocation() {
		Location l = new Location("a","b","c");
		assertEquals("a", l.get_name());
	}

	//Tests creation of Driver and that the location is set correctly
	@Test
	public void testDriver() {
		Driver d = new Driver("a");
		assertEquals("a", d.get_location());
	}
	
	//To test moving the driver to a new location
	@Test
	public void testDriver_MoveTo() {
		Driver d = new Driver("a");
		d.MoveTo("b");
		assertEquals("b", d.get_location());
	}
	
	//To test moving the driver to a new location
	@Test
	public void testDriver_MoveTo2() {
		Driver d = new Driver("a");
		d.MoveTo("b");
		assertEquals(1, d.get_location());
	}
	//To test the random choice of 0-4 for a starting location
	@Test
	public void testrandom_start_location() {
		when(nextInt(5)).thenReturn(1);
		int testint=random_start_location();
		assertEquals(1, testint);
	}

	//To test the random choice of 0-1 for a move
	@Test
	public void testrandom_move() {
	}
	
	@Test
	public void testmove_driver() {
	 Driver mockDriver = Mockito.mock(Driver.class);
	 Location mockLocation = Mockito.mock(Location.class);
	 Road mockRoad = Mockito.mock(Road.class);
	 when(mockDriver.quack()).thenReturn(1);
	 String returnroad = move_driver(mockDriver, mockLocation, mockRoad);

	}
	
	//To test choosing a starting location for driver if driver starts outside
	@Test
	public void testmove_driver_fromoutside() {
		 Driver mockDriver = Mockito.mock(Driver.class);
		 Location mockLocation = Mockito.mock(Location.class);
		 Road mockRoad = Mockito.mock(Road.class);
		 when(mockDriver.quack()).thenReturn(1);
		 String returnroad = move_driver_fromoutside(mockDriver, mockLocation, mockRoad);

		
	}
	
}