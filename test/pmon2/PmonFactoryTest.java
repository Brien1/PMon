package pmon2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
class PmonFactoryTest {

	//test data
	String name, type;
	int hp,at,df,spd;
	Pmon pmon;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		hp = 50;
		at = 50;
		df = 50;
		spd = 70;
		name = "Charmander";
		type = "fire";
		pmon = new Pmon(0, hp, at, df, spd, type, name);
	}

	@Test
	void testMain() {
		
	}
	@Test
	public void testPmon() {
		String expected = "Ditto";
		String expected2= "fire";
		Pmon pmon = new Pmon(0, 0, 0, 0, 0, "fire", expected);
		assertEquals(expected, pmon.getName());
		assertEquals(expected2, pmon.getType());
		
	}
	
}
