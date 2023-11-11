package assignment_4;


public class Problem1 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Matrix matrix = new Matrix();
		int[] r1 = {1,2,3,4,5};
		int[] r2 = {6,-1,8,9,-1};
		int[] r3 = {-1,12,13,-1,15};
		int[] r4 = {16,17,-1,-1,20};
		
		
		matrix.insertrow(r1);
		matrix.insertrow(r2);
		matrix.insertrow(r3);
		matrix.insertrow(r4);
		System.out.println("Assumption: -1 is considered as empty for testing the insert operation");
		System.out.println("Matrix after insertion of all elements with index shown in brackets");
		matrix.displayMatrix();
		System.out.println("");
		System.out.println("Matrix after insertion of elements at (2,2) with value 7");
		matrix.insert(2, 2, 7);
		matrix.displayMatrix();
		System.out.println("");
		System.out.println("Matrix after insertion of elements at (3,4) with value 14");
		matrix.insert(3, 4, 14);
		matrix.displayMatrix();
		System.out.println("");
		System.out.println("Matrix after insertion of elements at (3,1) with value 11");
		matrix.insert(3, 1, 11);
		matrix.displayMatrix();
		
		System.out.println("");
		System.out.println("Matrix after deleting elements at (2,2) with value 7 which was initially -1");
		matrix.delete(2, 2);
		matrix.displayMatrix();
		System.out.println("");
		System.out.println("Matrix trying to insert elements at (2,2) with value 5");
		matrix.insert(2, 2, 5);
		System.out.println("");
		matrix.displayMatrix();
		System.out.println("");
		System.out.println("Matrix trying to insert elements at (2,4) with value 50");
		matrix.insert(2, 4, 50);
		matrix.displayMatrix();
		System.out.println("");
		System.out.println("Matrix after deleting the element at (4,3)");
		matrix.delete(4, 3);
		matrix.displayMatrix();
		System.out.println("");
	}

}

class Link
{
	public int dData; // data item
	public Link right; // right link in matrix
	public Link down;
	public int row;
	public int col;

	public Link(int dd) // constructor
	{ 
		dData = dd;
		
	}
	public void displayLink() // display this link 
	{ 
		System.out.print(dData + "(" +  row + "," + col + ")  "); 
	}
	
}

class Matrix
{
	private Link first;
	
	public Matrix()
	{
		first = null;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	public void insertrow(int[] rData)
	{
		
			
		if (isEmpty())
		{
			Link curLink = new Link(rData[0]);
			curLink.row = 1;
			curLink.col = 1;
			first = curLink;
			
			for(int i = 1; i< rData.length; i++)
			{
				Link rowLink = new Link(rData[i]);
				curLink.right = rowLink;
				curLink = rowLink;
				curLink.row = 1;
				curLink.col = i+1;
				
			}
			
		}
		else
		{	
			Link topLink = first;
			
			while(topLink.down != null)
			{
				topLink = topLink.down;
				
			}
			Link rowData = new Link(rData[0]);
			topLink.down = rowData;
			rowData.row = topLink.row + 1;
			rowData.col = topLink.col;
			topLink = topLink.right;
			
			for(int j=1;j<rData.length;j++)
			{
				Link rowLink = new Link(rData[j]);
				topLink.down = rowLink;
				rowData.right = rowLink;
				rowLink.row = topLink.row + 1;
				rowLink.col = rowData.col+1;
				topLink = topLink.right;
				rowData = rowData.right;
			}
			
		}
		
	}
	public void insert(int row, int col, int key)
	{
		if (isEmpty())
		{
			if(row == 1 && col == 1)
			{
				Link cell = new Link(key);
				first = cell;
			}
			else
			{
				System.out.println("link doesn’t exist in that location");
			}
		}
		else 
		{
			Link curCell = first;
			
			int r =1;
			int c =1;
			while(r < row)
			{	
				curCell = curCell.down;
				if (curCell == null)
				{
					System.out.println("link doesn’t exist in that location");	
					break;
				}
				r = curCell.row;	
			}
			if(r!=row)
			{
				System.out.println("link doesn’t exist in that location");
			}
			else
			{
				while(c < col && curCell.col != 0)
				{	
					curCell = curCell.right;
					if (curCell == null)
					{
						System.out.println("link doesn’t exist in that location");	
						break;
					}
					c = curCell.col;	
				}
				if(c!=col)
				{
					System.out.println("link doesn’t exist in that location");
				}
				else
				{
					if(curCell.dData == -1)
					{
						curCell.dData = key;
					}
					else
					{
						System.out.println("Link already has content - cant replace it");
					}
				}
			}
			
			
			
		}
	}
	public void delete(int row, int col)
	{
		int r = 1;
		int c = 1;
		
		if(row < 1 || col < 1)
		{
			System.out.println("use different index with values greater than are equal to 1");
		}
		else if (isEmpty())
		{
			System.out.println("link doesn’t exist in that location");
		}
		else
		{	
			Link curCell = first;
			Link prevRow = first;
			Link prevCol = first;
			while(r<row && curCell.row != 0)
			{
				prevRow = curCell;
				curCell = curCell.down;
				if (curCell == null)
				{
					System.out.println("link doesn’t exist in that location");
					break;
				}
				
				r = curCell.row;
				
			}
			
			if (r == row)
			{	prevCol = curCell;
				while(c<col && curCell.col != 0)
				{
					prevCol = curCell;
					curCell = curCell.right;
					if (curCell == null)
					{
						System.out.println("link doesn’t exist in that location");
						break;
					}
					
					c = curCell.col;
					
				}
				
				if (c == col)
				{
					
					
					if(prevCol.col < col)
					{
						if(curCell.right != null)
						{prevCol.right = curCell.right;}
						else
						{prevCol.right = null;}
		
					}
				
					while(prevRow.col<col)
					{
						prevRow = prevRow.right;
					}
					if(prevRow.row < row)
					{						
						if(curCell.down != null)
						{
							prevRow.down = curCell.down;
						}
						else
						{
							prevRow.down = null;
						}
						
					}
				}
			}
				
		}
		
	}
 
	public void displayMatrix()
	{
		
		if(isEmpty())
		{
			System.out.println("Matrix is Empty");
		}
		else
		{
			Link curCell = first;
			
			
			do
			{	Link firstCol = curCell;
				while(curCell.right != null)
				{
					curCell.displayLink();
					curCell = curCell.right;		
					
				}
				curCell.displayLink();
				System.out.println("");
				curCell = firstCol.down;

				
			}while(curCell != null);
		}
	}
	
	
	
}

