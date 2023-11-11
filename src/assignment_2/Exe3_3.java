package assignment_2;

//Note: Inputs are directly given in main function and then arranged using insertion sort. Then Apply noDups();
public class Exe3_3 
{
	public static void main(String[] args) 
	{
		int maxSize = 100;
		ArrayIns arr;
		arr = new ArrayIns(maxSize);
		arr.insert(77); 
		arr.insert(77); 
		arr.insert(44); 
		arr.insert(55); 
		arr.insert(22); 
		arr.insert(33); 
		arr.insert(11); 
		arr.insert(00); 
		arr.insert(33); 
		arr.insert(33);
		arr.display(); 
		arr.insertionSort();
		arr.display();
		arr.noDups(); // A new method to remove duplicate by moving each element at max by one time.
		arr.display();
	}

}

class ArrayIns
{
	private long[] a; 
	private int nElems;
	
	public ArrayIns(int max) 
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
		System.out.println(" ");
	}
	public void insertionSort()
	{
		int in, out;
		for(out=1; out<nElems; out++)
		{
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1] >= temp)
			{
				a[in] = a[in-1]; 
				--in;
			}
			a[in] = temp; 
		} 
	}	
	public void noDups()
	{
		int pointer, runner;  // Using pointer to re-order the Number and Runner to move over all the elements to check the duplicate element
		pointer = 0;
		for(runner = 1; runner<nElems; runner++)
		{
			if (a[runner] > a[pointer]) // until unless the number is greater than the previous sorted number it will not pass the argument, Thus avoiding duplicate number (being duplicates are equal in value) 
			{
				a[pointer+1] = a[runner]; // re-arranging the numbers with new pointer without duplicates
				pointer++;
			}
		}
		
		long[] tempArray = new long[pointer+1]; // Using new array only to remove unwanted duplicates.
		
		for (int i = 0; i <=pointer; i++) // loop stops before duplicate element starts
		{
			tempArray[i] = a[i]; 
		}
		a= tempArray; // now copying the Temp array to original array
		nElems = pointer+1; // updating the number of elements in the array after removing the duplicate elements
	}
}


