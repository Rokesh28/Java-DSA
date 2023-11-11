package Assignments;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SecondMaxMin {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		String[] strgNum;
		System.out.println("Enter the array elements seperated by a single space");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		strgNum = br.readLine().split(" ");
		int n = strgNum.length;
		int arr[] = new int[n];
		for(int i = 0; i < strgNum.length; i++) 
		{
			arr[i] = Integer.parseInt(strgNum[i]);
		}
		if(n<2)
		{
			System.out.println("Try again with more than two numbers!");
		}
		else
		{
		
			int Smax = SecondMax(arr);
			int Smin = SecondMin(arr);
			
			if(Smax != -1)
			{
				System.out.println("Second Max: "+ Smax);
				System.out.println("Second Min: "+ Smin);
			}
			else
			{
				System.out.println("Second Max: NULL");
				System.out.println("Second Min: NULL");
				
			}
		}
		
		

	}
	
	public static int SecondMax(int[] arr)
	{
		int maxi = Math.max(arr[0], arr[1]);
		int Smaxi = Math.min(arr[0], arr[1]);
		
		for (int i=2; i<arr.length; i++ )
		{
			if(maxi < arr[i])
			{
				Smaxi = maxi;
				maxi = arr[i];
			}
			else if (Smaxi == maxi)
			{
				Smaxi = arr[i];
			}
		}
		
		if (maxi == Smaxi)
		{
			return -1;
		}
		
		return Smaxi;
	}
	
	public static int SecondMin(int[] arr)
	{
		int mini = Math.min(arr[0], arr[1]);
		int Smini = Math.max(arr[0], arr[1]);
		
		for (int i=2; i<arr.length; i++ )
		{
			if(mini > arr[i])
			{
				Smini = mini;
				mini = arr[i];
			}
			else if (Smini == mini)
			{
				Smini = arr[i];
			}
		}
		
		if (mini == Smini)
		{
			return -1;
		}
		
		return Smini;
	}

}
