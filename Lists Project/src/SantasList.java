import java.util.*;

public class SantasList
{
	public static void main(String[] args)
	{
		Random RandomNumber = new Random();
		ArrayList<Name> Names = new ArrayList<Name>();
		ArrayList<String> Gifts = new ArrayList<String>();
		ArrayList<NicePerson> SantasList = new ArrayList<NicePerson>();

		Gifts.add("Rubik's Cube");
		Gifts.add("Skateboard");
		Gifts.add("Action Figure");
		Gifts.add("Dollhouse");
		Gifts.add("Easy Bake Oven");
		Gifts.add("Calculator");
		Gifts.add("Car");
		Gifts.add("Tea Set");
		Gifts.add("Socks");
		Gifts.add("Yo-Yo");
		Gifts.add("Pokemon Cards");
		Gifts.add("One Million Dollars");

		Names.add(new Name("Naruto","Uzumaki"));
		Names.add(new Name("Sasuke","Uchiha"));
		Names.add(new Name("Sakura","Haruno"));
		Names.add(new Name("Kakashi","Hatake"));
		Names.add(new Name("Rock","Lee"));
		Names.add(new Name("Hinata","Hyuga"));

		for (int i = 0; i < Names.size(); i++)
		{
			NicePerson temp = new NicePerson(Names.get(i));
			for (int c = 0; c < 3; c++)
			{
				temp.addPresent(Gifts.get(RandomNumber.nextInt(Gifts.size())));
			}
			SantasList.add(temp);
		}

		System.out.println("THE NICE LIST");
		for (int i = 0; i < SantasList.size(); i++)
		{
			System.out.println(SantasList.get(i));
		}
	}
}