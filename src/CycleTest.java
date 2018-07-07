import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
class CycleTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testcheck() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
	}
	
	@Test
	void testgetall() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Cycle cc=new Cycle("anyrandomstring");
		cc.getall();
		Assert.assertEquals("SomeName", cyc.name);
		Assert.assertEquals("SomeID", cyc.cid);
		Assert.assertEquals("SomeCtype", cyc.ctype);
		Assert.assertEquals("SomeHall",cyc.hall);
		Assert.assertEquals("NO",cyc.avail);
		Assert.assertEquals(cyc.remove(),true);
	}
	
	@Test
	void testRegister() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Assert.assertEquals(cyc.remove(),true);
	}
	
	
	@Test
	void testremove() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Assert.assertEquals(cyc.remove(),true);
	}
	
	@Test
	void testtoggle() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Assert.assertEquals("NO", cyc.avail);
		cyc.toggle();
		Assert.assertEquals("YES", cyc.avail);
		cyc.toggle();
		Assert.assertEquals("NO", cyc.avail);
		Assert.assertEquals(cyc.remove(),true);
	}
	
	@Test
	void testtoogleInRide() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Assert.assertEquals("NO", cyc.inride);
		cyc.toggleinride();
		Assert.assertEquals("YES", cyc.inride);
		cyc.toggleinride();
		Assert.assertEquals("NO", cyc.inride);
		Assert.assertEquals(cyc.remove(),true);
	}
	@Test
	void testgetall2() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Cycle cc=new Cycle("anyrandomstring");
		cc.getall();
		Assert.assertEquals("SomeName", cyc.name);
		Assert.assertEquals("SomeID", cyc.cid);
		Assert.assertEquals("SomeCtype", cyc.ctype);
		Assert.assertEquals("SomeHall",cyc.hall);
		Assert.assertEquals("NO",cyc.avail);
		Assert.assertEquals(cyc.remove(),true);
	}
	
	@Test
	void testRegister2() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Assert.assertEquals(cyc.remove(),true);
	}
	
	
	@Test
	void testremove2() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Assert.assertEquals(cyc.remove(),true);
	}
	
	@Test
	void testtoggle2() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Assert.assertEquals("NO", cyc.avail);
		cyc.toggle();
		Assert.assertEquals("YES", cyc.avail);
		cyc.toggle();
		Assert.assertEquals("NO", cyc.avail);
		Assert.assertEquals(cyc.remove(),true);
	}
	
	@Test
	void testtoogleInRide2() {
		Cycle cyc=new Cycle("anyrandomstring");
		//now this should not exist in the database
		Assert.assertEquals(false, cyc.check());
		cyc.getRegister("SomeName", "SomeID", "SomeCtype", "SomeHall", "NO");
		Assert.assertEquals(true,cyc.getRegister());
		Assert.assertEquals("NO", cyc.inride);
		cyc.toggleinride();
		Assert.assertEquals("YES", cyc.inride);
		cyc.toggleinride();
		Assert.assertEquals("NO", cyc.inride);
		Assert.assertEquals(cyc.remove(),true);
	}
}
