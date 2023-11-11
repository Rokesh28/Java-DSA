package assignment_7;

import java.util.Stack;

public class Subtree {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 
		
			SNode mainTree = new SNode(10);
	        mainTree.left = new SNode(4);
	        mainTree.right = new SNode(6);
	        mainTree.left.left = new SNode(30);
	        mainTree.left.right = new SNode(2);
	        System.out.println("The first tree considered is shown below: ");
	        System.out.println();
	        mainTree.displayTree(mainTree);
	        System.out.println();

	        SNode subtree = new SNode(4);
	        subtree.left = new SNode(30);
	        subtree.right = new SNode(2);
	        System.out.println();
	        System.out.println("The Second tree considered is shown below: ");
	        subtree.displayTree(subtree);
	        System.out.println();
	        boolean isSubtree = isSubtree(mainTree, subtree);
	        System.out.println("Is the second tree a subtree of the first tree? :- " + isSubtree);
	        
	}
	
	public static boolean isSubtree(SNode mainTree, SNode subtree) 
	{
        if (subtree == null) 
        {
            return true; // An empty tree is a subtree of any tree.
        }
        
        if (mainTree == null) 
        {
            return false; // The main tree is empty, and the subtree is not.
        }

        if (areIdentical(mainTree, subtree))
        {
            return true;
        }

        return isSubtree(mainTree.left, subtree) || isSubtree(mainTree.right, subtree);
    }

    public static boolean areIdentical(SNode tree1, SNode tree2) 
    {
        if (tree1 == null && tree2 == null) 
        {
            return true;
        }

        if (tree1 == null || tree2 == null) 
        {
            return false;
        }

        return (tree1.data == tree2.data) &&
            areIdentical(tree1.left, tree2.left) &&
            areIdentical(tree1.right, tree2.right);
    }

}


class SNode
{
    public int data;
    public SNode left;
    public SNode right;

    public SNode(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
    
    public void displayTree(SNode root )
    {  
        Stack<SNode> globalStack = new Stack<SNode>();  
        globalStack.push(root);  
        int nBlanks = 32;  
        boolean isRowEmpty = false;  
        System.out.println("............................................................................................................");
        
        while (isRowEmpty == false)
        {  
            Stack<SNode> localStack = new Stack<SNode>();  
            isRowEmpty = true;  
            for (int j = 0; j < nBlanks; j++)
            {  
                System.out.print(' ');  
            }  
            while (globalStack.isEmpty() == false) 
            {  
                SNode temp = (SNode) globalStack.pop();  
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

