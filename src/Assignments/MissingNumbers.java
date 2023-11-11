package Assignments;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MissingNumbers 
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the highest integer of the array (n)");
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
		boolean missing = true;
		
		for(int j = 1; j < n; j++)
		{	
			missing = true;
			for(int k = 0; k < arr.length; k++)
			{
				if(j == arr[k])
				{
					missing = false;
					break;
				}
			}
			if (missing == true)
			{
				System.out.print(j + " ");
			}
				
		}
			
	}

}
