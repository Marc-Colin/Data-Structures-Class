import java.util.*;

public class ClientCode
{
	public static void main (String[] args)
	{
		boolean check = true;

		// creating reference and temp variables
		Coin Penny = new Coin("penny", 0.01);
		Coin Nickle = new Coin("nickle", 0.05);
		Coin Dime = new Coin("dime", 0.10);
		Coin Quarter = new Coin("quarter", 0.25);
		Coin tempCoin = new Coin();

		Random RandomNumber = new Random();

		// creating a bag of coins
		Object[] tempBag;
		ResizableArrayBag BagOfCoins = new ResizableArrayBag<Coin>();

		// adding coins to the bag
		BagOfCoins.add(Penny);
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Dime);
		BagOfCoins.add(Dime);

		// checking how many coins are in the bag
		System.out.println("The bag has " + BagOfCoins.getCurrentSize() + " coins in it.");

		// testing the contains() method
		System.out.println("Checking if the bag contains a penny");
		check = BagOfCoins.contains(Penny);
		if(check == true)
		{
			System.out.println("The bag contains a " + Penny);
		}
		else
		{
			System.out.println("The bag does not contain a " + Penny);
		}
		System.out.println("Checking if the bag contains a quarter");
		check = BagOfCoins.contains(Quarter);
		if(check == true)
		{
			System.out.println("The bag contains a " + Quarter);
		}
		else
		{
			System.out.println("The bag does not contain a " + Quarter);
		}

		// checking toArray method
		tempBag = BagOfCoins.toArray();
		System.out.print("The bag contains a ");
		for(int i = 0; i < tempBag.length - 1; i++)
		{
			System.out.print(tempBag[i] + ", ");
		}
		System.out.println("and a " + tempBag[tempBag.length - 1] + ".");

		// checking the remove methods
		System.out.println("Removing a coin from the bag");
		tempCoin = (Coin)BagOfCoins.remove();
		System.out.println("Removed a " + tempCoin);
		System.out.println("The bag has " + BagOfCoins.getCurrentSize() + " coins in it.");
		System.out.println("Putting the coin back in.");
		BagOfCoins.add(tempCoin);
		System.out.println("The bag has " + BagOfCoins.getCurrentSize() + " coins in it.");
		System.out.println("Removing a penny from the bag");
		check = BagOfCoins.remove(Penny);
		if(check == true)
		{
			System.out.println("The penny was removed.");
		}
		else
		{
			System.out.println("The penny was not removed.");
		}
		tempBag = BagOfCoins.toArray();
		System.out.print("The bag contains a ");
		for(int i = 0; i < tempBag.length - 1; i++)
		{
			System.out.print(tempBag[i] + ", ");
		}
		System.out.println("and a " + tempBag[tempBag.length - 1] + ".");
		System.out.println("Putting the coin back in.");
		tempCoin = Penny;
		BagOfCoins.add(tempCoin);
		tempBag = BagOfCoins.toArray();
		System.out.print("The bag contains a ");
		for(int i = 0; i < tempBag.length - 1; i++)
		{
			System.out.print(tempBag[i] + ", ");
		}
		System.out.println("and a " + tempBag[tempBag.length - 1] + ".");

		System.out.println("What is the probability of removing a nickle, then a penny from this bag?");
		int numerator = (BagOfCoins.getFrequencyOf(Nickle) * BagOfCoins.getFrequencyOf(Penny));
		int denominator = (BagOfCoins.getCurrentSize());
		BagOfCoins.remove(Nickle);
		denominator *= (BagOfCoins.getCurrentSize());
		System.out.println(numerator + "/" + denominator);

		System.out.print("New bag. Contains 3 pennys, 2 dimes, and 3 quarters.\n" +
						"What is the probability of removing three pennys in a row? \n");
		BagOfCoins.clear();
		BagOfCoins.add(Penny);
		BagOfCoins.add(Penny);
		BagOfCoins.add(Penny);
		BagOfCoins.add(Dime);
		BagOfCoins.add(Dime);
		BagOfCoins.add(Quarter);
		BagOfCoins.add(Quarter);
		BagOfCoins.add(Quarter);
		numerator = (BagOfCoins.getFrequencyOf(Penny));
		denominator = (BagOfCoins.getCurrentSize());
		BagOfCoins.remove(Penny);
		numerator *= (BagOfCoins.getFrequencyOf(Penny));
		denominator *= (BagOfCoins.getCurrentSize());
		BagOfCoins.remove(Penny);
		numerator *= (BagOfCoins.getFrequencyOf(Penny));
		denominator *= (BagOfCoins.getCurrentSize());
		System.out.println(numerator + "/" + denominator);

