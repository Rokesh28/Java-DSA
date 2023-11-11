package assignment_3;
import java.io.*;
/*
 * Note:
 * Assumption: Inputs are given without space in infix.
 * Method Used here: Converting the infix equation to postfix --> Then parseing it to evaluate.
 * Consideration: Multi-digit numbers are considered in this. - Used Space to differentiate number 1 and (11 )eleven.
 * Postfix expression contains space to differentiate multi-digit numbers. 
 */

public class ArithmeticCalculator 
{
	// input in infix --> postfix --> Evaluate 
	//using space to differentiate multi digit numbers.
	
	public static void main(String[] args)  throws IOException
	{
		// TODO Auto-generated method stub
		String input, output;
		int result;
		while(true)
		{
			System.out.print("Enter the algebric value in Infix: ");
			System.out.flush();
			input = getString(); // read a string
			if(input.equals("")) // quit if [Enter]
				break;
			// make a translator 
			InToPost theTrans = new InToPost(input);
			output = theTrans.doTrans(); // do the translation 
			System.out.println("Postfix is " + output); 
			
			input = output;// read a string from kbd 
			if( input.equals("") ) // quit if [Enter]
				break;
			// make a parser 
			ParsePost aParser = new ParsePost((input));
			result = aParser.doParse(); // do the evaluation 
			System.out.println("Evaluates to " + result + '\n');
		} // end while

	}
	public static String getString() throws IOException 
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

}
class StackCal
{
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackCal(int s) // constructor
	{
	maxSize = s;
	stackArray = new char[maxSize]; 
	top = -1;
	}
	
	public void push(char j) // put item on top of stack
	{ 
		stackArray[++top] = j; 
		
	}
	
	public char pop()
	{
		return stackArray[top--];
	}
	
	public char peek() // peek at top of stack 
	{ 
		return stackArray[top]; 
	}
	
	public boolean isEmpty() // true if stack is empty
	{ 
		return (top == -1);
	}
	
	public int size() // return size 
	{ 
		return top+1; 
	}
	
	public char peekN(int n) // return item at index n
	{ 
		return stackArray[n]; 
	}
	
	public void displayStack(String s)
	{
		System.out.print(s); 
		System.out.print("Stack (bottom-->top): "); 
		for(int j=0; j<size(); j++)
		{
			System.out.print( peekN(j) ); 
			System.out.print(' ');
		}
		System.out.println("");
		}
}

class InToPost // infix to postfix conversion
{
	private StackCal theStack; 
	private String input; 
	private String output = "";
	
	public InToPost(String in) // constructor
	{
	input = in;
	int stackSize = input.length(); 
	theStack = new StackCal(stackSize*2); 
	}
	
	public String doTrans() // do translation to postfix 
	{
		for(int j=0; j<input.length(); j++)
		{
			char ch = input.charAt(j); 
			//theStack.displayStack("For switch(ch)"+ch+" ");
			if(ch >= '0' && ch <= '9')
			{
				StringBuilder num = new StringBuilder();
                while (j < input.length() && (Character.isDigit(input.charAt(j)))) //checking for multi-digit number.
                {
                    num.append(input.charAt(j));
                    j++;
                }
                j--; // Move back one position
                output = output + num.toString() + " ";
			}
			else
			{
			switch(ch)
				{
				case '+': 
				case '-':
					gotOper(ch, 1);
					break; 
				case '*': 
				case '/':
					gotOper(ch, 2);
					break; 
				case '(':
					theStack.push(ch);
					break; 
				case ')':
					gotParen(ch);
					break; 
				default:
					output = output + ch;
					break;
				}
			}
		}
		
		while( !theStack.isEmpty() ) // pop remaining opers
		{
		//theStack.displayStack("While "); // *diagnostic* 
		output = output + theStack.pop(); // write to output 
		}
		//theStack.displayStack("End "); // *diagnostic* 
		return output;
		
	}
	
	public void gotOper(char opThis, int prec1)
	{
		while( !theStack.isEmpty() )
		{
			char opTop = theStack.pop();
			if( opTop == '(' ) 
			{
				theStack.push(opTop); 
				break;
			}
			else {
				int prec2;
								
				if(opTop=='+' || opTop=='-') // find new op prec 
					prec2 = 1;
				else
					prec2 = 2;
				if(prec2 < prec1) 				// if prec of new op less 
					{							// than prec of old 
					theStack.push(opTop); 		// save newly-popped op 
					break;
					}
				else 							// prec of new not less
					output = output + opTop; 		// than prec of old 
			
				}
				
		}
		theStack.push(opThis);
	
	}
	
	public void gotParen(char ch)
	{
		while( !theStack.isEmpty() )
		{
			char chx = theStack.pop();
			if( chx == '(' )
			{
				break;
			}
			else
			{
				output = output + chx;
			}
		}
		
	}
	

}
class StackCalInt
{
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public StackCalInt(int s) // constructor
	{
	maxSize = s;
	stackArray = new int[maxSize]; 
	top = -1;
	}
	
	public void push(int j) // put item on top of stack
	{ 
		stackArray[++top] = j; 
	}
	
	public int pop()
	{
		return stackArray[top--];
	}
	
	public int peek() // peek at top of stack 
	{ 
		return stackArray[top]; 
	}
	
	public boolean isEmpty() // true if stack is empty
	{ 
		return (top == -1);
	}
	
	public int size() // return size 
	{ 
		return top+1; 
	}
	
	public int peekN(int n) // return item at index n
	{ 
		return stackArray[n]; 
	}
	
	public void displayStack(String s)
	{
		System.out.print(s); 
		System.out.print("Stack (bottom-->top): "); 
		for(int j=0; j<size(); j++)
		{
			System.out.print( peekN(j) ); 
			System.out.print(' ');
		}
		System.out.println("");
		}
}


class ParsePost
{
	private StackCalInt theStack; 
	private String input;
	
	public ParsePost(String s)
	{ 
		input = s;
	}
	
	public int doParse() 
	{
		theStack = new StackCalInt(100); 
		char ch;
		int j;
		int num1, num2, interAns = 0;
		for(j=0; j<input.length(); j++) 
		{
			ch = input.charAt(j); 
			//theStack.displayStack(""+ch+" ");
			if(ch >= '0' && ch <= '9')
			{
				StringBuilder num = new StringBuilder();
                while (j < input.length() && (Character.isDigit(input.charAt(j)))) //checking for multi-digit number.
                {
                    num.append(input.charAt(j)); 
                    j++;
                }
                j--; // Move back one position
     
				theStack.push((Integer.parseInt(num.toString()))); 
			}
			else if (ch == ' ')
			{
				continue;
			}
			else
			{
				num2 = theStack.pop(); 
				num1 = theStack.pop(); 
				switch(ch)
				{
					
					case '+':
						interAns = num1 + num2;
						break; 
					case '-':
						interAns = num1 - num2;
						break;
					case '*':
						interAns = num1 * num2;
						break; 
					case '/':
						interAns = num1 / num2;
						break; 
					default:
						interAns = 0;
				}
				theStack.push(interAns);
			}
		
		}
		interAns = theStack.pop(); 
		return interAns;
	}

}


