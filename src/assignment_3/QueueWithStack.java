package assignment_3;

//copying all the element except the last to temp stack and print the last element by pop.
//Then copying the temp stack to the original stack to maintain the order 
public class QueueWithStack 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		StackX theStack = new StackX(10); // make new stack
		theStack.push(20); 
		theStack.push(40); 
		theStack.push(60); 
		theStack.push(80);
		while( !theStack.isEmpty() ) 
		{
			long value = theStack.pop(); 
			System.out.print(value); 
			System.out.print(" ");
		} // end while
		System.out.println("");
		
	}

}



class StackX
{
	private int maxSize; // size of stack array
	private long[] stackArray1;
	private long[] stackArray2;
	private int top;
	

	public StackX(int s) // constructor
	{
	maxSize = s; // set array size 
	stackArray1 = new long[maxSize]; // create array 
	stackArray2 = new long[maxSize]; 
	top = -1; // no items yet

	}
	public void push(long j) // put item on top of stack
	{
	stackArray1[++top] = j; // increment top, insert item
	}
	public long pop() // take item from top of stack
	{	
		// copying all the element except the last to temp stack and print the last element by pop.
		//Then copying the temp stack to the original stack to maintain the order 
		int top2 = -1;  
		long topElement;
		if (isEmpty())
		{
			return -1;
		}
		else
		{
			while(top>0)
			{
				stackArray2[++top2] = stackArray1[top--];
			}
				
		}
		topElement = stackArray1[top--];
		while(top2>-1)
		{
			stackArray1[++top] = stackArray2[top2--];
		}
		
	return topElement; // access item, decrement top 
	}
	public long peek() // peek at top of stack
	{
	return stackArray1[0]; 
	}
	public boolean isEmpty() // true if stack is empty
	{
	return (top == -1); 
	}
	public boolean isFull() // true if stack is full
	{
	return (top == maxSize-1); 
	}


}
