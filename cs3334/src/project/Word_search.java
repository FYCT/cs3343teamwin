package project;

// TODO: Auto-generated Javadoc
/**
 * The Class Word_search.
 */
public class Word_search {
	
	/** The word. */
	String word;
	//amer=0; brit=1; unidentified=2;
	/** The id. */
	int id;
	//corresponding_word;
	/** The corr. */
	String corr;

	/**
	 * Instantiates a new word_search.
	 *
	 * @param search the search
	 * @param identity the identity
	 */
	public Word_search(String search, int identity)  {
		this.word = search;
		this.id = identity;
		this.corr="";
	}
	
	/**
	 * Gets the _word.
	 *
	 * @return the _word
	 */
	public String get_word ()  {
		return this.word;
	}
	
	/**
	 * Identify.
	 *
	 * @param new_identity the new_identity
	 * @param corresponding the corresponding
	 */
	public void identify (int new_identity, String corresponding)  {
		this.id = new_identity;
		this.corr = corresponding;
	}
	
	/**
	 * Gets the _id.
	 *
	 * @return the _id
	 */
	public String get_id ()  {
		if (this.id==0)
			return "an american word";
		else if (this.id==1)
			return "a british word";
		return "unidentified";
	}
	
	/**
	 * Gets the _corr.
	 *
	 * @return the _corr
	 */
	public String get_corr ()  {
		if (this.id==2)
				return "unidentified";
		return this.corr;
	}
}
