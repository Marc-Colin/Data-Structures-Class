
public class Argument 
{
	MajorPremise majorPremise;
	MinorPremise minorPremise;
	Conclusion conclusion;
	String middleTerm;
	
	public Argument(MajorPremise majorPremise, MinorPremise minorPremise, Conclusion conclusion)
	{
		this.majorPremise = majorPremise;
		this.minorPremise = minorPremise;
		this.conclusion = conclusion;
		middleTerm = majorPremise.getMiddleTerm();
	}
	
	public boolean rule1()
	{
		boolean pass = false;
		if(majorPremise.getTermsDistributed().contains(middleTerm) || minorPremise.getTermsDistributed().contains(middleTerm))
			pass = true;
		return pass;
	}
	
	public boolean rule2()
	{
		boolean pass = false;
		for(String term: conclusion.getTermsDistributed())
		{
			if(majorPremise.getTermsDistributed().contains(term) || minorPremise.getTermsDistributed().contains(term))
				pass = true;
			else 
				pass = false;
		}
		return pass;
	}
	
	public boolean rule3()
	{
		boolean pass = true;
		if(majorPremise.getSign().equals("negative") && minorPremise.getSign().equals("negative"))	
			pass = false;
		return pass;
	}
	
	public boolean rule4()
	{
		boolean pass = true;
		if(conclusion.getSign().equals("negative") && (majorPremise.getSign().equals("positive") && minorPremise.getSign().equals("positive")))
			pass = false;
		if(conclusion.getSign().equals("positive") && (majorPremise.getSign().equals("negative") || minorPremise.getSign().equals("negative")))
			pass = false;
		return pass;
	}
}
