package assignment_7;
import java.io.*;  
import java.util.*;  

public class Project_8_4 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) 
		{			System.out.print("Assumption: The Entered value or either single digit integers or aphabets(A-Z) ");
					System.out.println();
					System.out.println();
					System.out.print("Enter the Postfix Algebric Expression: ");
					String input = scanner.nextLine();
					
					ATree theTree = new ATree();
					
					theTree.insert(input);
					
					System.out.println();
					System.out.println("The infix expression");
					theTree.printInfix(theTree.root);
					System.out.println();
					System.out.println();
					System.out.println("the Prefix expression");
					theTree.printPreOrder(theTree.root);
					System.out.println();
					System.out.println();
					System.out.println("the Postfix expression");
					theTree.printPostOrder(theTree.root);
					System.out.println();
					System.out.println();
					System.out.println("The tree view");
					theTree.displayTree();
					
		}  

	}	

}

class TNode {  
    public char sData; 
    public TNode leftChild;
    public TNode rightChild;
    public void displayNode()
    {  
        System.out.print('{');  
        System.out.print(sData);  
        System.out.print(", ");  
        System.out.print("} ");  
    }  
    public TNode(char data) {
        this.sData = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class ATree {  
	   
    public TNode root;
    public ATree()
    {  
        root = null;  
    }
    
    public void insert(String input) 
    {
    	Stack<TNode> stack = new Stack<>();

    	for (char token : input.toCharArray())
    	{
            if (isOperand(token)) 
            {
            	TNode node = new TNode(token);
                stack.push(node);
            } 
            else if (isOperator(token)) 
            {
            	TNode rightOperand = stack.pop();
            	TNode leftOperand = stack.pop();
            	TNode operatorNode = new TNode(token);
                operatorNode.leftChild = leftOperand;
                operatorNode.rightChild = rightOperand;
                stack.push(operatorNode);
            }
    	}
            
        root = stack.pop();
 
         
    }  
	public  boolean isOperand(char c) 
	{
        return Character.isLetterOrDigit(c);
    }

    public  boolean isOperator(char c) 
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    public  void printInfix(TNode root) 
    {
        if (root != null)
        {
            boolean needsParentheses = false;

            if (isOperator(root.sData))
            {
                needsParentheses = true;
            }

            if (needsParentheses) 
            {
                System.out.print("(");
            }

            boolean isLeftOperand = isOperand(root.sData) && root.leftChild != null;
            boolean isRightOperand = isOperand(root.sData) && root.rightChild != null;

            if (isLeftOperand) 
            {
                System.out.print("(");
            }
            printInfix(root.leftChild);
            if (isLeftOperand) 
            {
                System.out.print(")");
            }

            System.out.print(root.sData);

            if (isRightOperand) 
            {
                System.out.print("(");
            }
            printInfix(root.rightChild);
            if (isRightOperand) 
            {
                System.out.print(")");
            }

            if (needsParentheses) 
            {
                System.out.print(")");
            }
        }
    }
    public void printPreOrder(TNode root)
    {
        if(root == null)
            return;

        System.out.print(root.sData);
        printPreOrder(root.leftChild);
        printPreOrder(root.rightChild);
    }
    public void printPostOrder(TNode root)
    {
        if(root==null)
            return;

        printPostOrder(root.leftChild);
        printPostOrder(root.rightChild);
        System.out.print(root.sData);
    }
    public void displayTree() 
    {  
        Stack<TNode> globalStack = new Stack<TNode>();  
        globalStack.push(root);  
        int nBlanks = 32;  
        boolean isRowEmpty = false;  
        System.out.println("............................................................................................................");
        
        while (isRowEmpty == false)
        {  
            Stack<TNode> localStack = new Stack<TNode>();  
            isRowEmpty = true;  
            for (int j = 0; j < nBlanks; j++)
            {  
                System.out.print(' ');  
            }  
            while (globalStack.isEmpty() == false) 
            {  
            	TNode temp = (TNode) globalStack.pop();  
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


