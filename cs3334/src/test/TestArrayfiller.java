package test;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import project.Arrayfiller;



// TODO: Auto-generated Javadoc
/**
 * The Class TestArrayfiller.
 */
public class TestArrayfiller extends TestCase{
	
	/** The list. */
	ArrayList<String> list = new ArrayList<String>();
	
	/** The array. */
	String[] array = new String[100];
	
	/** The test. */
	Arrayfiller test = new Arrayfiller();
	
	/** The tokens. */
	String[] tokens = new String[100];

	/**
	 * Test blank_array.
	 */
	@Test
	public void testBlank_array() {
		array=test.fill(array, "src/blank.txt");
		String result = array[0];
		assertEquals(result, null);
	}
	
	/**
	 * Test blank_list.
	 */
	@Test
	public void testBlank_list() {
		list=test.fill(list, "src/blank.txt");
		int result = list.size();
		assertEquals(result, 0);
	}
	
	/**
	 * Test oneline_array.
	 */
	@Test
	public void testOneline_array() {
		array=test.fill(array, "src/oneline.txt");
		String result = array[0];
		assertEquals(result.charAt(0), 'a');
	}
	
	/**
	 * Test oneline_list.
	 */
	@Test
	public void testOneline_list() {
		list=test.fill(list, "src/oneline.txt");
		int result = list.size();
		assertEquals(result, 1);
	}
	
	/**
	 * Test match_array.
	 */
	@Test
	public void testMatch_array() {
		array=test.fill(array, "src/oneline.txt");
		String result = array[0];
		assertEquals(result, "abcdefghijklmnopqrstuvwxyz");
	}
	
	/**
	 * Test match_list.
	 */
	@Test
	public void testMatch_list() {
		list=test.fill(list, "src/oneline.txt");
		String result = list.get(0);
		assertEquals(result, "abcdefghijklmnopqrstuvwxyz");
	}
	
	/**
	 * Test split.
	 */
	@Test
	public void testSplit() {
		list=test.fill(list, "src/split.txt");
		tokens = list.get(0).split("c");
		assertEquals(tokens.length, 2);
	}
	
	/**
	 * test if result has duplicate lines
	 */
	
}
