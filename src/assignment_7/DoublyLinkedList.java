package assignment_7;

import java.util.Stack;

public class DoublyLinkedList {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int[] nodes = {13, 4, 9, 6, 23, 27, 21, 22, 15, 3, 2, 7};
        BinaryTree bst = new BinaryTree();


        for(int i=0; i<nodes.length; i++)
        {
            bst.addNode(nodes[i]);
            
        }
        System.out.println("The Binary Tree Considered is shown bellow:-");
        System.out.println();
        bst.displayTree();
        System.out.println();
        bst.inOrderLinkList(bst.root);
        System.out.println("The Doubly Linked List created inorder is shown bellow:-");
        bst.displayDoublyLinkedList();
        
        
	

}
}

// Doubly Linked List Nodes
class linkListNode 
{
	int data;
	linkListNode fLink;
	linkListNode bLink;

	linkListNode(int data) 
	{
		this.data = data;
		this.fLink = this.bLink = null;
	}
}


class DoubleLinklist
{
	private linkListNode start;
	public int length;

	DoubleLinklist() {
		this.start = null;
		this.length = 0;
	}

	public void insertBeg(int data) {
		linkListNode newNode = new linkListNode(data);

		if(start == null) {
			start = newNode;
		} else {
			start.bLink = newNode;
			newNode.fLink = start;
			start = newNode;
		}

		length++;
	}

	public void insertEnd(int data) 
	{
		linkListNode newNode = new linkListNode(data);

		if(start == null)
		{
			start = newNode;
		} 
		else 
		{
			linkListNode n = start;

			while(n.fLink != null) 
			{
				n = n.fLink;
			}
		
			n.fLink = newNode;
			newNode.bLink = n;
		}

		length++;
	}
	public void displayForward() 
	{
		linkListNode n = start;
		while(n.fLink != null) 
		{
			System.out.print(n.data + " -> ");
			n = n.fLink;
		}
		System.out.print(n.data + " ");
	}
}





//Node for Binary Tree is bellow
class DNode
{
    public int data;
    public DNode left;
    public DNode right;

    public DNode(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
    
   

}


class BinaryTree
{
	DNode root;
	DoubleLinklist DList;

    public BinaryTree()
    {
        root = null;
        DList = new DoubleLinklist();
    }

    public DNode getRoot()
    {
        return root;
    }


    // ITERATIVE ADDITION OF NODES
    public void addNode(int data) 
    {
    	DNode newNode = new DNode(data);

        if(root == null)
        {
            root = newNode;
        } 
        else 
        {
        	DNode p = root;

            while(p != null) 
            {

                if(p.data > data) 
                {
                    if(p.left == null) 
                    {
                        p.left = newNode;
                        break;
                    }

                    p = p.left;

                } 
                else
                {
                    if(p.right == null)
                    {
                        p.right = newNode;
                        break;
                    }

                    p = p.right;
                }
            }
        }
    }
    public void inOrderLinkList(DNode root){
        if(root == null)
            return;

        inOrderLinkList(root.left);
        DList.insertEnd(root.data);
        inOrderLinkList(root.right);
    }
    public void displayDoublyLinkedList() 
    {  
    	DList.displayForward();
    }
    
    public void displayTree() 
    {  
        Stack<DNode> globalStack = new Stack<DNode>();  
        globalStack.push(root);  
        int nBlanks = 32;  
        boolean isRowEmpty = false;  
        System.out.println("............................................................................................................");
        
        while (isRowEmpty == false) 
        {  
            Stack<DNode> localStack = new Stack<DNode>();  
            isRowEmpty = true;  
            for (int j = 0; j < nBlanks; j++) 
            {  
                System.out.print(' ');  
            }  
            while (globalStack.isEmpty() == false) 
            {  
            	DNode temp = (DNode) globalStack.pop();  
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





