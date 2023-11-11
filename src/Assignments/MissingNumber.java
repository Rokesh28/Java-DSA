package Assignments;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MissingNumber {

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
		int len = arr.length;
		
		for (int j = 1; j< arr[len-1]; j++ )
		{
			 if (!BinarySearch(arr,j))
			 {
				 System.out.println(j);
				 break;
			 }
			 
		}
		
	}
	
	public static boolean BinarySearch(int[] arr, int x)
	{
		int l = 0;
		int r = arr.length;
		int m;
		
		while(l<=r)
		{	
			m = l + (r-l)/2;
			if (x == arr[m])
			{
				return true;
			}
			else if(x<arr[m])
			{
				r = m-1;
			}
			else
			{
				l= m+1;
			}
		}
		return false;
		
	}

}
