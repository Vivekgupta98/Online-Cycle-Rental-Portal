import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

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
	void testcheckexist() {
		User testuser=new User("someRandomNameqa");
		Assert.assertEquals(false, testuser.checkexist());
		testuser.registernew("someRandomNameqa", "someRandomPass", "tfname", "tlname", "temail", "tphone", "taddr");
		
	}
	@Test
	void testregisternew() {
		User testuser=new User("someRandomNamettt");
		Assert.assertEquals(false, testuser.checkexist());
		testuser.registernew("someRandomNamettt", "someRandomPass", "tfname", "tlname", "temail", "tphone", "taddr");
		testuser.getRegister();
		Assert.assertEquals(true, testuser.checkexist());
	}
	@Test
	void testgetall() {
		User testuser=new User("somemorerandomtt");
		Assert.assertEquals(false, testuser.checkexist());
		testuser.registernew("somemorerandomtt", "someRandomPass", "tfname", "tlname", "temail", "tphone", "taddr");
		testuser.getRegister();
		Assert.assertEquals(true, testuser.checkexist());
		Assert.assertEquals("somemorerandomtt", testuser.username);
	}
	@Test
	void testinride() {
		User testuser=new User("someRandomNamett");
		Assert.assertEquals(false, testuser.checkexist());
		testuser.registernew("someRandomNamett", "someRandomPass", "tfname", "tlname", "temail", "tphone", "taddr");
	}
	@Test
	void testgetregister() {
		User testuser=new User("someRandomNameX");
		Assert.assertEquals(false, testuser.checkexist());
		testuser.registernew("someRandomNameX", "someRandomPass", "tfname", "tlname", "temail", "tphone", "taddr");
		testuser.getRegister();
		Assert.assertEquals(true, testuser.checkexist());
	}
	@Test
	void testgetOwner() {
		User testuser=new User("someRandomNameY");
		Assert.assertEquals(false, testuser.checkexist());
		testuser.registernew("someRandomNameY", "someRandomPass", "tfname", "tlname", "temail", "tphone", "taddr");
	}

}
