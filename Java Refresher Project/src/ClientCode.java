public class ClientCode
{
	public static void main(String[] args)
	{
		GenericCoin coinOne = new GenericCoin();
		GenericCoin coinTwo = new GenericCoin();
		int numFlips = 50;
		int countFlips = 1;
		int countOneHeads = 0;
		int countTwoHeads = 0;
		double gameValue = 0.0;
		double endValue = 1.0;
		boolean result = false;
		String flipResult;
		String HEADS = "HEADS";
		String TAILS = "TAILS";

		while (countFlips <= numFlips)
		{
			flipResult = coinOne.FlipCoin();
			if (flipResult == HEADS)
			{
				countOneHeads++;
			}
			flipResult = coinTwo.FlipCoin();
			if (flipResult == HEADS)
			{
				countTwoHeads++;
			}
			countFlips++;
		}
		System.out.println("The first coin landed on heads " + countOneHeads + " times.");
		System.out.println("The second coin landed on heads " + countTwoHeads + " times.");
		if (countOneHeads > countTwoHeads)
		{
			System.out.println("The first coin landed on heads more.");
		}
		else if (countOneHeads == countTwoHeads)
		{
			System.out.println("Both coins landed on heads the same amount of times");
		}
		else if (countOneHeads < countTwoHeads)
		{
			System.out.println("The second coin landed on heads more.");
		}
		Coin Dime = new Coin();
		Dime.setValue(.10);
		System.out.println("The value of this coin is " + Dime.getValue());
		Dime.setName("dime");
		System.out.println("This coin is a " + Dime.getName() + ".");
		Coin Nickle = new Coin();
		Nickle.setValue(.05);
		System.out.println("The value of this coin is " + Nickle.getValue());
		Nickle.setName("nickle");
		System.out.println("This coin is a " + Nickle.getName() + ".");
		Coin Quarter = new Coin();
		Quarter.setValue(.25);
		System.out.println("The value of this coin is " + Quarter.getValue());
		Quarter.setName("quarter");
		System.out.println("This coin is a " + Quarter.getName() + ".");

		while (result == false)
		{
			flipResult = Nickle.FlipCoin();
			if (flipResult == HEADS)
			{
				gameValue += Nickle.getValue();
				if (gameValue >= endValue)
				{
					result = true;
				}
			}
			flipResult = Dime.FlipCoin();
			if (flipResult == HEADS)
			{
				gameValue += Dime.getValue();
				if (gameValue >= endValue)
				{
					result = true;
				}
			}
			flipResult = Quarter.FlipCoin();
			if (flipResult == HEADS)
			{
				gameValue += Quarter.getValue();
				if (gameValue >= endValue)
				{
					result = true;
				}
			}
		}
		System.out.printf("The game value is:%1.2f\n", gameValue);
	}
}

/*
The first coin landed on heads 24 times.
The second coin landed on heads 27 times.
The second coin landed on heads more.
The value of this coin is 0.1
This coin is a dime.
The value of this coin is 0.05
This coin is a nickle.
The value of this coin is 0.25
This coin is a quarter.
The game value is: 1.05
Press any key to continue . . .
*/