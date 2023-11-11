package Assignments;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class FindRange {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the size of the array (n):");
		int n = scanner.nextInt();
		int arr[] = new int[n];
		String[] strgNum;
		
		System.out.println("Enter the array elements seperated by a single space");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		strgNum = br.readLine().split(" ");
		
		for(int i = 0; i < strgNum.length; i++) 
		{
			arr[i] = Integer.parseInt(strgNum[i]);
		}
		int maxi = Max(arr);
		int mini = Min(arr);
		
		if(n<2)
		{
			System.out.println("Can't find range with single number, try with more than 1 number in the array!");
		}
		else
		{
			System.out.println(maxi - mini);
		}
		
		
	}
	
	public static int Max(int[] arr)
	{
		int maxi = arr[0];
		
		for(int i = 1; i< arr.length; i++)
		{
			maxi = Math.max(maxi, arr[i]);
		}
		return maxi;
	}
	public static int Min(int[] arr)
	{
		int mini = arr[0];
		
		for(int i = 1; i< arr.length; i++)
		{
			mini = Math.min(mini, arr[i]);
		}
		return mini;
	}
	

}
