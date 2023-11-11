package assignment_3;
import java.util.*;

public class EvenSubArrays
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Enter the number of testcases, T :");
		Scanner  sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		String[] s = new String[T];
		for (int p = 0; p<T; p++)
		{
			System.out.println("Enter the input number " + (p+1) + " :");
			s[p] = sc.nextLine();
		}
		
		int j  = 0;
		while(j < T)
		{
			
			String x = s[j];
			int len = x.length();
			boolean iterate = true;
			String result = "";
			while(len >= 1 && iterate)
			{
				result = "";
				int Icount = 0;
				
				for(int k = 0; k < x.length(); k++)
				{
					if(k == x.length()-1)
					{
						result+= x.charAt(k);	
					}
					else if (x.charAt(k) == '0' && x.charAt(k+1) == '0')
					{
						k++;
						Icount++;
						continue;
					}
					else if (x.charAt(k) == '1' && x.charAt(k+1) == '1')
					{
						k++;
						Icount++;
						continue;
					}
					else
					{
						result += x.charAt(k);
					}
					
					len = x.length();
					
				}
				x = result;
				if (result == "")
				{	result = "EMPTY";
					iterate = false;
				}
				else if (Icount == 0)
				{
					iterate = false;
				}
				
			}
			System.out.println("output of  input " + (j+1) + " :");
			System.out.println(result);
			j++;
		}	

	}

}
