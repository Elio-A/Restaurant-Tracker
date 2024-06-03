package project.g7;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegionTest {
	
	private Region regionTest;
	private ArrayList<Restaurant> r0;
	private Coordinate c0;
	
	@BeforeEach
	void setUp() throws Exception {
		c0 = new Coordinate(0,0);
		r0 = new ArrayList<Restaurant>();
		Restaurant restaurantTest = new Restaurant("Pizza Place", "Fredericton", "Italian", LocalTime.of(5,0,0,0), LocalTime.of(23,0,0,0), true, 4.9, 25.99);
		Restaurant restaurantTest2 = new Restaurant("Croissant Place", "Fredericton", "French", LocalTime.of(5,0,0,0), LocalTime.of(23,0,0,0), true, 4.9, 500.99);
		r0.add(restaurantTest);
		r0.add(restaurantTest2);
		regionTest = new Region("Fredericton", c0, r0);
	}

	@Test
	void testRegion() {
		assertNotNull(regionTest);
	}

	@Test
	void testGetName() {
		assertEquals(regionTest.getName(), "Fredericton");
	}

	@Test
	void testGetCoordinate() {
		assertEquals(regionTest.getCoordinate(), c0);
	}

	@Test
	void testGetOrderedRestaurantList() {
		Customer customerTest = new Customer(50.25, regionTest, "Italian");
		ArrayList<Restaurant> r1 = new ArrayList<Restaurant>();
		r1.add(r0.get(0));
		assertEquals(regionTest.getOrderedRestaurantList(customerTest), r1);
	}
	
	@Test
	void testGetRestaurants() {
		assertEquals(regionTest.getRestaurants(), r0);
	}

	@Test
	void testSetName() {
		regionTest.setName("Moncton");
		assertEquals(regionTest.getName(), "Moncton");
	}

	@Test
	void testSetCoordinate() {
		Coordinate coord1 = new Coordinate(5, 5);
		regionTest.setCoordinate(coord1);
		assertEquals(regionTest.getCoordinate(), coord1);
	}

	@Test
	void testSetRestaurantList() {
		ArrayList<Restaurant> r1 = new ArrayList<Restaurant>();
		r1.add(r0.get(1));
		r1.add(r0.get(0));
		
		regionTest.setRestaurantList(r1);
		
		assertEquals(regionTest.getRestaurants(), r1);
	}

}
