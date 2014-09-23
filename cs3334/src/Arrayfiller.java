import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Arrayfiller {
	
	final int MAX_SIZE=500;
	
	public Arrayfiller () {}
	
	public ArrayList<String> init (ArrayList<String> source) {
		source = new ArrayList<String>();
		return source;
	}
	
	public String[] init (String[] source) {
		source = new String[MAX_SIZE];
		return source;
	}
	
	public ArrayList<String> fill (ArrayList<String> src, String path) {
		File source = new File(path);

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
		
		return src;
	}
	
	public String[] fill (String[] src, String path) {
		
	
		File file = new File(path);
	
		try {
			Scanner sc = new Scanner(file);
			int cnt = 0;
	
		while (sc.hasNextLine()) {
				 String word = sc.nextLine();
				 src[cnt] = word;
		
				 cnt++;
			 
			 }
			 sc.close();
		 } 
		 catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
		
		return src;
	}
	
}
