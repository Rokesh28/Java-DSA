package assignment_8;
import java.util.*;


class Node{
    public int data;
    public Node left;
    public Node right;
    public Node parent;

    public boolean color; // red=(false); black=(true)

    public Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}

class RedBlackTree
{
    Node root;
    boolean RED = false;
    boolean BLACK = true;
    

    public RedBlackTree()
    {
        root = null;
    }

    public Node getRoot()
    {
        return root;
    }
    
    private void rotateRight(Node node) 
    {
    	  Node parent = node.parent;
    	  Node leftChild = node.left;

    	  node.left = leftChild.right;
    	  if (leftChild.right != null) 
    	  {
    	    leftChild.right.parent = node;
    	  }

    	  leftChild.right = node;
    	  node.parent = leftChild;

    	  replaceParentsChild(parent, node, leftChild);
    }
    
    private void rotateLeft(Node node) 
    {
    	  Node parent = node.parent;
    	  Node rightChild = node.right;

    	  node.right = rightChild.left;
    	  if (rightChild.left != null) {
    	    rightChild.left.parent = node;
    	  }

    	  rightChild.left = node;
    	  node.parent = rightChild;

    	  replaceParentsChild(parent, node, rightChild);
    }
    
    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) 
    {
    	  if (parent == null)
    	  {
    	    root = newChild;
    	  } 
    	  else if (parent.left == oldChild) 
    	  {
    	    parent.left = newChild;
    	  } 
    	  else if (parent.right == oldChild)
    	  {
    	    parent.right = newChild;
    	  } 
    	  else
    	  {
    	    throw new IllegalStateException("Node is not a child of its parent");
    	  }

    	  if (newChild != null)
    	  {
    	    newChild.parent = parent;
    	  }
    	  
    }

    public void insert(Node newNode) 
    {
    	  Node node = root;
    	  Node parent = null;

    	  // Traverse the tree to the left or right depending on the data
    	  while (node != null) 
    	  {
    	    parent = node;
    	    if (newNode.data < node.data) 
    	    {
    	      node = node.left;
    	    }
    	    else
    	    {
    	      node = node.right;
    	    } 
    	  }

    	  // Insert new node
    	  newNode.color = RED;
    	  if (parent == null)
    	  {
    	    root = newNode;
    	  } 
    	  else if (newNode.data < parent.data) 
    	  {
    	    parent.left = newNode;
    	  } 
    	  else 
    	  {
    	    parent.right = newNode;
    	  }
    	  newNode.parent = parent;

    	  adjustAfterInsertion(newNode);
    	}

    private void adjustAfterInsertion(Node node) 
    {
    	  Node parent = node.parent;

    	 
    	  if (parent == null) 
    	  {
    	    return;
    	  }

    	  // Parent is black 
    	  if (parent.color == BLACK) {
    	    return;
    	  }

    	  //parent is red
    	  Node grandparent = parent.parent;

    	  
    	  if (grandparent == null) 
    	  {
    	    parent.color = BLACK;
    	    return;
    	  }

    	  // Get the uncle 
    	  Node uncle = getUncle(parent);

    	  // Uncle is red 
    	  if (uncle != null && uncle.color == RED) 
    	  {
    	    parent.color = BLACK;
    	    grandparent.color = RED;
    	    uncle.color = BLACK;
    	    adjustAfterInsertion(grandparent);
    	  }

    	  // Parent is left child of grandparent
    	  else if (parent == grandparent.left) 
    	  {
    	   
    	    if (node == parent.right)
    	    {
    	      rotateLeft(parent);
    	  
    	      parent = node;
    	    }

    	    rotateRight(grandparent);
    	    parent.color = BLACK;
    	    grandparent.color = RED;
    	  }

    	  
    	  else 
    	  {
    	    
    	    if (node == parent.left) 
    	    {
    	      rotateRight(parent);
    	      parent = node;
    	    }
    	    
    	    rotateLeft(grandparent);
    	    parent.color = BLACK;
    	    grandparent.color = RED;
    	  }
    	}
    
    private Node getUncle(Node parent) 
    {
    	  Node grandparent = parent.parent;
    	  if (grandparent.left == parent) 
    	  {
    	    return grandparent.right;
    	  } 
    	  else if (grandparent.right == parent) 
    	  {
    	    return grandparent.left;
    	  }
    	  else 
    	  {
    	    throw new IllegalStateException("Parent is not a child of its grandparent");
    	  }
    	}
    
    
    
    //method not called for this assignment
    public int countNodes(Node root)
    {
    	if(root == null) 
    		return 0;
        
    	return countNodes(root.left) + 1 + countNodes(root.right);
    }

  //method not called for this assignment
    public void inOrderPrint(Node root)
    {
        if(root == null)
            return;

        inOrderPrint(root.left);
        System.out.print(root.data + " | ");
        inOrderPrint(root.right);
    }
    
  //method not called for this assignment
    public void preOrderPrint(Node root)
    {
        if(root == null)
            return;

        System.out.print(root.data + " | ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

  //method not called for this assignment
    public void postOrderPrint(Node root)
    {
        if(root==null)
            return;

        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.print(root.data + " | ");
    }
   
    
    //method not called for this assignment
    //Height of the Tree
    public int height(Node root) 
    {
        if (root == null)
           return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight + 1);
            else return(rheight + 1);
        }
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
                    System.out.print(temp.data);  
                    localStack.push(temp.left);  
                    localStack.push(temp.right);  
   
                    if (temp.left != null 
                            || temp.right != null) 
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

public class RBTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		RedBlackTree rbTree = new RedBlackTree();
        int[] values = {1,3,5,12,14,24,35,46,65}; // the input nodes in ascending order is taken
        
        for (int value : values) {
            Node node = new Node(value);
            rbTree.insert(node);
        }

        System.out.println("Red-Black Tree:");
        rbTree.displayTree();
        
  
	}

}
