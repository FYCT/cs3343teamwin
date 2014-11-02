package project;

import java.util.ArrayList;

public class DuplicateFixer {
	public void fix (ArrayList<String> problematic)
	{
		for (int i=0; i<problematic.size(); i++)
		{
			String instance = problematic.get(i);
			for (int j=i+1; j<problematic.size(); j++)
			{
				if (instance.equalsIgnoreCase(problematic.get(j)))
					{
					String checked = problematic.get(j);
					problematic.remove(j);
					}
						
			}
		}
	}
}
