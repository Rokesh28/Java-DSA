package assignment10;
import java.util.Arrays;
import java.util.Scanner;

import assignment10.PriorityQueue.PriorityQue;


public class MergeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the number of sorted arrays (N): ");
	        int n = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character

	        // Initialize a PriorityQue to store the sorted arrays
	        MergeList merge = new MergeList();
	        PriorityQueue priorityQue = merge.new PriorityQueue(100);
	        // Take input for each sorted array and insert it into the PriorityQue
	        for (int i = 0; i < n; i++) {
	            System.out.print("Enter sorted array " + (i + 1) + ": ");
	            String inputLine = scanner.nextLine();
	            String[] numbers = inputLine.split("\\s+");
	            int[] sortedArray = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
	        
	            Arrays.sort(sortedArray); // Ensure the input array is sorted
	            priorityQue.insertArray(sortedArray);
	        }
	        priorityQue.displayHeap();
	        // Merge the sorted arrays using the PriorityQue
	        int[] mergedArray = priorityQue.mergeSortedArrays();

	        // Display the merged array
	        System.out.println("\nMerged Sorted Array: " + Arrays.toString(mergedArray));

	        // Close the scanner
	        scanner.close();
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

    public Heap(int mx) {
      maxSize = mx;
      currentSize = 0;
      heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
      return currentSize == 0;
    }

    public boolean insert(int key) {
      if (currentSize == maxSize)
        return false;
      Node newNode = new Node(key);
      heapArray[currentSize] = newNode;
      trickleUp(currentSize++);
      return true;
    }

    public void trickleUp(int index) {
      int parent = (index - 1) / 2;
      Node bottom = heapArray[index];

      while (index > 0 &&
          heapArray[parent].getKey() < bottom.getKey()) {
        heapArray[index] = heapArray[parent];
        index = parent;
        parent = (parent - 1) / 2;
      }
      heapArray[index] = bottom;
    }

    public Node remove() {
      Node root = heapArray[0];
      heapArray[0] = heapArray[--currentSize];
      trickleDown(0);
      return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];

        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            // Choose the larger child
            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            // Compare the top element with the larger child
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }

            // Swap top element with the larger child
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }

        heapArray[index] = top;
    }
    public boolean change(int index, int newValue) {
      if (index < 0 || index >= currentSize)
        return false;
      int oldValue = heapArray[index].getKey();
      heapArray[index].setKey(newValue);

      if (oldValue < newValue)
        trickleUp(index);
      else
        trickleDown(index);
      return true;
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

        if (++column == itemsPerRow) {
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

class PriorityQueue {

    private int maxSize;
    private Heap heap;
    private int nItems;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        heap = new Heap(maxSize);
        nItems = 0;
    }

    public void insert(int item) {
        heap.insert(item);
    }

    public void insertArray(int[] array) {
        for (int value : array) {
            heap.insert(value);
        }
    }
    public void displayHeap() {
    	heap.displayHeap();
    }

    public int remove() {
        return heap.remove().getKey();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public boolean isFull() {
        return heap.currentSize == heap.maxSize;
    }

    // Merge the sorted arrays using the PriorityQue
    public int[] mergeSortedArrays() {
        int[] mergedArray = new int[heap.currentSize];
        int index = 0;

        while (!heap.isEmpty()) {
            mergedArray[index++] = heap.remove().getKey();
        }

        // Reverse the merged array to get the correct order
        reverseArray(mergedArray);

        return mergedArray;
    }

    // Helper method to reverse an array
    private void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Swap elements at left and right indices
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Move indices toward the center
            left++;
            right--;
        }
    }
   
}


}

