package Assignments;
import java.util.*;

public class FirstNonRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the string to be checked");
		
		Scanner  sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] c = s.toCharArray();
		
		boolean repeat = false;
		
		for (int i =0; i<c.length; i++) 
		{
			repeat = false;
			for(int j = 0; j < c.length; j++)
			{
				if (c[i] == c[j] && i!=j)
				{
					repeat = true;
					break;
				}
			}
			if(repeat == false)
			{
				System.out.println(c[i]);
				break;
			}
			if (i == c.length-1)
			{
				System.out.println("NULL");
			}
			
		}
		sc.close();
	}

}
