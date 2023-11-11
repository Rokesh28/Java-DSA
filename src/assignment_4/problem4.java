package assignment_4;

public class problem4 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		LinkListt theList = new LinkListt(); 
		theList.insertFirst(22, 2.99); 
		theList.insertFirst(44, 4.99); 
		theList.insertFirst(66, 6.99); 
		theList.insertFirst(88, 8.99);
		theList.insertFirst(99, 9.99);
		System.out.println("the Linked List:");
		theList.displayList();
		// Creating a cycle
		theList.first.next.next.next = theList.first.next;
		
		boolean hasCycle =  theList.hasCycle();

        if (hasCycle) 
        {
            System.out.println("The linked list has a cycle.");
        } 
        else
        {
            System.out.println("The linked list does not have a cycle.");
        }

	}
}


class Linkkk
{
	public int iData; 
	public double dData; 
	public Linkkk next;
	
	public Linkkk(int id, double dd) // constructor 
	{
	iData = id; 
	dData = dd; 
	}
	public void displayLink() // display ourself
	{
	System.out.print("{" + iData + ", " + dData + "} "); 
	}
	
}

class LinkListt
{
	public Linkkk first;
	public LinkListt() // constructor
	{
		first = null; // no items on list yet 
	}
	public boolean isEmpty() // true if list is empty
	{
		return (first==null); 
	}
	
	
	public void insertFirst(int id, double dd)
	{ 
		Linkkk newLink = new Linkkk(id, dd);
		newLink.next = first; // newLink --> old first 
		first = newLink; // first --> newLink
		
	}
	 boolean hasCycle()
	 {
	        if (first == null) 
	        {
	            return false; // Empty list, no cycle
	        }

	        Linkkk slow = first;
	        Linkkk fast = first;

	        while (fast != null && fast.next != null)
	        {
	            slow = slow.next;       // Move one step at a time
	            fast = fast.next.next;  // Move two steps at a time

	            if (slow == fast)
	            {
	                return true;  // If they meet, there's a cycle
	            }
	        }

	        return false;  // No cycle found
	   }
	public Linkkk deleteFirst() 
	{
		Linkkk temp = first; 
		first = first.next; 
		return temp;
	}
	public void displayList()
	{
		System.out.print("List (first-->last): ");
		Linkkk current = first; 
		while(current != null)
		{
		current.displayLink();
		current = current.next; // move to next link 
		}
		System.out.println("");
	}
}


