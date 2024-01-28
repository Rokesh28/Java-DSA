package assignment10;
import java.io.*;

public class project_12_2 {

	public static void main(String[] args) throws IOException 
	{
	    
        Heap theHeap = new Heap(31);

       
        theHeap.toss(45); 
        theHeap.toss(50); 
        theHeap.toss(60); 
        theHeap.toss(10); 
        theHeap.toss(70);
        theHeap.toss(80); 
        theHeap.toss(55); 
        theHeap.toss(75); 
        theHeap.toss(20); 
        theHeap.toss(40);

       
        System.out.println("Heap after toss:");
        theHeap.displayHeap();
        theHeap.restoreHeap();      
        System.out.println("Heap after restore:");
        theHeap.displayHeap();
       
	    }

	    public static String getString() throws IOException {
	        InputStreamReader isr = new InputStreamReader(System.in);
	        BufferedReader br = new BufferedReader(isr);
	        return br.readLine();
	    }

	    public static char getChar() throws IOException {
	        String s = getString();
	        return s.charAt(0);
	    }

	    public static int getInt() throws IOException {
	        String s = getString();
	        return Integer.parseInt(s);
	    }
	 
	  
}


class Node {
    private int iData;

    public Node(int key) {
        iData = key;
    }

    public int getKey() {
        return iData;
    }

    public void setKey(int id) {
        iData = id;
    }
}

class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx) 
    {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() 
    {
        return currentSize == 0;
    }

    public void toss(int key)
    {
        if (currentSize == maxSize) 
        {
            System.out.println("Heap is full. Cannot toss more elements.");
            return;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        currentSize++;
    }

    public void restoreHeap()
    {
        for (int i = currentSize / 2 - 1; i >= 0; i--) 
        {
            trickleDown(i);
        }
    }

    private void trickleDown(int index) 
    {
        int largerChild;
        Node top = heapArray[index];

        while (index < currentSize / 2) 
        {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
            {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (top.getKey() >= heapArray[largerChild].getKey()) 
            {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
    
    public void displayHeap() {
        System.out.print("heapArray: ");
        for (int m = 0; m < currentSize; m++)
          if (heapArray[m] != null)
            System.out.print(heapArray[m].getKey() + " ");
          else
            System.out.print("-- ");
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
          if (column == 0)
            for (int k = 0; k < nBlanks; k++)
              System.out.print(' ');

          System.out.print(heapArray[j].getKey());

          if (++j == currentSize)
            break;

          if (++column == itemsPerRow)
          {
            nBlanks /= 2;
            itemsPerRow *= 2;
            column = 0;
            System.out.println();
          } else
            for (int k = 0; k < nBlanks * 2 - 2; k++)
              System.out.print(' ');
        }
        System.out.println("\n" + dots + dots);
      }

}


