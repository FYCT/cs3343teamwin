
import java.util.ArrayList;



public class main {
	
	static ArrayList<String> src;
	static String[] brit, amer, tokens;

	static final String delimiters = "[, .'!@#$%^&*()?]";
	
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
		
		cntAmerican=0;
		cntBritish=0;
		
		for (int count=0; count<src.size(); count++)
		{
			tokens = src.get(count).split(delimiters);
			for (int i=0; i<tokens.length; i++) {
				String word = tokens[i];
				for (int a=0; a<amer.length;a++)
				{
					if (word.equalsIgnoreCase(amer[a]))
						cntAmerican ++; 
				}
				for (int b=0; b<brit.length;b++)
				{
					if (word.equalsIgnoreCase(brit[b]))
						cntBritish ++;
				}
			}
		}
		System.out.println("American words: "+cntAmerican);
		System.out.println("British words: "+cntBritish);
		
		if (cntAmerican>cntBritish)
			System.out.println("This passage is written by american.");
		else if (cntBritish>cntAmerican)
			System.out.println("This passage is written by british.");
		else
			System.out.println("This passage is written by which countryman?");
	}

}