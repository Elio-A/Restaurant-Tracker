package project.g7;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportStaffMemberTest {
	
	private SupportStaffMember supportTest;
	
	@BeforeEach
	void setUp() throws Exception {
		supportTest = new SupportStaffMember("123-4567", "John Johnson");
	}

	@Test
	void testSupportStaffMember() {
		SupportStaffMember supportTestNew = new SupportStaffMember("111-1111", "Stanley West");
		assertNotNull(supportTestNew);
	}

	@Test
	void testSetPhoneNum() {
		supportTest.setPhoneNum("555-5555");
		assertEquals(supportTest.getPhoneNum(), "555-5555");
	}

	@Test
	void testSetName() {
		supportTest.setName("Paul Serena");
		assertEquals(supportTest.getName(), "Paul Serena");
	}

	@Test
	void testGetPhoneNum() {
		assertEquals(supportTest.getPhoneNum(), "123-4567");
	}

	@Test
	void testGetName() {
		assertEquals(supportTest.getName(), "John Johnson");
	}

}
