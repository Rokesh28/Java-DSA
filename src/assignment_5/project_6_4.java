package assignment_5;

class Knapsack
{
	int length;
    int[] weights;
    
    public Knapsack()
    {
    	length = 0;
    }

    public boolean knapsackSol(int startIndex,int target)
    {
        if(weights[startIndex]==target){
            System.out.print(weights[startIndex] + " ");
            return true;
        }
         else{
             if(weights[startIndex]<target){

                 for(int i=startIndex+1; i<length; i++){   
                     boolean value = knapsackSol(i,target-weights[startIndex]);

                     if(value){
                         System.out.print(weights[startIndex] + " ");
                         return true;
                         
                     }
                 }
                 
             }
         }
         
         return false;   
     } 
    
    public void displayWeightsGiven()
    {
    	for(int i = 0; i< weights.length; i++)
    	{
    		 System.out.print(weights[i] + " ");
    	}
    }
    
}

public class project_6_4 
{

   
    public static void main(String args[])
    {
    	Knapsack knapSack = new Knapsack();
    	
    	int[][] testCaseWeights = {{5, 3, 2, 7},{11, 8, 7, 6, 5}};
    	int[] testcaseTargets = {10,20};
    	
    	for(int tcNum=0; tcNum<testCaseWeights.length;tcNum++)
    	{
    		knapSack.weights = testCaseWeights[tcNum];
        	knapSack.length = knapSack.weights.length;

        	System.out.println("Test Case Number : " + (tcNum+1));
            System.out.println("The weights in the input array are given bellow:");
            knapSack.displayWeightsGiven();
            System.out.println();
            System.out.println("The target weight of the KnapSack : " + testcaseTargets[tcNum]);

            System.out.println();
            System.out.println("All possible combinations of weights to meet the target is/are given bellow:");
            for(int i=0; i< knapSack.length; i++)
            {
                boolean sol = knapSack.knapsackSol(i,testcaseTargets[tcNum]);
                if(sol)
            	{
                	System.out.println();
            	}
            }
            System.out.println();
            System.out.println();
            
    	}
            
    }

}
