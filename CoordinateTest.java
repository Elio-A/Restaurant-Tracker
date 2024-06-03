package project.g7;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CoordinateTest {

	@Test
	void testCoordinate() {
		Coordinate testCoordinate0_0 = new Coordinate(0.0,0.0);
		assertNotNull(testCoordinate0_0);
		
		Coordinate testCoordinate1_0 = new Coordinate(1.0,0.0);
		assertNotNull(testCoordinate1_0);
		
		Coordinate testCoordinate0_1 = new Coordinate(0.0,1.0);
		assertNotNull(testCoordinate0_1);
		
		Coordinate testCoordinateNegative1_0 = new Coordinate(-1.0,0.0);
		assertNotNull(testCoordinateNegative1_0);
		
		Coordinate testCoordinate0_Negative1 = new Coordinate(0.0,-1.0);
		assertNotNull(testCoordinate0_Negative1);
		
		Coordinate testCoordinateRandom = new Coordinate(5.023,-3.01);
		assertNotNull(testCoordinateRandom);
		
		Coordinate testCoordinateLarge = new Coordinate(100000,-100000);
		assertNotNull(testCoordinateLarge);
	}

	@Test
	void testGetDistance() {
		Coordinate testCoordinate0 = new Coordinate(0,0);
		Coordinate testCoordinate1 = new Coordinate(3,4);
		Coordinate testCoordinate2 = new Coordinate(-3.2,5.302);
		
		assertEquals(testCoordinate0.getDistance(testCoordinate0), 0);
		
		assertEquals(testCoordinate1.getDistance(testCoordinate1), 0);
		
		assertEquals(testCoordinate0.getDistance(testCoordinate1), 5);
		
		assertEquals(testCoordinate1.getDistance(testCoordinate0), 5);
		
		assertEquals(testCoordinate2.getDistance(testCoordinate1), Math.sqrt((Math.pow((-3.2-3), 2))+(Math.pow(5.302-4, 2))));
	}

}
