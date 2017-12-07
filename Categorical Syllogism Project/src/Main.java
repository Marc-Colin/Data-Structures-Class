import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	static Scanner input = new Scanner(System.in);
	static ArrayList<String> statementList = new ArrayList<String>();
	static Argument argument;
	static Conclusion conclusion;
	static MajorPremise majorPremise;
	static MinorPremise minorPremise;
	static String[] splitStatement;
	static String middleTerm;
	static String statementSign = "";
	static char statementValue = 'X';
	static boolean isMajor = false;
	static boolean majorMade = false;
	static boolean valid = true;
	
	public static void main(String[] args)
	{
		
		//Input and declaration of conclusion 
		System.out.print("Please enter your conclusion statement: ");
		splitStatement = inputStatement();//calls method that takes in the users input and returns the statement split by spaces
		statementValue = checkValue();//calls method that finds out the value of the user input
		statementSign = checkSign();//calls method that finds out if the statement is negative or positive
		statementList = makeList();//calls method that creates an ArrayList of the user statement separated in important terms
		conclusion = new Conclusion(statementList, statementSign, statementValue);//creates an object of type Conclusion
		System.out.println("Subject: " + conclusion.getSubject());
		System.out.println("Predicate: " + conclusion.getPredicate());
		
		//Clear input variables
		statementList.clear();
		splitStatement = null;
		statementSign = "";
		statementValue = 'X';
		
		//Input and declaration of first premise
		System.out.print("Please enter your first premise: ");
		splitStatement = inputStatement();//calls method that takes in the users input and returns the statement split by spaces
		statementValue = checkValue();//calls method that finds out the value of the user input
		statementSign = checkSign();//calls method that finds out if the statement is negative or positive
		statementList = makeList();//calls method that creates an ArrayList of the user statement separated in important terms
		isMajor = whichPremise();//calls method that check if statement is a valid premise and returns which premise is made
		if(isMajor)//creates an object of type MajorPremise
		{
			majorPremise = new MajorPremise(statementList, statementSign, conclusion.getPredicate(), statementValue);
			majorMade = true;//stores that the major premise has been made
			middleTerm = majorPremise.getMiddleTerm();//stores the middle term from the premise to check on next premise entry
			System.out.println("Predicate: " + majorPremise.getPredicate());
			System.out.println("Middle Term: " + majorPremise.getMiddleTerm());
		}
		else//creates an object of type MinorPremise
		{
			minorPremise = new MinorPremise(statementList, statementSign, conclusion.getSubject(), statementValue);
			middleTerm = minorPremise.getMiddleTerm();//stores the middle term from the premise to check on next premise entry
			System.out.println("Subject: " + minorPremise.getSubject());
			System.out.println("Middle Term: " + minorPremise.getMiddleTerm());
		}
		
		//Clear all input variables
		statementList.clear();
		splitStatement = null;
		statementSign = "";
		statementValue = 'X';
		
		//Input and declaration of second premise
		System.out.print("Please enter your second premise: ");
		splitStatement = inputStatement();//calls method that takes in the users input and returns the statement split by spaces
		statementValue = checkValue();//calls method that finds out the value of the user input
		statementSign = checkSign();//calls method that finds out if the statement is negative or positive
		statementList = makeList();//calls method that creates an ArrayList of the user statement separated in important terms
		if(majorMade)//if major premise is made then creates an object of type MinorPremise
		{
			testMinor();//checks if the minor premise entered is valid
			minorPremise = new MinorPremise(statementList, statementSign, conclusion.getSubject(), statementValue);
			System.out.println("Subject: " + minorPremise.getSubject());
			System.out.println("Middle Term: " + minorPremise.getMiddleTerm());
		}
		else//if major premise was not made creates a object of type MajorPremise
		{
			testMajor();//checks if the major premise entered is valid
			majorPremise = new MajorPremise(statementList, statementSign, conclusion.getPredicate(), statementValue);
			System.out.println("Predicate: " + majorPremise.getPredicate());
			System.out.println("Middle Term: " + majorPremise.getMiddleTerm());
		}
		
		System.out.println("");
		System.out.println("Your argument.");
		System.out.println("Major premise: " + majorPremise);//calls toString of MajorPremise
		System.out.println("Minor premise: " + minorPremise);//calls toString of MinorPremise
		System.out.println("   Conclusion: " + conclusion);//calls toString of Conclusion
		
		argument = new Argument(majorPremise, minorPremise, conclusion);//create an object type Argument that contains the major and minor premise and the conclusion
			if(!argument.rule1())//tests if the argument passes rule 1
				System.out.println("This argument is invalid because the middle term was not distributed at least once in either premise.");
			else if(!argument.rule2())//tests if the argument passes rule 2
				System.out.println("This argument is invalid because a term was distributed in the conclusion that was not distributed in either premise.");
			else if(!argument.rule3())//tests if the argument passes rule 3
				System.out.println("This argument is invalid because both premises were negative statements.");
			else if(!argument.rule4())//tests if the argument passes rule 4
				System.out.println("This argument is invalid because it had a negative conclusion with no negative premise, or it had a negative premise with a positive conclusion.");
			else//if it passes all the rules it is a valid argument
				System.out.println("This is a valid argument!");
		
		
	}
//************************************************************************************************************************************
	public static String[] inputStatement()
	{
		String statement = null;
		
		while(statementValue == 'X')//loops until statement entered has a valid value
		{
			statement = input.nextLine();
			splitStatement = statement.split(" ");
			statementValue = checkValue();
			if(statementValue == 'X')
			{
				System.out.print("Invalid statement. Please try again: ");
			}
		}	
		
		return splitStatement;		
	}
