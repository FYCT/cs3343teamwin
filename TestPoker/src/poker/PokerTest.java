package poker;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PokerTest extends TestCase{
	private Poker poker;

	/**
	 * Sets up the test fixture.
	 *
	 * Called before every test case method.
	 */
	public void setUp() { poker = new Poker(); }

	/**
	 * Tears down the test fixture.
	 *
	 * Called after every test case method.
	 */
	public void tearDown() {}

	// Test case 1: n = 0, cards = { }
	public void testNoCards() {
		boolean result;
		String[] input = null;
		result = poker.isFullHouse(input, 0);
		assertEquals(result, false);
	}

	// Test case 2: n = 5, cards = {"C2", "D2", "H2", "S3", "S4"};
	public void test22234() {
		boolean result;
		String[] input = new String[] {"C2", "D2", "H2", "S3", "S4"};
		result = poker.isFullHouse(input, 5);
		assertEquals(result, false);
	}
	
	// Test case 3: n = 5, cards = {"DJ", "SJ", "CK", "DK", "HK"};
	public void testJJKKK() {
		boolean result;
		String[] input = new String[] {"DJ", "SJ", "CK", "DK", "HK"};
		result = poker.isFullHouse(input, 5);
		assertEquals(result, true);
	}

	// Test case 4: n = 5, cards = {"C3", "D3", "S3", "HX", "SX"};
	public void test333XX() {
		boolean result;
		String[] input = new String[] {"C3", "D3", "S3", "HX", "SX"};
		result = poker.isFullHouse(input, 5);
		assertEquals(result, true);
	}

	// Test case 5: n = 5, cards = {"C2", "D2", "C3", "D3", "C4"};
	public void test22334() {
		boolean result;
		String[] input = new String[] {"C2", "D2", "C3", "D3", "C4"};
		result = poker.isFullHouse(input, 5);
		assertEquals(result, false);
	}

	// Test case 6: n = 5, cards = {"CA", "C2", "C3", "C4", "C5"};
	public void testA2345() {
		boolean result;
		String[] input = new String[] {"CA", "C2", "C3", "C4", "C5"};
		result = poker.isFullHouse(input, 5);
		assertEquals(result, false);
	}
	 
	

	// Test case 7: n = 5, cards = {"C6", "D6", "H6", "S6", "D7"};
	public void test66667() {
		boolean result;
		String[] input = new String[] {"C6", "D6", "H6", "S6", "D7"};
		result = poker.isFullHouse(input, 5);
		assertEquals(result, false);
	}

	// Test case 8: n = 5, cards = {"CA", "DX", "HX", "SX", "DK"};
	public void testAXXXK() {
		boolean result;
		String[] input = new String[] {"CA", "DX", "HX", "SX", "DK"};
		result = poker.isFullHouse(input, 5);
		assertEquals(result, false);
	}
	 
}
