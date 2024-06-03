package project.g7;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegionListTest {
	
	private RegionList regionListTest;
	private ArrayList<Region> ar1;
	private ArrayList<Region> ar2;
	private Region regionTest1;
	private Restaurant restaurantTest1;
	
	@BeforeEach
	void setUp() throws Exception {
		Coordinate c0 = new Coordinate(0,0);
		ArrayList<Restaurant> r0 = new ArrayList<Restaurant>();
		Restaurant restaurantTest0 = new Restaurant("Pizza Place", "Fredericton", "Italian", LocalTime.of(5,0,0,0), LocalTime.of(23,0,0,0), true, 4.9, 25.99);
		restaurantTest1 = new Restaurant("Croissant Place", "Fredericton", "French", LocalTime.of(5,0,0,0), LocalTime.of(23,0,0,0), true, 4.9, 500.99);
		r0.add(restaurantTest0);
		r0.add(restaurantTest1);
		regionTest1 = new Region("Fredericton", c0, r0);
		
		Coordinate c1 = new Coordinate(5,600);
		ArrayList<Restaurant> r1 = new ArrayList<Restaurant>();
		Restaurant restaurantTest2 = new Restaurant("Apple Pie Place", "Fredericton", "Canadian", LocalTime.of(5,0,0,0), LocalTime.of(23,0,0,0), true, 4.9, 25.99);
		Restaurant restaurantTest3 = new Restaurant("Pasta Place", "Fredericton", "Italian", LocalTime.of(5,0,0,0), LocalTime.of(23,0,0,0), true, 4.9, 50.99);
		r1.add(restaurantTest2);
		r1.add(restaurantTest3);
		Region regionTest2 = new Region("Fredericton", c1, r1);
		
		
		ar1 = new ArrayList<Region>();
		
		ar2 = new ArrayList<Region>();
		
		ar1.add(regionTest1);
		ar1.add(regionTest2);
		
		regionListTest = new RegionList(ar1);
	}

	@Test
	void testRegionList() {
		assertNotNull(regionListTest);
	}

	@Test
	void testGetRegionLst() {
		assertEquals(regionListTest.getRegionLst(), ar1);
	}

	@Test
	void testSetRegionLst() {
		regionListTest.setRegionLst(ar2);
		assertEquals(regionListTest.getRegionLst(), ar2);
	}

	@Test
	void testGetFullOrderedRestaurantList() {
		Customer customer = new Customer(50.3, regionTest1, "French");
		
		ArrayList<Restaurant> r1 = new ArrayList<Restaurant>();
		
		r1.add(restaurantTest1);
		
		assertEquals(regionListTest.getFullOrderedRestaurantList(customer), r1);
	}

}
