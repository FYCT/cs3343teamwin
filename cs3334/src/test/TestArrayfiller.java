package test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import project.Arrayfiller;


public class TestArrayfiller extends TestCase{
	ArrayList<String> list = new ArrayList<String>();
	String[] array = new String[100];
	Arrayfiller test = new Arrayfiller();
	String[] tokens = new String[100];

	@Test
	public void testBlank_array() {
		array=test.fill(array, "src/blank.txt");
		String result = array[0];
		assertEquals(result, null);
	}
	@Test
	public void testBlank_list() {
		list=test.fill(list, "src/blank.txt");
		int result = list.size();
		assertEquals(result, 0);
	}
	@Test
	public void testOneline_array() {
		array=test.fill(array, "src/oneline.txt");
		String result = array[0];
		assertEquals(result.charAt(0), 'a');
	}
	@Test
	public void testOneline_list() {
		list=test.fill(list, "src/oneline.txt");
		int result = list.size();
		assertEquals(result, 1);
	}
	@Test
	public void testMatch_array() {
		array=test.fill(array, "src/oneline.txt");
		String result = array[0];
		assertEquals(result, "abcdefghijklmnopqrstuvwxyz");
	}
	@Test
	public void testMatch_list() {
		list=test.fill(list, "src/oneline.txt");
		String result = list.get(0);
		assertEquals(result, "abcdefghijklmnopqrstuvwxyz");
	}
	@Test
	public void testSplit() {
		list=test.fill(list, "src/split.txt");
		tokens = list.get(0).split("c");
		assertEquals(tokens.length, 2);
	}
}
