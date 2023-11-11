package assignment_4;

public class problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MatrixIterator matrix = new MatrixIterator();
		int[] r1 = {1,2,3,4,5};
		int[] r2 = {6,7,8,9,10};
		int[] r3 = {11,12,13,14,15};
		int[] r4 = {16,17,18,19,20};
		
		
		matrix.insertrow(r1);
		matrix.insertrow(r2);
		matrix.insertrow(r3);
		matrix.insertrow(r4);
		System.out.println("Matrix after insertion of all elements with index shown in brackets");
		matrix.displayMatrix();
		System.out.println("");
		
		matrix.moveDown();
		int curCell = matrix.getCurrentValue();
		System.out.println("After MoveDown() Current Cell Value: " + curCell);
		matrix.moveDown();
		curCell = matrix.getCurrentValue();
		System.out.println("After MoveDown() Current Cell Value: " + curCell);
		matrix.moveRight();
		curCell = matrix.getCurrentValue();
		System.out.println("After MoveRight() Current Cell Value: " + curCell);
		matrix.moveRight();
		curCell = matrix.getCurrentValue();
		System.out.println("After MoveRight() Current Cell Value: " + curCell);
		matrix.moveLeft();
		curCell = matrix.getCurrentValue();
		System.out.println("After MoveLeft() Current Cell Value: " + curCell);
		matrix.moveUp();
		curCell = matrix.getCurrentValue();
		System.out.println("After Moveup() Current Cell Value: " + curCell);
		matrix.moveLeft();
		
		curCell = matrix.getCurrentValue();
		System.out.println("After MoveLeft()Current Cell Value: " + curCell);
		System.out.println("");
		matrix.ChangeCurrentValue(100);
		System.out.println("Matrix after changing the current cell value to 100");
		matrix.displayMatrix();
		System.out.println("");
		
		matrix.moveDown();
		curCell = matrix.getCurrentValue();
		System.out.println("After MoveDown() Current Cell Value: " + curCell);
		matrix.moveRight();
		curCell = matrix.getCurrentValue();
		System.out.println("After MoveRight() Current Cell Value: " + curCell);
		
		System.out.println("");
		matrix.removeCurrentValue();
		curCell = matrix.getCurrentValue();
		System.out.println("VAlue after after Removing Current Cell: " + curCell);
		System.out.println("Matrix after removing the current cell value");
		matrix.displayMatrix();
		System.out.println("");
		

	}

}

class Link2
{
	public int dData; // data item
	public Link2 right; // right link in matrix
	public Link2 down;
	public Link2 up; // up link in matrix
	public Link2 left;
	public int row;
	public int col;

	public Link2(int dd) // constructor
	{ 
		dData = dd;
		right = null;
		left = null;
		up = null;
		down = null;
		
	}
	public void displayLink() // display this link 
	{ 
		System.out.print(dData + "(" +  row + "," + col + ")  "); 
	}
	
}

class MatrixIterator
{
	private Link2 first;
	private Link2 current;
	
	public MatrixIterator()
	{
		first = null;
		current = null;
		
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	public void insertrow(int[] rData)
	{
		
			
		if (isEmpty())
		{
			Link2 curLink = new Link2(rData[0]);
			curLink.row = 1;
			curLink.col = 1;
			first = curLink;
			current = first;
			
			for(int i = 1; i< rData.length; i++)
			{
				Link2 rowLink = new Link2(rData[i]);
				curLink.right = rowLink;
				rowLink.left = curLink;
				curLink = rowLink;
				curLink.row = 1;
				curLink.col = i+1;
				
			}
			
		}
		else
		{	
			Link2 topLink = first;
			
			while(topLink.down != null)
			{
				topLink = topLink.down;
				
			}
			Link2 rowData = new Link2(rData[0]);
			topLink.down = rowData;
			rowData.up = topLink;
			rowData.row = topLink.row + 1;
			rowData.col = topLink.col;
			topLink = topLink.right;
			
			
			for(int j=1;j<rData.length;j++)
			{
				Link2 rowLink = new Link2(rData[j]);
				topLink.down = rowLink;
				rowLink.up = topLink;
				rowData.right = rowLink;
				rowLink.left = rowData;
				rowLink.row = topLink.row + 1;
				rowLink.col = rowData.col+1;
				topLink = topLink.right;
				rowData = rowData.right;
			}
			
		}
		
	}
	
	public void moveUp() 
	{
        if (current != null && current.up != null) 
        {
            current = current.up;
        }
    }

    public void moveDown() 
    {
        if (current != null && current.down != null)
        {
            current = current.down;
        }
    }

    public void moveLeft() 
    {
        if (current != null && current.left != null) 
        {
            current = current.left;
        }
    }

    public void moveRight()
    {
        if (current != null && current.right != null)
        {
            current = current.right;
        }
    }
	
    public int getCurrentValue() 
    {
        if (current != null)
        {
            return current.dData;
        }
        return -1; // Special value to indicate empty cell
    }
    public void ChangeCurrentValue(int value) 
    {
        if (current != null) 
        {
            current.dData = value;
        }
    }
    public void removeCurrentValue()
    {
        if (current != null) {
            current.dData = -1; // Reset the value to -1 to indicate an empty cell
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
			Link2 curCell = first;
			Link2 prevRow = first;
			Link2 prevCol = first;
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
			Link2 curCell = first;
			
			
			do
			{	Link2 firstCol = curCell;
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

