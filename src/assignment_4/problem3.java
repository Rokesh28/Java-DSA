	package assignment_4;

public class problem3
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		LinkList theList = new LinkList(); //
		theList.insertFirst(22, 2.99); 
		theList.insertFirst(44, 4.99); 
		theList.insertFirst(66, 6.99); 
		theList.insertFirst(88, 8.99);
		System.out.println("Original Linked List:");
		theList.displayList();
		System.out.println("");
		theList.reverse();
		System.out.println("Reversed Linked List:");
		theList.displayList();
		
		
	
	}

}

class Linkk
{
	public int iData; 
	public double dData; 
	public Linkk next;
	
	public Linkk(int id, double dd) // constructor 
	{
	iData = id; 
	dData = dd; 
	}
	public void displayLink() // display ourself
	{
	System.out.print("{" + iData + ", " + dData + "} "); 
	}
	
}

class LinkList
{
	private Linkk first;
	public LinkList() // constructor
	{
		first = null; // no items on list yet 
	}
	public boolean isEmpty() // true if list is empty
	{
		return (first==null); 
	}
	
	public void reverse() {
		Linkk prev = null;
		Linkk current = first;
		Linkk next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        first = prev; // Set the new head of the reversed list
    }
	public void insertFirst(int id, double dd)
	{ 
		Linkk newLink = new Linkk(id, dd);
		newLink.next = first; // newLink --> old first 
		first = newLink; // first --> newLink
	}
	public Linkk deleteFirst() 
	{
		Linkk temp = first; 
		first = first.next; 
		return temp;
	}
	public void displayList()
	{
		System.out.print("List (first-->last): ");
		Linkk current = first; 
		while(current != null)
		{
		current.displayLink();
		current = current.next; // move to next link 
		}
		System.out.println("");
	}
}