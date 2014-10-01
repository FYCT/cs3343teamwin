
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
		
		Arrayfiller aryfil = new Arrayfiller();
		
		src=aryfil.init(src);
		brit=aryfil.init(brit);
		amer=aryfil.init(amer);
		tokens=aryfil.init(tokens);
		
		
		src=aryfil.fill(src, "src/passage.txt");
		brit=aryfil.fill(brit, "src/brit.txt");
		amer=aryfil.fill(amer, "src/amer.txt");
		
		System.out.println("Please select module 1 or module 2");
		int module = s.nextInt();
		
		if (module == 2) {
			System.out.println("Please select default language(a or b)");
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
						if (module  == 2) {
							outA.add(word);
							outA.add(" "); }
						}
				}
				for (int b=0; b<brit.length;b++)
				{
					if (word.equalsIgnoreCase(brit[b])) {
						cntBritish ++;
						if (module  == 2) {
							outB.add(word);
							outB.add(" "); }
						}
				}
			}
		}
		System.out.println("American words: "+cntAmerican);
		System.out.println("British words: "+cntBritish);
		
		result = "";
		if (module == 2)
		{
			if (choice == 'a') {
				for (int i=0; i<outB.size(); i++) {
					result += outB.get(i); } 
				System.out.println("Misplaced words: "+result); }
			
			if (choice == 'b') {
				for (int i=0; i<outA.size(); i++) {
					result += outA.get(i); } 
				System.out.println("Misplaced words: "+result); }
		}
		if (cntAmerican>cntBritish)
			System.out.println("This passage is written by american.");
		else if (cntBritish>cntAmerican)
			System.out.println("This passage is written by british.");
		else
			System.out.println("This passage is written by which countryman?");
	}

}