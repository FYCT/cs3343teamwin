package project;

import java.util.ArrayList;
import java.util.Scanner;



public class main {
	
	static ArrayList<String> src;
	static String[] brit, amer, tokens;
	
	//for ver 2
	static ArrayList<String> outA, outB;

	static final String delimiters = "[, .'!@#$%^&*()?]";
	
	//for ver 2
	static Scanner s = new Scanner (System.in);
	static String result="";
	static char choice;
	
	static int cntAmerican, cntBritish;
	

	public static void main(String[] args) {
		
		String module_select = "============================================\n"
				+              "       	Please select a module              \n"
				+              "          Type in 1 or 2                    \n"
				+  			   "1. Check the smell of the input passage     \n"
				+			   "2. Get a list of misused words, for learners\n"
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
		
		
		src=aryfil.fill(src, "src/passage.txt");
		brit=aryfil.fill(brit, "src/brit.txt");
		amer=aryfil.fill(amer, "src/amer.txt");
		
		System.out.println(module_select);
		int module = s.nextInt();
		
		if (module == 2) {
			System.out.println(language_select);
			choice = s.next().charAt(0);
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
		if (module==1)  {
		System.out.println("American words: "+cntAmerican);
		System.out.println("British words: "+cntBritish);  }
		
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
	}

}