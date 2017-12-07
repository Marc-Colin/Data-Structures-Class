public class Coin extends GenericCoin
{
	public double value;
	public String name;

	public Coin()
	{
		super();
	}
	public Coin(String n, double v)
	{
		name = n;
		value = v;
	}
	public Coin(Coin c)
	{
		name = c.name;
		value = c.value;
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
	public boolean equals(Object obj)
	{
		if ((obj == null) || (obj.getClass() != this.getClass()))
		{
			return false;
		}
		else
		{
			Coin temp = (Coin)obj;
			return this.name.equals(temp.getName());
		}
	}
	public String toString()
	{
		return name;
	}
}