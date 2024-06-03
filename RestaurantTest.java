package project.g7;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestaurantTest {
	
	private Restaurant restaurantTest;
	
	@BeforeEach
	void setUp() throws Exception {
		restaurantTest = new Restaurant("Pizza Place", "Fredericton", "Italian", LocalTime.of(5,0,0,0), LocalTime.of(20,0,0,0), true, 4.9, 25.99);
	}

	@Test
	void testRestaurant() {
		Restaurant restaurantTest2 = new Restaurant("Croissant Place", "Fredericton", "French", LocalTime.of(0,0,0,0), LocalTime.of(21,0,0,0), true, 5.0, 30.00);
		
		assertNotNull(restaurantTest2);
	}

	@Test
	void testGetFoodType() {
		assertEquals(restaurantTest.getFoodType(), "Italian");
	}

	@Test
	void testGetOpenHours() {
		assertEquals(restaurantTest.getOpenHours(), LocalTime.of(5,0,0,0));
	}

	@Test
	void testGetCloseHours() {
		assertEquals(restaurantTest.getCloseHours(), LocalTime.of(20,0,0,0));
	}

	@Test
	void testGetDeliveryOption() {
		assertEquals(restaurantTest.getDeliveryOption(), true);
	}

	@Test
	void testGetRating() {
		assertEquals(restaurantTest.getRating(), 4.9);
	}

	@Test
	void testGetAveragePrice() {
		assertEquals(restaurantTest.getAveragePrice(), 25.99);
	}

	@Test
	void testSetFoodType() {
		restaurantTest.setFoodType("Canadian");
		
		assertEquals(restaurantTest.getFoodType(), "Canadian");
	}

	@Test
	void testSetOpeningHours() {
		restaurantTest.setOpeningHours(LocalTime.of(10,0,0,0));
		
		assertEquals(restaurantTest.getOpenHours(), LocalTime.of(10,0,0,0));
	}

	@Test
	void testSetClosingHours() {
		restaurantTest.setClosingHours(LocalTime.of(11,0,0,0));
		
		assertEquals(restaurantTest.getCloseHours(), LocalTime.of(11,0,0,0));
	}

	@Test
	void testSetRating() {
		restaurantTest.setRating(4.99);
		
		assertEquals(restaurantTest.getRating(), 4.99);
	}

	@Test
	void testSetAveragePrice() {
		restaurantTest.setAveragePrice(25.50);
		
		assertEquals(restaurantTest.getAveragePrice(), 25.50);
	}

}
