package assignment_2;

public class Exe3_4 
{
	public static void main(String[]args)
			{
			int maxSize = 100;
			ArrayBub arr;
			arr = new ArrayBub(maxSize);
			arr.insert(77); 
			arr.insert(99); 
			arr.insert(44); 
			arr.insert(55); 
			arr.insert(22); 
			arr.insert(88); 
			arr.insert(11); 
			arr.insert(00); 
			arr.insert(66); 
			arr.insert(33);
			arr.display(); 
			arr.oddEvenSort();
			arr.display();
			}
}

class ArrayBub
{
	private long[] a; 
	private int nElems; 
	
	public ArrayBub(int max) 
	{
		a = new long[max]; 
		nElems = 0;
	}
	public void insert(long value) 
	{
		a[nElems] = value; 
		nElems++;
	}
	public void display() 
	{
	for(int j=0; j<nElems; j++) 
		System.out.print(a[j] + " "); 
	System.out.println("");
	}
	private void swap(int one, int two) 
	{
		long temp = a[one]; 
		a[one] = a[two]; 
		a[two] = temp;
	}
	public void oddEvenSort()
	{
		
		int evenSwapCounter = 0;  // a counter to count number of swaps involved in even passes
		int OddSwapCounter = 0;  // a counter to count number of swaps involved in odd passes
		do 
		{
			evenSwapCounter = 0;  // making counter to 0 for every iteration to check no of swaps in that iteration.
			OddSwapCounter = 0; 
			
			for(int i = 1; i < nElems-1; i += 2)  // odd swaps
			{
				if (a[i] > a[i+1])
				{
					swap(i, i+1);  // comparing the odd pairs and swapping it if its out of order.
					OddSwapCounter++; // increasing the swap counter to count number of odd pair swaps in this iteration
				}
			}
			for(int i = 0; i < nElems; i += 2)
			{
				if (a[i] > a[i+1])
				{
					swap(i, i+1); // comparing the even pairs and swapping it if its out of order.
					evenSwapCounter++; // increasing the swap counter to count number of even pair swaps in this iteration
				}
			}
			
		}while(evenSwapCounter !=0 && OddSwapCounter != 0);  // the iteration continues until there are no swaps involved in both odd and even swaps.
		
	}
}
