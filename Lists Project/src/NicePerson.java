import java.util.*;

public class NicePerson implements NicePersonInterface
{
	private ArrayList<String> PresentList;
	private Name PersonsName;
	private String output;

	public NicePerson(Name name)
	{
		PersonsName = name;
		PresentList = new ArrayList<String>();
	}

	public void addPresent(String gift)
	{
		PresentList.add(gift);
	}

	public String toString()
	{
		int counter = 0;
		output = PersonsName + ": \n";
		while (counter < PresentList.size() - 1)
		{
			output += "	" + PresentList.get(counter) + "\n";
			counter++;
		}
		output += "	" + PresentList.get(counter);
		return output;
	}
}