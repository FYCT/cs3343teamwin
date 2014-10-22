package project;

public class Word_search {
	
	String word;
	//amer=0; brit=1; unidentified=2;
	int id;
	//corresponding_word;
	String corr;

	public Word_search(String search, int identity)  {
		this.word = search;
		this.id = identity;
		this.corr="";
	}
	
	public String get_word ()  {
		return this.word;
	}
	
	public void identify (int new_identity, String corresponding)  {
		this.id = new_identity;
		this.corr = corresponding;
	}
	
	public String get_id ()  {
		if (this.id==0)
			return "an american word";
		else if (this.id==1)
			return "a british word";
		return "unidentified";
	}
	
	public String get_corr ()  {
		if (this.id==2)
				return "unidentified";
		return this.corr;
	}
}
