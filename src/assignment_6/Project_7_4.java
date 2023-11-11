package assignment_6;

public class Project_7_4
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int maxSize = 10;
		ArrayPart arr = new ArrayPart(maxSize);

		arr.insert(77);
		arr.insert(99);
		arr.insert(11);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(44);
		arr.insert(66);
		arr.insert(33);
		arr.insert(00);
		
		System.out.println("The input array considered : " );
		arr.display();
		System.out.println("");
		System.out.println("");
		int k = 3;
		int kthLargest = arr.kthLargest(k);
		System.out.println("the " + k + "th largest element in the list is : "+ kthLargest );
		arr.display();
		int kthSmallest = arr.kthSmallest(k);
		System.out.println("the " + k + "th smalest element in the list is : "+ kthSmallest );
		arr.display();
		
	
		
	}
}

class ArrayPart 
{
	private int[] a;
	private int nElems;

	public ArrayPart(int max) 
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
	
	
	public int partitionIt(int left, int right, int pivot) 
	{
		int leftPtr = left-1;
    	int rightPtr = right;

		while(true)
		{
  			while(leftPtr < right && a[++leftPtr] < pivot);

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

	public void swap(int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public int kthLargest(int k) 
	{
        int left = 0;
        int right = nElems - 1;
        int index = nElems-k;

        while (true) {
        	int median = medianOf3(left, right);
            int pivotIndex = partitionIt(left, right, median);
            if (pivotIndex == index)
            {
                break;
            } 
            else if (pivotIndex < index) 
            {
                left = pivotIndex + 1;
            } 
            else
            {
                right = pivotIndex - 1;
            }
        }
        
        return a[index];
        
	}
	public int kthSmallest(int k) 
	{
        int left = 0;
        int right = nElems - 1;
        int index = k-1;

        while (true) {
        	int median = medianOf3(left, right);
            int pivotIndex = partitionIt(left, right, median);
            if (pivotIndex == index) {
                break;
            } else if (pivotIndex < index) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        
        return a[index];
	}
	

    private int medianOf3(int left, int right) 
    {
        int center = (left + right) / 2;
        if( a[left] > a[center] )
        {
            swap(left, center);
        }
        if( a[left] > a[right] ) 
        {
            swap(left, right);
            
        }
        if( a[center] > a[right] ) 
        {
            swap(center, right);
            
        }
        swap(center, right);
        
        return a[right];
    }
    
   
	
}

