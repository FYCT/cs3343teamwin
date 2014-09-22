import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class main {
	
	static ArrayList<String> src;
	static String[] brit, amer, tokens;
	static final int MAX_SIZE=500;
	static final String delimiters = "[, .']";
	static Scanner s;
	static int cntAmerican, cntBritish;
	
	public static ArrayList<String> init (ArrayList<String> source) {
		source = new ArrayList<String>();
		return source;
	}
	
	public static String[] init (String[] source) {
		source = new String[MAX_SIZE];
		return source;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// initialize one arraylist and two string arrays, done.
		src=init(src);
		brit=init(brit);
		amer=init(amer);
		tokens=init(tokens);
		
		//TODO input the source document into arraylist, use file IO
		//For ArrayList input: InputStream + BufferedReader + stringTokenizer
		////
		File source = new File("src/passage.txt");

		try {
			Scanner scs = new Scanner(source);
	
			while (scs.hasNextLine()) {
				 String word = scs.nextLine(); 
				 src.add(word);			 
			}
			scs.close();
		 } 
		 catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
		////
		////
		for (int i=0; i<src.size(); i++) {
			String word2 = src.get(i);
			System.out.println(word2);
		}
		//TODO input word lists into two arrays
		//For arrays input: Scanner
		File american = new File("src/amer.txt");

		try {

		Scanner sc = new Scanner(american);
		int cnta = 0;

		while (sc.hasNextLine()) {
			 String word = sc.nextLine();
			 amer[cnta] = word;

			 cnta++;
			 
		 }
		 sc.close();
		 } 
		 catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
		
		File british = new File("src/brit.txt");

		try {

		Scanner scb = new Scanner(british);
		int cntb = 0;

		while (scb.hasNextLine()) {
			 String word = scb.nextLine();
			 brit[cntb] = word;

			 cntb++;
		 }
		 scb.close();
		 } 
		 catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }

		
		//assumption: all data structures have been filled
		
		// main logic
		cntAmerican=0;
		cntBritish=0;
		
		for (int count=0; count<src.size(); count++)
		{
			tokens = src.get(count).split(delimiters);
			for (int i=0; i<tokens.length; i++) {
				String word = tokens[i];
				for (int a=0; a<amer.length;a++)
				{
					if (word.equalsIgnoreCase(amer[a]) )
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