package project.g7;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CoordinateTest.class, CustomerTest.class, RegionListTest.class, RegionTest.class, RestaurantTest.class,
		SupportStaffMemberTest.class, SystemAdministratorTest.class })
public class AllTests {

}
