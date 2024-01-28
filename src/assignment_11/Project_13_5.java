package assignment_11;
import java.io.*;


public class Project_13_5
{	
	public static void main(String[] args) throws IOException
	{
		KnightGraph theGraph = new KnightGraph();
		System.out.println("CREATED GRAPH");
		boolean solutionFound = false;
		theGraph.displayMatrix(theGraph.getAdjMat());
		for(int i = 0; i < KnightGraph.AREA; i++)
		{
		
			solutionFound = theGraph.dfs(i);
			if(solutionFound) 
				System.out.println("As Solution found starting at (" + (i/KnightGraph.SIZE) + ", " + (i%KnightGraph.SIZE) + ")");
			else
				System.out.println("No solution from (" + (i/KnightGraph.SIZE) + ", " + (i%KnightGraph.SIZE) + ")");
		}
	}	

}

class KnightStackX
{
	private int[] st;
	private int top;

	public KnightStackX() 
	{
		st = new int[KnightGraph.AREA]; 
		top = -1;
	}

	public void push(int j) 
		{
		st[++top] = j; 
		}

	public int pop() // take item off stack
		{
		return st[top--];
		}
	
	public int peek() // peek at top of stack
		{ 
		return st[top]; 
		}

	public boolean isEmpty() // true if nothing on stack-
		{ 
		return (top == -1); 
		}
	
	public boolean isFull()
		{
		return (top == st.length-1); 
		}
	
	public boolean oneItem() //is there only one item left in the stack?
		{
			return (top == 0);
		}

} // end class KnightStackX

//placed in Vertex to remember which vertices
//were visited from that Vertex
class VisitedStackX
{
	private int[] st;
	private int top;

	public VisitedStackX() // constructor
	{
		st = new int[8]; // make array
		top = -1;
	}

	public void push(int j) // put item on stack
		{ 
		st[++top] = j; 
		}

	public int pop() // take item off stack
		{ 
		return st[top--]; 
		}
	
	public int peek() // peek at top of stack
		{ 
		return st[top];
		}

	public boolean isEmpty() // true if nothing on stack-
		{ 
		return (top == -1);
		}
	
	public boolean isFull()
		{ 
		return (top == st.length-1);
		}

} // end class KnightStackX

class KnightVertex
{
	public char label; // label (e.g. ‘A’)
	public boolean wasVisited;
	public VisitedStackX justVisited;
	public int lastVisited;

	public KnightVertex() // constructor
	{ 
		label = '-';
		wasVisited = false; 
		justVisited = new VisitedStackX();
		lastVisited = -1;
	}

} // end class KnightVertex

class KnightGraph
{
	public static final int SIZE = 6;
	public static final int AREA = SIZE*SIZE;
	private KnightVertex vertexList[]; // list of vertices
	private int adjMat[][]; // adjacency matrix
	private int nVerts; // current number of vertices
	private KnightStackX theStack;

