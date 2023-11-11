package assignment_2;

// Assumption - the numbers passed are positive
public class Exe3_6 {

	public static void main(String[] args) 
	{
		int maxSize = 100;
		ArrayInss arr;
		arr = new ArrayInss(maxSize);
		// Assumption - the numbers passed are positive
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
		//arr.insertionSort();
		arr.modifiedInsertionSort();
		arr.display();

	}

}

class ArrayInss
{
	private long[] a; 
	private int nElems;
	
	public ArrayInss(int max) 
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
	
	public void modifiedInsertionSort()
	{   // Assumption - the numbers passed are only positive.
		int in, out;
		for(out=1; out<nElems; out++)
		{
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1] >= temp)
			{	
				if(a[in-1] == temp) // check if there are duplicates
				{
					temp = -1;  // if duplicates found changing the key value of the duplicate to -1, So that when its sorting it will move to index 0.
					
				}
				a[in] = a[in-1]; 
				--in;
			}
			a[in] = temp;  
		} 
		// Following code is used to remove the duplicates in the first.
		//(all the duplicates would have been changed to value -1 and sorted to the first of the array)
		int j = 0; // used as a pointer to re-arrange without duplicates.
		for(int i = 0; i < nElems; i++)
		{	
			if(a[i]==-1) // checking if thats a duplicate value and then just avoiding the value
			{
				continue; // avoid duplicates
			}
			else
			{
				a[j] = a[i]; // re-arranging non duplicate values
				j++; 
			}
			
		}
		nElems = j; // updating the number of elements in the array after removing the duplicate elements
	}
	
	
}
