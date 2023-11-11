package assignment_3;

public class StackWithQueues 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Queue theQueue = new Queue(5);
	    theQueue.insert(10); 
		theQueue.insert(20); 
		theQueue.insert(30); 
		theQueue.insert(40);
		theQueue.remove(); 
		theQueue.remove(); 
		theQueue.remove();
		theQueue.insert(50); 
		theQueue.insert(60); 
		theQueue.insert(70); 
		theQueue.insert(80);
		 
		while( !theQueue.isEmpty() ) 
		{
			long n = theQueue.remove(); 
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");

	}

}


class Queue
{
	private int maxSize; 
	private long[] queArray;
	private long[] queArray2;
	
	private int front; 
	private int rear; 
	private int nItems;
	
	public Queue(int s) // constructor
	{
		maxSize = s;
		queArray = new long[maxSize]; 
		queArray2 = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	public void insert(long j) 
	{
		if(rear == maxSize-1)
			rear = -1;
		queArray[++rear] = j;
		nItems++;
	}
	public long remove() // take item from front of queue
	{	
		//copying all the element except the last to temporary queArray and print the last element by removing.
		//Then copying the temporary queue to the original stack to maintain the order 
		int TempNItems = nItems;
		while (TempNItems > 1)
		{
			long temp = queArray[front++]; // get value and incr front 
			TempNItems--;
			if(rear == maxSize-1)
				rear = -1;
			queArray2[++rear] = temp;
			
			if(front == maxSize) // deal with wraparound
				front = 0;
		}
		long element = queArray[front++]; // get value and incr front 
		if(front == maxSize) // deal with wraparound
			front = 0;
		nItems--; // one less item 
		
		queArray = queArray2;
		
		
		return element;
	}
	public long peek() // peek at front of queue
	{	if(isEmpty())
		{
			return -1;
		}
		return queArray[rear];
	}
	public boolean isEmpty() // true if queue is empty 
	{
	return (nItems==0);
	}
	public boolean isFull() // true if queue is full 
	{
	return (nItems==maxSize);
	}
	public int size() // number of items in queue 
	{
	return nItems;
	}
}