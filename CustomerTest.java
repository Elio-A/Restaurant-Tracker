package project.g7;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	
	private Customer customerTest;
	private Region currentRegion;
	
	@BeforeEach
	void setUp() throws Exception {
		Coordinate currentRegionCoord = new Coordinate(0,0);
		ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
		currentRegion = new Region("Fredericton", currentRegionCoord, restaurantList);
		customerTest = new Customer(50.25, currentRegion, "Italian");
	}

	@Test
	void testCustomer() {
		Coordinate testRegionCoord = new Coordinate(0,0);
		ArrayList<Restaurant> testRestaurantList = new ArrayList<Restaurant>();
		Region testRegion = new Region("Fredericton", testRegionCoord, testRestaurantList);
		
		Customer customerTest2 = new Customer(10, testRegion, "French");
		
		assertNotNull(customerTest2);
	}

	@Test
	void testSetNormalBudget() {
		assertEquals(customerTest.setBudget(25.00), true);
	}
	
	@Test
	void testSetIntBudget() {
		assertEquals(customerTest.setBudget(100), true);
	}
	
	@Test
	void testSetZeroBudget() {
		assertEquals(customerTest.setBudget(0), false);
		assertEquals(customerTest.getBudget(), 50.25);
	}
	
	@Test
	void testSetNegativeBudget() {
		assertEquals(customerTest.setBudget(-1.5), false);
		assertEquals(customerTest.getBudget(), 50.25);
	}
	
	@Test
	void testSetDecimalBudget() {
		assertEquals(customerTest.setBudget(0.25), true);
	}

	@Test
	void testSetRegion() {
		Coordinate testNewRegionCoord = new Coordinate(0,0);
		ArrayList<Restaurant> testNewRestaurantList = new ArrayList<Restaurant>();
		Region testNewRegion = new Region("Moncton", testNewRegionCoord, testNewRestaurantList);
		
		customerTest.setRegion(testNewRegion);
		
		assertEquals(customerTest.getRegion(), testNewRegion);
	}

	@Test
	void testSetFoodPreference() {
		customerTest.setFoodPreference("American");
		
		assertEquals(customerTest.getFoodPreference(), "American");
	}

	@Test
	void testGetBudget() {
		assertEquals(customerTest.getBudget(), 50.25);
	}

	@Test
	void testGetRegion() {
		assertEquals(customerTest.getRegion(), currentRegion);
	}

	@Test
	void testGetFoodPreference() {
		assertEquals(customerTest.getFoodPreference(), "Italian");
	}

}
