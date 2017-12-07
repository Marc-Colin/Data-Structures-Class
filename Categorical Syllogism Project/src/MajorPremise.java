import java.util.ArrayList;

public class MajorPremise 
{
	private ArrayList<String> majorPremise = new ArrayList<String>();
	private ArrayList<String> termsDistributed = new ArrayList<String>();
	private String middleTerm;
	private String predicate;
	private String sign;
	private char value;
	
	public MajorPremise(ArrayList<String> majorPremise, String sign, String predicate, char value)
	{
		for(String phrase: majorPremise)
		{
			this.majorPremise.add(phrase);
		}
		this.sign = sign;
		this.value = value;
		this.predicate = predicate;
		middleTerm = findMiddleTerm();
		termsDistributed = checkDistribution();
	}
	
	public ArrayList<String> checkDistribution()
	{
		ArrayList<String> termsDistributed = new ArrayList<String>();
		if(value == 'A')
		{
			termsDistributed.add(majorPremise.get(1));
		}
		if(value == 'E')
		{
			termsDistributed.add(majorPremise.get(1));
			termsDistributed.add(majorPremise.get(3));
		}
		if(value == 'O')
		{
			termsDistributed.add(majorPremise.get(3));
		}
		else
			termsDistributed.add("none");
		
		return termsDistributed;
	}
	
	public String findMiddleTerm()
	{
		String middleTerm;
		
		if(majorPremise.get(1).equalsIgnoreCase(predicate))
			middleTerm = majorPremise.get(3);
		else
			middleTerm = majorPremise.get(1);
		return middleTerm;
	}
	
	public ArrayList<String> getTermsDistributed()
	{
		return termsDistributed; 
	}
	
	public String getMiddleTerm()
	{
		return middleTerm;
	}
	
	public String getPredicate()
	{
		return predicate;
	}
	
	public String getSign()
	{
		return sign;
	}
	
	public char getValue()
	{
		return value;
	}
	
	public String toString()
	{
		String statement = "";
		
		for(String phrase: majorPremise)
		{
			statement += phrase;
		}
		
		return statement;
	}
}
