package assignment_6;

public class Project_7_3 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int maxSize = 10;
		ArrayPar arr = new ArrayPar(maxSize);

		arr.insert(77);
		arr.insert(99);
		arr.insert(11);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(44);
		arr.insert(66);
		arr.insert(33);
		System.out.println("The input array considered are unsorted arrrays" );
		System.out.println("");
		System.out.println("");
		System.out.println("Case1: odd number of elements in list" );
		System.out.println("The input array with odd number of total elements are : " );
		arr.display();
		double median = arr.median();
		System.out.println("The median of the input array is: " + median);
		
		System.out.println("");
		
		System.out.println("Case1: even number of elements in list" );
		System.out.println("The input array with even number of total elements are : " );
		arr.insert(00);
		arr.display();
		median = arr.median();
		System.out.println("The median of the input array is: " + median);

	}

}

class ArrayPar 
{
	private int[] a;
	private int nElems;

	public ArrayPar(int max) 
	{
		a = new int[max];
		nElems = 0;
	}

	public void insert(int value) 
	{
		a[nElems] = value;
		nElems++;
	}

	public int size()
	{
		return nElems;
	}

	public void display()
	{
		for(int j=0; j<nElems; j++)
		{
			System.out.print(a[j] + " ");
		}
			 
		System.out.println("");
	}
	
	public int partitionIt(int left, int right) 
	{
		int pivot = a[right]; 
		int leftPtr = left - 1;
    	int rightPtr = right;

		while(true)
		{
  			while(a[++leftPtr] < pivot);

    		while(rightPtr > left && a[--rightPtr] > pivot);
			if(leftPtr >= rightPtr)
			{
				break;
			}
			else
			{
				swap(leftPtr, rightPtr);
			}
    			
		}  
	
		swap(leftPtr, right);
    	return leftPtr; 
	}

	private void swap(int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public double median() 
	{
        int left = 0;
        int right = nElems - 1;
        int mid = nElems / 2;

        while (true) {
            int pivotIndex = partitionIt(left, right);
            if (pivotIndex == mid) {
                break;
            } else if (pivotIndex < mid) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        
        if (nElems % 2 == 0) // even-sized array
        { 
            int num1 = a[mid];
            int num2 = a[mid - 1];
            System.out.println("the two-middle elements after the elemets are sorted are :"+ num1+ " and "+ num2);
            return (((double)(num1 + num2)) / 2);
        } 
        else// odd-sized array
        { 
            return (double)a[mid];
        }
    }
	
}

	