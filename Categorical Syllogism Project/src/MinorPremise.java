import java.util.ArrayList;

public class MinorPremise
{
	private ArrayList<String> minorPremise = new ArrayList<String>();
	private ArrayList<String> termsDistributed = new ArrayList<String>();
	private String middleTerm;
	private String subject;
	private String sign;
	private char value;
	
	public MinorPremise(ArrayList<String> minorPremise, String sign, String subject, char value)
	{
		for(String phrase: minorPremise)
		{
			this.minorPremise.add(phrase);
		}
		this.sign = sign;
		this.value = value;
		this.subject = subject;
		middleTerm = findMiddleTerm();
		termsDistributed = checkDistribution();
	}
	public ArrayList<String> checkDistribution()
	{
		ArrayList<String> termsDistributed = new ArrayList<String>();
		if(value == 'A')
		{
			termsDistributed.add(minorPremise.get(1));
		}
		if(value == 'E')
		{
			termsDistributed.add(minorPremise.get(1));
			termsDistributed.add(minorPremise.get(3));
		}
		if(value == 'O')
		{
			termsDistributed.add(minorPremise.get(3));
		}
		else
			termsDistributed.add("none");
		
		return termsDistributed;
	}
	
	public String findMiddleTerm()
	{
		String middleTerm;
		
		if(minorPremise.get(1).equalsIgnoreCase(subject))
			middleTerm = minorPremise.get(3);
		else
			middleTerm = minorPremise.get(1);
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
	
	public String getSubject()
	{
		return subject;
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
		
		for(String phrase: minorPremise)
		{
			statement += phrase;
		}
		
		return statement;
	}
}