//************************************************************************************************************************************
	public static char checkValue()//checks the key words of the statement to determine the value
	{
		
		if(splitStatement[0].equalsIgnoreCase("all"))
		{
			statementValue = 'A';
		}
		if(splitStatement[0].equalsIgnoreCase("no"))
		{
			statementValue = 'E';
		}
		if(splitStatement[0].equalsIgnoreCase("some"))
		{
			for(int i = 1; i < splitStatement.length; i++)
			{
				if(splitStatement[i].equalsIgnoreCase("are") && splitStatement[i + 1].equalsIgnoreCase("not"))
				{
					statementValue = 'O';
				}
				else if(splitStatement[i].equalsIgnoreCase("are") && !splitStatement[i + 1].equalsIgnoreCase("not"))
				{
					statementValue = 'I';
				}
			}
		}
		
		return statementValue;
	}
//************************************************************************************************************************************
	public static String checkSign()//uses the value of the statement to determine the sign
	{
		
		if(statementValue == 'A' || statementValue == 'I')
		{
			statementSign = "positive";
		}
		else if(statementValue == 'E' || statementValue == 'O')
		{
			statementSign = "negative";
		}
		
		return statementSign;
	}
//************************************************************************************************************************************
	public static ArrayList<String> makeList()//searches for key words and separates the statement into 4 definite parts
	{
		String phrase = "";
		int startIndex = 0;
		
		statementList.add(splitStatement[0] + " ");
		//System.out.println("List index 1: " + statementList.get(0)); //output test
		startIndex++;
		for(int i = startIndex; !splitStatement[i].equals("are"); i++)
		{
			phrase += (splitStatement[i] + " ");
			startIndex = i + 1;
		}
		statementList.add(phrase);
		//System.out.println("List index 2: " + statementList.get(1)); //output test
		if(statementValue == 'O')
		{
			statementList.add(splitStatement[startIndex] + " " + splitStatement[startIndex + 1] + " ");
			startIndex += 2;
		}
		else
		{
			statementList.add(splitStatement[startIndex] + " ");
			startIndex++;
		}
		//System.out.println("List index 3: " + statementList.get(2)); //output test
		phrase = "";
		for(int i = startIndex; i < splitStatement.length; i++)
		{
			phrase += (splitStatement[i] + " ");
		}
		statementList.add(phrase);
		//System.out.println("List index 4: " + statementList.get(3)); //output test
		
		return statementList;
	}
//***********************************************************************************************************************************
	public static boolean checkMajor()//checks if the premise contains the predicate term to determine if it is the major premise
	{
		boolean major = false;
		
		if(statementList.get(1).equalsIgnoreCase(conclusion.getPredicate()))
			major = true;
		if(statementList.get(3).equalsIgnoreCase(conclusion.getPredicate()))
			major = true;
		
		return major;
	}
//***********************************************************************************************************************************
	public static boolean checkMinor()//checks if the premise contains the subject term to determine if its the minor premise
	{
		boolean minor = false;

		if(statementList.get(1).equalsIgnoreCase(conclusion.getSubject()))
			minor = true;
		if(statementList.get(3).equalsIgnoreCase(conclusion.getSubject()))
			minor = true;
		
		return minor;
	}
//***********************************************************************************************************************************
	public static boolean whichPremise()//checks if the premise is a valid statement and returns which premise it is
	{
		boolean isPremise = false;
		boolean isMajor = false;
		
		while(!isPremise)
		{
			if(checkMajor() && !checkMinor())
			{
				isPremise = true;
				isMajor = true;
			}
			else if(!checkMajor() && checkMinor())
			{
				isPremise = true;
			}
			else
			{
				
				System.out.print("Missing either the subject or the predicate from the conclusion. Try again: ");
				statementList.clear();
				splitStatement = null;
				statementSign = "";
				statementValue = 'X';
				splitStatement = inputStatement();
				statementValue = checkValue();
				statementSign = checkSign();
				statementList = makeList();
			}
		}
		
		return isMajor;
	}
//********************************************************************************************************************************************************************************
	public static boolean testMinor()//tests if the second premise has the middle term and the subject term if the major premise was made
	{
		boolean isPremise = false;
		
		while(!isPremise)
		{
			if(statementList.contains(middleTerm) && statementList.contains(conclusion.getSubject()))
				isPremise = true;
			else
			{
				System.out.print("Missing either the subject from the conclusion, or the middle term from the previous premise. Try again: ");
				statementList.clear();
				splitStatement = null;
				statementSign = "";
				statementValue = 'X';
				splitStatement = inputStatement();
				statementValue = checkValue();
				statementSign = checkSign();
				statementList = makeList();
			}
		}
		
		return isPremise;
	}
//********************************************************************************************************************************************************************************
	public static boolean testMajor()//tests if the second premise has the middle term and the predicate term if the minor premise was made
	{
		boolean isPremise = false;
		
		while(!isPremise)
		{
			if(statementList.contains(middleTerm) && statementList.contains(conclusion.getPredicate()))
				isPremise = true;
			else
			{
				System.out.print("Missing either the predicate from the conclusion, or the middle term from the previous premise. Try again: ");
				statementList.clear();
				splitStatement = null;
				statementSign = "";
				statementValue = 'X';
				splitStatement = inputStatement();
				statementValue = checkValue();
				statementSign = checkSign();
				statementList = makeList();
			}
		}
		
		return isPremise;
	}
//********************************************************************************************************************************************************************************
	
}