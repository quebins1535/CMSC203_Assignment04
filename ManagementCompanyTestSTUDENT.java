

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	ManagementCompany testCo;
	Property p1, p2, p3, p4, p5, p6;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		//student add three properties, with plots, to mgmt co
		testCo = new ManagementCompany("Test Company", "1535", 10);
		
		p1 = new Property ("Avana Northlake", "Germantown", 1550, "John Smith", 1,1,1,1);
		p2 = new Property ("Wonderland Way", "Rockville", 1221, "Jane Doe", 5,2,1,2);
		p3 = new Property ("Twig Terrace", "Silver Spring", 2140, "Michael Scott", 2,3,2,2);
		
		testCo.addProperty(p1);
		testCo.addProperty(p2);
		testCo.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		p1 = p2 = p3 = null;
		testCo = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//fail("STUDENT test not implemented yet");
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property("Dunder Mifflin", "Scranton", 1234, "Dwight Schrute");
		//student should add property with 8 args
		p5 = new Property("Park Place", "Pawnee", 2351, "Lesli Knope", 7,6,1,1);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		p6 = new Property("Nowhere", "Knowhere", 6523, "Star Lord", 8,8,1,1);
		
		assertEquals(testCo.addProperty(p4), 3, 0);
		assertEquals(testCo.addProperty(p5), 4, 0);
		assertEquals(testCo.addProperty(p6), -1, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		//fail("STUDENT test not implemented yet");
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(testCo.maxRentProp(), 2140, 0);
		
		
	}

	@Test
	public void testTotalRent() {
		//fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		assertEquals(testCo.totalRent(), 4911, 0);
	}

 }
