import java.util.*;
public class GenericCoin implements CoinInterface
{
	private static final Random RandomNumber = new Random();
	private String side;
	private String HEADS = "HEADS";
	private String TAILS = "TAILS";

	public GenericCoin()
	{
		side = this.FlipCoin();
	}
	public String FlipCoin()
	{
		int flip;
		flip = 1 + RandomNumber.nextInt(2);
		if ( flip == 1)
		{
			side = HEADS;
		}
		else
		{
			side = TAILS;
		}
		return side;
	}
}