public class Coin extends GenericCoin
{
	public double value;
	public String name;

	public Coin()
	{
		super();
	}
	public void setValue(double v)
	{
		value = v;
	}
	public double getValue()
	{
		return value;
	}
	public void setName(String n)
	{
		name = n;
	}
	public String getName()
	{
		return name;
	}
}