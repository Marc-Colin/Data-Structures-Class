import java.util.ArrayList;

public class Conclusion 
{
	private ArrayList<String> conclusion = new ArrayList<String>();
	private ArrayList<String> termsDistributed = new ArrayList<String>();
	private String predicate;
	private String subject;
	private String sign;
	private char value;
	
	public Conclusion(ArrayList<String> conclusion, String sign, char value)
	{
		for(String phrase: conclusion)
		{
			this.conclusion.add(phrase);
		}
		this.sign = sign;
		this.value = value;
		predicate = conclusion.get(3);
		subject = conclusion.get(1);
		termsDistributed = checkDistribution();
	}
	
	public ArrayList<String> checkDistribution()
	{
		ArrayList<String> termsDistributed = new ArrayList<String>();
		if(value == 'A')
		{
			termsDistributed.add(subject);
		}
		if(value == 'E')
		{
			termsDistributed.add(subject);
			termsDistributed.add(predicate);
		}
		if(value == 'O')
		{
			termsDistributed.add(predicate);
		}
		else
			termsDistributed.add("none");
		
		return termsDistributed;
	}
	
	public ArrayList<String> getTermsDistributed()
	{
		return termsDistributed; 
	}
	
	public String getSubject()
	{
		return subject;
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
		
		for(String phrase: conclusion)
		{
			statement += phrase;
		}
		
		return statement;
	}
}
