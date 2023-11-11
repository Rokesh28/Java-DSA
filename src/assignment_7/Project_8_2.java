package assignment_7;
import java.io.*;  
import java.util.*;  

public class Project_8_2 
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		try (Scanner scanner = new Scanner(System.in))
		{
			System.out.print("Enter the string of letters to represent in the binary tree: ");
			String input = scanner.nextLine();
			
			Tree theTree = new Tree();
			
			theTree.insert(input);
			

			System.out.println("The Balanced Binary Tree is shown below");
			theTree.displayTree();
		}  

	}
	

}
	

	class Node 
	{  
	    public char sData; 
	    public Node leftChild;
	    public Node rightChild;
	    public void displayNode()
	    {  
	        System.out.print('{');  
	        System.out.print(sData);  
	        System.out.print(", ");  
	        System.out.print("} ");  
	    }  
	    public Node(char data) 
	    {
	        this.sData = data;
	        this.leftChild = null;
	        this.rightChild = null;
	    }
	}
	class Tree
	{  
	    public Node root;
	    public Tree()
	    {  
	        root = null;  
	    }
	    public Node insert(String input) 
	    {
	       
	        ArrayList<Node> forest = new ArrayList<>();

	        // Create a forest of one-node trees with single-letter nodes
	        for (int i = 0; i < input.length(); i++) 
	        {
	            char letter = input.charAt(i);
	            Node node = new Node(letter);
	            forest.add(node);
	        }

	        while (forest.size() > 1) 
	        {
	            ArrayList<Node> newForest = new ArrayList<>();
	            for (int i = 0; i < forest.size(); i += 2)
	            {
	                if (i + 1 < forest.size())
	                {
	                	Node newNode = new Node('+');
	                    newNode.leftChild = forest.get(i);
	                    newNode.rightChild = forest.get(i + 1);
	                    newForest.add(newNode);
	                }
	                else 
	                {
	                    // If there's an odd number of trees, add the last one as is
	                	Node newNode = new Node('+');
	                    newNode.leftChild = forest.get(i);
	                    
	                    newForest.add(newNode);
	                  
	                    
	                }
	            }
	            forest = newForest;
	        }
	        // The final tree is the root of the forest
	        root = forest.get(0); 
	        return forest.get(0); 
	    }  
	    
	 public void displayTree()
 {  
	        Stack<Node> globalStack = new Stack<Node>();  
	        globalStack.push(root);  
	        int nBlanks = 32;  
	        boolean isRowEmpty = false;  
	        System.out.println("............................................................................................................");
	        
	        while (isRowEmpty == false)
	        {  
	            Stack<Node> localStack = new Stack<Node>();  
	            isRowEmpty = true;  
	            for (int j = 0; j < nBlanks; j++)
	            {  
	                System.out.print(' ');  
	            }  
	            while (globalStack.isEmpty() == false) 
	            {  
	                Node temp = (Node) globalStack.pop();  
	                if (temp != null) 
	                {  
	                    System.out.print(temp.sData);  
	                    localStack.push(temp.leftChild);  
	                    localStack.push(temp.rightChild);  
	   
	                    if (temp.leftChild != null 
	                            || temp.rightChild != null) 
	                    {  
	                        isRowEmpty = false;  
	                    }  
	                } 
	                else
	                {  
	                    System.out.print("--");  
	                    localStack.push(null);  
	                    localStack.push(null);  
	                }  
	                for (int j = 0; j < nBlanks * 2 - 2; j++) 
	                {  
	                    System.out.print(' ');  
	                }  
	              
	            }
	            System.out.println();  
	            nBlanks /= 2;  
	            while (localStack.isEmpty() == false) 
	            {  
	                globalStack.push(localStack.pop());  
	            }  
	        }
	        System.out.println("............................................................................................................");  
	    }
	}