	public KnightGraph()
	{
		vertexList = new KnightVertex[AREA];
		adjMat = new int[AREA][AREA];
		nVerts = AREA;
		for(int j=0; j<SIZE; j++)
			for(int k=0; k<SIZE; k++)
				adjMat[j][k] = 0;
		theStack = new KnightStackX();
		
		
		for(int i = 0; i < AREA; i++)
			vertexList[i] = new KnightVertex();
		
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++)
				addPossibleMoves(i, j);
	}

	public void addPossibleMoves(int i, int j)
	{
		int currentRow = i*SIZE;
		int currentCol = j;
		int currentVertex = currentRow+currentCol;
		
		
		if(i-1>=0)
		{
			if(j-2>=0)
				addEdge(currentVertex, currentVertex-SIZE-2);
			if(j+2<SIZE)
				addEdge(currentVertex, currentVertex-SIZE+2);
		}
		if(i+1<SIZE)
		{
			if(j-2>=0)
				addEdge(currentVertex, currentVertex+SIZE-2);
			if(j+2<SIZE)
				addEdge(currentVertex, currentVertex+SIZE+2);
		}
		if(i-2>=0)
		{
			if(j-1>=0)
				addEdge(currentVertex, currentVertex-(SIZE*2)-1);
			if(j+1<SIZE)
				addEdge(currentVertex, currentVertex-(SIZE*2)+1);
		}
		if(i+2<SIZE)
		{
			if(j-1>=0)
				addEdge(currentVertex, currentVertex+(SIZE*2)-1);
			if(j+1<SIZE)
				addEdge(currentVertex, currentVertex+(SIZE*2)+1);
		}
	}
	
	
	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
	}

	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}
	
	public void displayBoard()
	{
		System.out.println("..................................");
		for(int i = 0; i < SIZE; i++)
		{
			for(int j = 0; j < SIZE; j++)
				System.out.print(vertexList[i*SIZE+j].label);
			System.out.println();
		}
		System.out.println("..................................");
	}

	
	public boolean dfs(int start) throws IOException 
	{ 
		vertexList[start].label = 'S'; 
		vertexList[start].wasVisited = true; 
		theStack.push(start); 
		while( !theStack.isEmpty() ) 
		{
			int m = theStack.peek();
			vertexList[m].label = 'M';
		
			
			if(theStack.isFull())	
			{
				for(int j=0; j<nVerts; j++) 
				{
					vertexList[j].wasVisited = false;
					vertexList[j].label = '-';
					vertexList[j].lastVisited = -1;
					while(!vertexList[j].justVisited.isEmpty())
						vertexList[j].justVisited.pop();
					KnightStackX winningMoves = new KnightStackX();
					while(!theStack.isEmpty())
						winningMoves.push(theStack.pop());
					while(!winningMoves.isEmpty())
						System.out.print(winningMoves.pop() + " ");
				}
				vertexList[0] = new KnightVertex();
				System.out.println();
				return true;
			}
			
			int v = getNextVertex( theStack.peek() );
			
			if(v == -1) 
			{
				int unmark = theStack.pop();
				vertexList[unmark].label = '-';
				vertexList[unmark].wasVisited = false;
				vertexList[unmark].lastVisited = -1;
				 
			}
			else 
			{
				vertexList[v].wasVisited = true; 
				int curVertex = theStack.peek();
				vertexList[curVertex].label = 'K';
				vertexList[curVertex].lastVisited = v;
				theStack.push(v); 
			}
		} 
		
		
		for(int j=0; j<nVerts; j++) 
		{	
			vertexList[j].wasVisited = false;
			vertexList[j].label = '-';
			vertexList[j].lastVisited = -1;
			while(!vertexList[j].justVisited.isEmpty())
				vertexList[j].justVisited.pop();
		}
		
		return false;
	} 

	public int getNextVertex(int v)
	{
		for(int j = vertexList[v].lastVisited+1; j < nVerts; j++)
			if(adjMat[v][j]==1 && vertexList[j].wasVisited == false) return j;
		return -1;
	}
	
	public void getChar() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
	}
	
	
	public int getAdjUnvisitedVertex(int v)
	{
		for(int j=0; j<nVerts; j++)
			if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
				return j;
		return -1;
	}
	
	
		public void unmarkVisited(int v)
		{
			while(!vertexList[v].justVisited.isEmpty())
			{
				int j = vertexList[v].justVisited.pop();
				vertexList[j].wasVisited = false;
				vertexList[j].label = '-';
			}
					
		}
	
	public int[][] getAdjMat()
	{ 
		return adjMat; 
	}
	
	public void displayMatrix(int[][] matrix)
	{
		for(int i=0; i<nVerts; i++)
		{
			for(int j=0; j<nVerts; j++)
				System.out.print(matrix[i][j]);
			System.out.println();
		}
	}
	
}
