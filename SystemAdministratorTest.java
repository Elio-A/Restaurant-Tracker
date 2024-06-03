package project.g7;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SystemAdministratorTest {
	
	private SystemAdministrator adminTest;
	
	@BeforeEach
	void setUp() throws Exception {
		adminTest = new SystemAdministrator("December 15, 2030", "ADMIN_PASS");
	}

	@Test
	void testSystemAdministrator() {
		SystemAdministrator adminTest1 = new SystemAdministrator("October 20, 2024", "123");
		assertNotNull(adminTest1);
	}

	@Test
	void testSetTrainingDate() {
		assertEquals(adminTest.setTrainingDate("October 22, 2025"), true);
	}

	@Test
	void testGetTrainingDate() {
		assertEquals(adminTest.getTrainingDate(), "December 15, 2030");
	}

	@Test
	void testGetPassword() {
		assertEquals(adminTest.getPassword(), "ADMIN_PASS");
	}

}
