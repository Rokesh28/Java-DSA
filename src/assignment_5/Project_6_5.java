package assignment_5;
import java.util.Scanner;

public class Project_6_5 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try (Scanner s = new Scanner(System.in))
		{
			System.out.println("Enter the group size: ");
			int groupSize = s.nextInt(); 
			System.out.println("Enter the team size: ");
			int teamSize = s.nextInt(); 
			
			
			Combination combi = new Combination(groupSize,teamSize);
			
			for(int i=1;i<=groupSize;i++)
			{
				combi.grp[i-1]=i;
			}
			
			int team[]=new int[teamSize]; 
			System.out.println("The possible team combinations are given below: ");
			combi.combinations(team, 0, 0);
		} 
		
	}

}

class Combination 
{ 
	
	int groupSize;
	int teamSize;
	int[] grp;

	
	public Combination(int grpSize, int tSize)
	{
	
		groupSize = grpSize;
		teamSize = tSize;
		grp = new int[grpSize];
		
	}
	
	public void combinations(int team[], int start, int index) 
	{ 
		  if (index == teamSize) 
		  { 
		      for (int j=0; j<teamSize; j++) 
		      {
		      	System.out.print(team[j]+" "); 
		      }
		  
		      System.out.println(""); 
		      return; 
		  } 
		  for (int i=start; i< groupSize && groupSize-i >= teamSize-index; i++) 
		  { 
		      team[index] = grp[i]; 
		      combinations(team, i+1, index+1); 
		  } 
	} 
	
}