		System.out.print("New bag. Contains 4 quarters, 10 dimes, 20 nickles, and 100 pennys. \n" +
						"What is the probability of removing a quarter, dime, nickle, and penny in that order? \n");
		BagOfCoins.clear();
		for(int i = 1; i <= 100; i++)
		{
			BagOfCoins.add(Penny);
		}
		for(int i = 1; i <= 20; i++)
		{
			BagOfCoins.add(Nickle);
		}
		for(int i = 1; i <= 10; i++)
		{
			BagOfCoins.add(Dime);
		}
		for(int i = 1; i <= 4; i++)
		{
			BagOfCoins.add(Quarter);
		}
		numerator = (BagOfCoins.getFrequencyOf(Quarter) * BagOfCoins.getFrequencyOf(Dime) * BagOfCoins.getFrequencyOf(Nickle) * BagOfCoins.getFrequencyOf(Penny));
		denominator = (BagOfCoins.getCurrentSize());
		BagOfCoins.remove(Quarter);
		denominator *= (BagOfCoins.getCurrentSize());
		BagOfCoins.remove(Dime);
		denominator *= (BagOfCoins.getCurrentSize());
		BagOfCoins.remove(Nickle);
		denominator *= (BagOfCoins.getCurrentSize());
		BagOfCoins.remove(Penny);
		System.out.println(numerator + "/" + denominator);

		System.out.println("New bag. Contains 1 penny, 2 nickles, 3 dimes, 4 quarters. What are the chances of removing a quarter, putting it back, a dime, putting it back, then 2 quarters in a row without putting them back?");
		BagOfCoins.clear();
		BagOfCoins.add(Penny);
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Dime);
		BagOfCoins.add(Dime);
		BagOfCoins.add(Dime);
		BagOfCoins.add(Quarter);
		BagOfCoins.add(Quarter);
		BagOfCoins.add(Quarter);
		BagOfCoins.add(Quarter);
		numerator = (BagOfCoins.getFrequencyOf(Quarter) * BagOfCoins.getFrequencyOf(Dime) * BagOfCoins.getFrequencyOf(Quarter));
		BagOfCoins.remove(Quarter);
		BagOfCoins.add(Quarter);
		BagOfCoins.remove(Dime);
		BagOfCoins.add(Dime);
		denominator = (BagOfCoins.getCurrentSize() * BagOfCoins.getCurrentSize() * BagOfCoins.getCurrentSize());
		BagOfCoins.remove(Quarter);
		denominator *= BagOfCoins.getCurrentSize();
		numerator *= BagOfCoins.getFrequencyOf(Quarter);
		BagOfCoins.remove(Quarter);
		System.out.println(numerator + "/" + denominator);

		System.out.println("New bag. Contains 3 nickles, 2 dimes, and 1 quarter. What are the chances of removing a dime, putting it back, and removing another dime?");
		BagOfCoins.clear();
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Nickle);
		BagOfCoins.add(Dime);
		BagOfCoins.add(Dime);
		BagOfCoins.add(Quarter);
		numerator = (BagOfCoins.getFrequencyOf(Dime) * BagOfCoins.getFrequencyOf(Dime));
		denominator = (BagOfCoins.getCurrentSize() * BagOfCoins.getCurrentSize());
		System.out.println(numerator + "/" + denominator);
	}
}

/*
The bag has 8 coins in it.
Checking if the bag contains a penny
The bag contains a penny
Checking if the bag contains a quarter
The bag does not contain a quarter
The bag contains a penny, nickle, nickle, nickle, nickle, nickle, dime, and a dime.
Removing a coin from the bag
Removed a dime
The bag has 7 coins in it.
Putting the coin back in.
The bag has 8 coins in it.
Removing a penny from the bag
The penny was removed.
The bag contains a dime, nickle, nickle, nickle, nickle, nickle, and a dime.
Putting the coin back in.
The bag contains a dime, nickle, nickle, nickle, nickle, nickle, dime, and a penny.
What is the probability of removing a nickle, then a penny from this bag?
5/56
New bag. Contains 3 pennys, 2 dimes, and 3 quarters.
What is the probability of removing three pennys in a row?
6/336
New bag. Contains 4 quarters, 10 dimes, 20 nickles, and 100 pennys.
What is the probability of removing a quarter, dime, nickle, and penny in that order?
80000/308178024
New bag. Contains 1 penny, 2 nickles, 3 dimes, 4 quarters. What are the chances of removing a quarter, putting it back, a dime, putting it back, then 2 quarters in a row without putting them back?
144/9000
New bag. Contains 3 nickles, 2 dimes, and 1 quarter. What are the chances of removing a dime, putting it back, and removing another dime?
4/36
Press any key to continue . . .
*/