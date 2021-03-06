package project;


import java.util.ArrayList;
import java.util.Scanner;



// TODO: Auto-generated Javadoc
/**
 * The Class main.
 */
public class main {
	
	/** The array list which contains the source file. */
	static ArrayList<String> src;
	
	/** The arrays which specify the libraries the the array used for splitting. */
	static String[] brit, amer, tokens;
	
	//for ver 2
	/** The output array lists. */
	static ArrayList<String> outA, outB;

	/** The Constant delimiters. */
	static final String delimiters = "[, .'!@#$%^&*()?]";
	
	//for ver 2
	/** The scanner object. */
	static Scanner s = new Scanner (System.in);
	
	/** The result String. */
	static String result="";
	
	/** The choice for module 2. */
	static char choice;
	
	//for ver 3
	/** The word_search. */
	static Word_search word_search;
	
	/** The counts for each type of word. */
	static int cntAmerican, cntBritish;
	

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @return calls the Menu method to make the class testable.
	 */
	public static void main(String[] args) {
		
		Menu();
	}
	public static void Menu()
	{
		String input_passage = "============================================\n"
				+			   "  Please input the location of the passage  \n"
				+              "         Hint: [folder]"+"/"+"[name].txt    \n"
				+              "       Type 'd' to use default path         \n"
				+              "============================================\n"
				;
		String module_select = "============================================\n"
				+              "       	Please select a module              \n"
				+              "          Type in 1 or 2 or 3               \n"
				+  			   "1. Check the smell of the input passage     \n"
				+			   "2. Get a list of misused words, for learners\n"
				+			   "3. Translate & Identify                     \n"
				+      		   "============================================\n"
				;
		
		String language_select = "==========================================\n"
				+                "    Please select a default language      \n"
				+                "          Type in a or b                  \n"
				+  			     "     1. a stands for American English     \n"
				+			     "     2. b stands for British English      \n"
				+      		     "==========================================\n"
				;
		
		String result_amer =     "==========================================\n"
				+                "    This passage is written by american   \n"
				+      		     "==========================================\n"
				;
		
		String result_brit =     "==========================================\n"
				+                "    This passage is written by british    \n"
				+      		     "==========================================\n"
				;
		
		String result_unkn =     "============================================\n"
				+                "This passage is written by which countryman?\n"
				+      		     "============================================\n"
				;
		
		Arrayfiller aryfil = new Arrayfiller();
		
		src=aryfil.init(src);
		brit=aryfil.init(brit);
		amer=aryfil.init(amer);
		tokens=aryfil.init(tokens);
		
		System.out.println(input_passage);
		String location = s.next();
		if (location.equalsIgnoreCase("d"))
			location="src/passage.txt";
		
		src=aryfil.fill(src, location);
		brit=aryfil.fill(brit, "src/brit.txt");
		amer=aryfil.fill(amer, "src/amer.txt");
		
		System.out.println(module_select);
		int module = s.nextInt();
		
		if (module == 2) {
			System.out.println(language_select);
			choice = s.next().charAt(0);
		}
		
		if (module==3)  {
			System.out.println("Please enter an English word");
			String dummy = s.next();
			word_search = new Word_search (dummy, 2);
		}
		
		cntAmerican=0;
		cntBritish=0;
		
		if (module == 2) {
			outA = aryfil.init(outA);
			outB = aryfil.init(outB);
		}
		
		for (int count=0; count<src.size(); count++)
		{
			tokens = src.get(count).split(delimiters);
			for (int i=0; i<tokens.length; i++) {
				String word = tokens[i];
				for (int a=0; a<amer.length;a++)
				{
					if (word.equalsIgnoreCase(amer[a])) {
						cntAmerican ++;
						if (choice=='a')  {
						outA.add(amer[a]);
						outB.add(brit[a]); } }
				}
				
				for (int b=0; b<brit.length;b++)
				{
					if (word.equalsIgnoreCase(brit[b])) {
						cntBritish ++;
						if (choice=='b')  {
						outB.add(brit[b]);
						outA.add(amer[b]); } }
				}
				
			}
		}
		if (module == 2)
		{
			DuplicateFixer df = new DuplicateFixer();
			df.fix(outA);
			df.fix(outB);
		}
		
		if (module == 3)  {
			for (int a=0; a<amer.length; a++)
			{
				if (word_search.get_word().equalsIgnoreCase(amer[a]))
					word_search.identify(0, brit[a]);
				else if (word_search.get_word().equalsIgnoreCase(brit[a]))
					word_search.identify(1, amer[a]);
			}
		}
		
		if (module==1)  {
		
			
		int totalCnt = cntAmerican + cntBritish;
		
		System.out.println("American words: "+(double)cntAmerican/totalCnt*100+"%");
		System.out.println("British words: "+(double)cntBritish/totalCnt*100+"%");
		}
		
		result = "============================================\n";
		if (module == 2)
		{
			if (choice == 'a') {
				for (int i=0; i<outB.size(); i++) {
					result += "'"+outB.get(i)+"'" + " should be replaced by " + "'"+outA.get(i)+"'" + "\n"; } 
				result+="============================================\n";
				System.out.println("Misplaced words: "+"\n"+result); }
			
			if (choice == 'b') {
				for (int i=0; i<outA.size(); i++) {
					result += "'"+outA.get(i)+"'" + " should be replaced by " + "'"+outB.get(i)+"'" + "\n";  } 
				result+="============================================\n";
				System.out.println("Misplaced words: "+"\n"+result); }
		}
		if (module == 1)  {
			if (cntAmerican>cntBritish)
				System.out.println(result_amer);
			else if (cntBritish>cntAmerican)
				System.out.println(result_brit);
			else
				System.out.println(result_unkn);  }
		
		if (module == 3)  {
			System.out.println("This word is "+word_search.get_id()+" and corresponding word is "+word_search.get_corr());
		}
	
	}

}