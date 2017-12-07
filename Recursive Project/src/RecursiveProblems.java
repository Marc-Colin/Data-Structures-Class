import java.util.*;

public class RecursiveProblems
{
	public static void main(String[] args)
	{
		int sum = 0;
		System.out.println("Problem 1: " + Problem1(8,12));
		System.out.println("Problem 2: " + Problem2(Problem2(Problem2(Problem2(Problem2(10))))));
		System.out.println("Problem 3: " + Problem3(30, 12));
		System.out.println("Problem 4: " + Problem4(32));
		System.out.println("Problem 5: " + Problem5(5));
		System.out.println("Problem 6: " + Problem6(35, 8));
		for (int i = 1; i <= 10; i++)
		{
			sum += Problem7(i);
		}
		System.out.println("Problem 7: " + sum);
		System.out.println("Problem 8: " + Problem8(Problem8(Problem8(Problem8(18)))));

	}

	public static int Problem1(int x, int y)
	{
		if (x < y)
		{
			return Problem1(x + 1, y - 2) + 3;
		}
		else if (x > y)
		{
			return Problem1(y - 1, x) - 1;
		}
		return (int)(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public static int Problem2(int x)
	{
		if (x > 7)
		{
			return Problem2(x - 5) - 3;
		}
		if (x > 3 && x <= 7)
		{
			return Problem2(x + 2) + 2;
		}
		return x + 5;
	}

	public static int Problem3(int x, int y)
	{
		if (x > y)
		{
			return Math.max(Problem3(x - 4, y + 3), Problem3(y, x));
		}
		return x * y;
	}

	public static int Problem4(int x)
	{
		if (x % 2 == 0)
		{
			return Problem4((x / 2) - 1) + 3;
		}
		else if (x > 0)
		{
			return (2 * Problem4(x-3) - 5);
		}
		return (int)(Math.pow(x, 2) - 3);
	}

	public static int Problem5(int x)
	{
		if (x == 1)
		{
			return 8;
		}
		else
		{
			return (2 * Problem5(x - 1) - 4);
		}
	}

	public static int Problem6(int x, int y)
	{
		if (x >= y)
		{
			return (Problem6(x - y, y + 2) + y);
		}
		else
		{
			return (int)(Math.pow(x, 2) - y);
		}
	}

	public static int Problem7(int x)
	{
		if (x == 1)
		{
			return 1;
		}
		else
		{
			return (Problem7(x - 1) + 5);
		}
	}

	public static int Problem8(int x)
	{
		if (x >= 10)
		{
			return (Problem8(x - 5) - 2);
		}
		else if (x >= 7 && x < 10)
		{
			return (Problem8(x + 4) +6);
		}
		return (x - 4);
	}
}

/*
Problem 1: 136
Problem 2: 7
Problem 3: 396
Problem 4: 10
Problem 5: 68
Problem 6: 41
Problem 7: 235
Problem 8: -6
Press any key to continue . . .
*/