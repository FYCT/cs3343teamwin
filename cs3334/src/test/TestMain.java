package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.main;

/**
 * The Class TestMain.
 */
public class TestMain extends TestCase{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test if result has duplicate lines
	 */
	@Test
	public void testDuplicate(){
		
		//2: Get a list of misused words, for learners
		//b: British English 
		String input = "d\n2\nb";
		System.setIn(new ByteArrayInputStream(
		           input.getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(outContent));
		
		//Call Main method
		main.Menu();
		
		System.out.println(outContent.toString().split("\n").length);
		int length = outContent.toString().split("\n").length;
		
		String[] outputArray = new String[length];
		for(int i=0;i<outputArray.length;i++)
		{
			outputArray[i] = outContent.toString().split("\n")[i];
			//System.out.println(outputArray[i]);
		}
		
		//check duplicate
		boolean duplicate = false;
		for(int i=0;i<outputArray.length;i++)
		{
			for(int j=0;j<outputArray.length;j++)
			{
				if(i!=j
					&& !outputArray[i].equals("============================================")
					&& !outputArray[i].equals("==========================================")
					&& !outputArray[i].equals("")
					&& !outputArray[i].equals("\r"))
				{
					if(outputArray[i].equals(outputArray[j]))
					{
						duplicate = true;
					}
				}
			}
		}
		
		//expect "false" - no duplication
		assertEquals(false, duplicate);
		
	}

}
