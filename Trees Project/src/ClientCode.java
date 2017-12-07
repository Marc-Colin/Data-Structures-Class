import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ClientCode 
{
	static BinarySearchTree<Character> morseTree = new BinarySearchTree<Character>();
	
	public static void main(String[] args) throws IOException
	{
		Scanner morseCode = new Scanner(new File("MORSECODE"));
		morseTree.add('*');
		while(morseCode.hasNext())
		{
			String input = morseCode.next();
			String code  = morseCode.next();
			Character newCode = new Character(input.charAt(0));
			morseTree.add(newCode, 0, code);
		}
		morseCode.close();
		morseTree.printBinarySearchTree();
		System.out.println();
		
		Scanner	testCode = new Scanner(new File("TESTMORSECODE"));
		
		while(testCode.hasNext())
		{
			String sentence = testCode.nextLine();
			System.out.println(sentence);
			String decodedSentence = decodeSentence(sentence);
			System.out.println(decodedSentence);
		}
		testCode.close();
	}
	
	public static void seprateWords(String[] words, String sentence)
	{
		String word = "";
		int count = 0; 
		for(int i = 0; i < sentence.length(); i++)
		{
			if(sentence.charAt(i) != '/')
			{
				word += sentence.charAt(i);
			}
			else
			{
				words[count] = word;
				word = "";
				count++;
			}
		}
		words[count] = word;
	}
	
	public static void seprateLetters(String[] letters, String word)
	{
		String letterCode = "";
		int count = 0;
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) != ' ')
			{
				letterCode += word.charAt(i);
			}
			else
			{
				letters[count] = letterCode;
				letterCode = "";
				count++;
			}
		}
		letters[count] = letterCode;
	}
	
	public static Character decodeLetter(String code)
	{
		Character letter = ' ';
		BinarySearchTreeNode<Character> root = morseTree.getRoot();
		for(int i = 0; i < code.length(); i++)
		{
			if(code.charAt(i) == '.')
			{
				root = root.getLeft();
			}
			if(code.charAt(i) == '-')
			{
				root = root.getRight();
			}
		}
		letter = root.getInfo();
		return letter;
	}
	
	public static String decodeWord(String[] codes)
	{
		String word = "";
		for(int i = 0; i < codes.length; i++)
		{
			word += decodeLetter(codes[i]);
		}
		return word;
	}
	
	public static String decodeSentence(String sentence)
	{
		String decodedSentence = "";
		int numWords = countWords(sentence);
		String[] words = new String[numWords];
		seprateWords(words, sentence);
		for(int i = 0; i < words.length; i++)
		{
			int numLetters = countSpaces(words[i]);
			String[] codes = new String[numLetters];
			seprateLetters(codes, words[i]);
			decodedSentence += (decodeWord(codes) + " ");
		}
		return decodedSentence;
	}
	
	public static int countSpaces(String phrase)
	{
		int count = 0;
		for(int i = 0; i < phrase.length(); i++)
		{
			if(phrase.charAt(i) == ' ')
				count++;
		}
		return count+1; //add one more to count the last letter
	}
	
	public static int countWords(String phrase)
	{
		int count = 0;
		for(int i = 0; i < phrase.length(); i++)
		{
			if(phrase.charAt(i) == '/')
				count++;
		}
		return count+1; //add one more for the last word
	}
	
}

/*
H S V I F U E L R A P W J * B D X N C K Y T Z G Q M O 
.... . .-.. .-.. ---/-.-. .-.. .- ... ...
HELLO CLASS 
-.-. --- -. --. .-. .- - ..- .-.. .- - .. --- -. ...
CONGRATULATIONS 
-.-- --- ..-/.... .- ...- ./... ..- -.-. -.-. . ... ... ..-. ..- .-.. .-.. -.--/-.. . -.-. --- -.. . -../-- --- .-. ... ./-.-. --- -.. .
YOU HAVE SUCCESSFULLY DECODED MORSE CODE 
.... --- .--/-- .- -. -.--/-.-. --- -- .--. ..- - . .-./.--. .-. --- --. .-. .- -- -- . .-. .../-.. --- . .../.. -/- .- -.- ./- ---/-.-. .... .- -. --. ./.-/.-.. .. --. .... - -... ..- .-.. -...
HOW MANY COMPUTER PROGRAMMERS DOES IT TAKE TO CHANGE A LIGHTBULB 
-. --- -. ./- .... .- - .../.-/.... .- .-. -.. .-- .- .-. ./.. ... ... ..- .
NONE THATS A HARDWARE ISSUE 
*/