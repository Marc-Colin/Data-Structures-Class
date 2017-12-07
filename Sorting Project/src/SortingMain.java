import java.util.*;

public class SortingMain
{
	public static void main(String[] args)
	{
		int LENGTH = 10;
		Random RandomNumber = new Random();
		Integer[] numSet = new Integer[LENGTH];
		ArraySorter Sorter = new ArraySorter();

		//creates an array of random numbers
		for (int i = 0; i < LENGTH; i++)
		{
			numSet[i] = RandomNumber.nextInt(100);
		}

				//Selection Sort
		//displays initial number set
		System.out.println("Selection Sort:");
		System.out.print("[" + numSet[0] + ", ");
		for(int i = 1; i < (LENGTH - 1); i++)
		{
			System.out.print(numSet[i] + ", ");
		}
		System.out.print(numSet[LENGTH - 1] + "]" + "\n");
		//calls and displays the selection sort
		Sorter.selectionSort(numSet, LENGTH);
		System.out.println("");

		//fills array with new numbers
		for (int i = 0; i < LENGTH; i++)
		{
			numSet[i] = RandomNumber.nextInt(100);
		}

				//Insertion Sort
		//displays initial number set
		System.out.println("Insertion Sort:");
		System.out.print("[" + numSet[0] + ", ");
		for(int i = 1; i < (LENGTH - 1); i++)
		{
			System.out.print(numSet[i] + ", ");
		}
		System.out.print(numSet[LENGTH - 1] + "]" + "\n");
		//calls and displays the insertion sort
		Sorter.insertionSort(numSet, LENGTH);
		System.out.println("");

		//fills array with new numbers (1-10)
		for (int i = 0; i < LENGTH; i++)
		{
			numSet[i] = RandomNumber.nextInt(10);
		}

				//Counting Sort
		//displays initial number set
		System.out.println("Counting Sort:");
		System.out.print("[" + numSet[0] + ", ");
		for(int i = 1; i < (LENGTH - 1); i++)
		{
			System.out.print(numSet[i] + ", ");
		}
		System.out.print(numSet[LENGTH - 1] + "]" + "\n");
		//calls and displays the counting sort
		numSet = countingSort(numSet, 9);
		System.out.print("[" + numSet[0] + ", ");
		for(int i = 1; i < (LENGTH - 1); i++)
		{
			System.out.print(numSet[i] + ", ");
		}
		System.out.print(numSet[LENGTH - 1] + "]" + "\n");
	}

	//method for counting sort, accepts two params
	//Integer array which is the Number set
	//int that shows the biggest number in the set
	public static Integer[] countingSort(Integer[] numSet, int maxNum)
	{
		Integer[] countNums = new Integer[maxNum + 1];
		Integer[] sortedSet = new Integer[numSet.length];
		int sortIndex = 0;

		for(int c = 0; c < countNums.length; c++)
		{
			countNums[c] = 0;
		}

		for(int j = 0; j <= maxNum; j++)
		{
			for(int h = 0; h < numSet.length; h++)
			{
				if(numSet[h] == j)
				{
					countNums[j] += 1;
				}
			}
		}

		for(int i = 0; i < countNums.length; i++)
		{
			Integer count = countNums[i];
			for(int k = 0; k < count; k++)
			{
				sortedSet[sortIndex] = i;
				sortIndex++;
			}
		}
		return sortedSet;
	}
}


/*
Selection Sort:
[54, 70, 45, 26, 82, 52, 81, 57, 98, 43]
[26, 70, 45, 54, 82, 52, 81, 57, 98, 43]
[26, 43, 45, 54, 82, 52, 81, 57, 98, 70]
[26, 43, 45, 54, 82, 52, 81, 57, 98, 70]
[26, 43, 45, 52, 82, 54, 81, 57, 98, 70]
[26, 43, 45, 52, 54, 82, 81, 57, 98, 70]
[26, 43, 45, 52, 54, 57, 81, 82, 98, 70]
[26, 43, 45, 52, 54, 57, 70, 82, 98, 81]
[26, 43, 45, 52, 54, 57, 70, 81, 98, 82]
[26, 43, 45, 52, 54, 57, 70, 81, 82, 98]

Insertion Sort:
[33, 5, 16, 67, 40, 70, 31, 18, 44, 27]
[5, 16, 18, 27, 31, 33, 40, 44, 67, 70]

Counting Sort:
[6, 9, 5, 0, 0, 1, 2, 6, 4, 1]
[0, 0, 1, 1, 2, 4, 5, 6, 6, 9]
Press any key to continue . . .
*/
