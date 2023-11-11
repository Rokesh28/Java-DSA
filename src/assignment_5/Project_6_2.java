package assignment_5;

class Tree
{
	String[] tree;
	int row;
	int numLines;
	
	
	public Tree(int s)
	{	
		numLines = s;
		tree = new String[s];
		row = 0;
		
		
	}
	
	public void makeBranches(int left, int right) 
	{
	
		int mid = (left + right) / 2;
			
        if (row < numLines) 
        {
        	for(int i = left; i <= right; i++)
        	{
        		if(i == mid)
        		{
        			tree[row]  += 'X';
        		}
        		else
        		{
        			tree[row] += '-';
        		}
        	}  
        	
            row++;  
            makeBranches(left, mid);
            makeBranches(mid+1 , right);
            row--;
        } 
        
    }
	public void display()
	{
		 for (int i = 0; i < tree.length; i++) 
		 {
	            System.out.println(tree[i]);
	     }
	}
}

public class Project_6_2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int lineSize;
		int[] lineSizes = {4,8,16,32,64};
		for (int p =1; p<lineSizes.length; p++)
		{
			lineSize = lineSizes[p]; // You can change the line width here
	        int numLines = (int) Math.ceil(Math.log(lineSize) / Math.log(2)) + 1;

	        Tree bTree = new Tree(numLines);
	        
	        for (int i = 0; i < numLines; i++)
	        {
	        	bTree.tree[i] = "";
	        }
	        System.out.println("The tree structure for "+ (p+3) + " line(s) are shown below:");
	        bTree.makeBranches(0, lineSize - 1);
	        bTree.display();
	        System.out.println("");
	        System.out.println("");
		}
	 	
        
	}
	


}
