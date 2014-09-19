import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//ver 1.1
public class main {
	
	static ArrayList<String> src;
	static String[] brit, amer;
	static final int MAX_SIZE=50;
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
		
		//TODO input the source document into arraylist, use file IO
		//For ArrayList input: InputStream + BufferedReader + stringTokenizer
		////
		////
		////
		////
		////
		////
		////
		////
		////
		////
		
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
		 amer[cntb] = word;
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
		
		for (int i=0; i<src.size(); i++) {
			String word = src.get(i);
			for (int a=0; a<amer.length;a++)
			{
				if (word == amer[a])
					cntAmerican ++; 
			}
			for (int b=0; b<brit.length;b++)
			{
				if (word == brit[b])
					cntBritish ++;
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