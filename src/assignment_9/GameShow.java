package assignment_9;

public class GameShow 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Testcase1 : ");
		String input = "jerry,35;bob,91;jerry,43;Eric,83";
		System.out.println("The players and their score: " + input);
	    String winner = findWinner(input);
	    System.out.println("Winner of competition: " + winner);
	    System.out.println("Testcase2 : ");
		input = "bob,65;jerry,55;Eric,98;jerry,44";
		System.out.println("The players and their score: " + input);
		winner = findWinner(input);
	    System.out.println("Winner of competition: " + winner);
	    
	     
		
		 
		
	}


	private static String findWinner(String input)
	{
		
	
	    // Split input into individual scores
	    String[] scoreEntries = input.split(";");
	    GameHashTable scores = new GameHashTable(getPrime(2*scoreEntries.length));
	    
	    // Process each score entry
	    for (String entry : scoreEntries) {
	        String[] parts = entry.split(",");
	        String name = parts[0];
	        int score = Integer.parseInt(parts[1]);

	 
	     // Update the cumulative score for each participant
	        if (scores.isExist(name))
	        {
	        	score += scores.find(name).getValue();
	        	scores.delete(name); // removing old value
	        }
	        GameDataItem aDataItem = new GameDataItem(name,score);
	        scores.insert(aDataItem);
	    } 
	
	    // Find the participant with the highest cumulative score
	    String winner = scores.findMaxScore();

	    return winner;
	}
	
	 private static int getPrime(int min)
	  {
	    for (int i = min + 1; true ; i++) 
	    {
	      if (isPrime(i))
	      {
	        return i;
	      }
	    }
	  }

	  private static boolean isPrime(int n) 
	  {
	    for (int i = 2; i*i <= n; i++) 
	    {
	      if (n%i == 0) 
	      {
	        return false;
	      }
	    }
	    return true;
	  }
}




class GameDataItem 
{
  public String name;
  public int score;

  public GameDataItem(String nn ,int ii) 
  {
	name = nn;
    score = ii;
  }

  public String getKey() 
  {
    return name;
  }
  
  public int getValue()
  {
	  return score;
  }

}

class GameHashTable 
{
  private GameDataItem[] hashArray;
  private int arraySize;
  private GameDataItem nonItem;
  private int items = 0;

  public GameHashTable(int size) 
  {
    arraySize = size;
    hashArray = new GameDataItem[arraySize];
    nonItem = new GameDataItem("Del",-1);
  }

  public void displayTable() 
  {
    System.out.print("Table: ");
    for (int j = 0; j < arraySize; j++) 
    {
      if (hashArray[j] != null)
        System.out.print(hashArray[j].getKey() + " ");
      else
        System.out.print("** ");
    }
    System.out.println("");
  }
  
  public int hashFunc3(String key) 
  {
//	  int hashVal = 0;
//	  for(int j=0; j<key.length(); j++)
//	  {
//	  int letter = key.charAt(j) - 96; 
//	  hashVal = (hashVal * 27 + letter) % arraySize;
//	  }
//	  return hashVal;
	  
//	  int hashVal = 0; 
//	  int pow27 = 1;
//	  for(int j=key.length()-1; j>=0; j--) 
//	  {
//	  int letter = key.charAt(j) - 96; 
//	  hashVal += pow27 * letter;
//	  pow27 *= 27;
//	  }
//	  return hashVal % arraySize;
//	  
	  int hashVal = key.charAt(0);
      for(int j=1; j<key.length(); j++) 
      {
    	  int letter = key.charAt(j); 
    	  hashVal = hashVal * 27 + letter;
    	  }
      
      return hashVal % arraySize; 
    }	

  public int hashFunc(int key) 
  {
    return key % arraySize;
  }

  public void insert(GameDataItem item) 
  {
  
    String key = item.getKey();
    int hashVal = hashFunc3(key);
    int step = 1;
    while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != "Del") 
    {
      hashVal += step * step;
      step++;
      hashVal %= arraySize;
    }
    hashArray[hashVal] = item;
    this.items++;
  }

  public GameDataItem delete(String key) 
  {
    int hashVal = hashFunc3(key);
    int step = 1;
    while (hashArray[hashVal] != null) {
      if (hashArray[hashVal].getKey() == key) 
      {
    	  GameDataItem temp = hashArray[hashVal];
        hashArray[hashVal] = nonItem;
        return temp;
      }
      hashVal += step * step;
      step++;
      hashVal %= arraySize;
    }
    return null;
  }

  public GameDataItem find(String key)
  {
    int hashVal = hashFunc3(key);

    int step = 1;
    while (hashArray[hashVal] != null) 
    {
    	String name = hashArray[hashVal].getKey();
      if (hashArray[hashVal].getKey() == name)
        return hashArray[hashVal];
      hashVal += step * step;
      step++;
      hashVal %= arraySize;
    }
    return null;
  }
  
  public boolean isExist(String key)
  {
	 
	  GameDataItem check = this.find(key);
	  
	  if (check!=null)
	  {
		  return true;
	  }
	 
	  return  false;
  }
	  
  
  public String findMaxScore()
  {
	  int maxScore = -10000;
	  String winner ="";
	  for (int i = 0; i < arraySize; i++) 
	  {
		  if (hashArray[i] != null && hashArray[i].getValue() > maxScore) 
		  {
	            maxScore = hashArray[i].getValue();
	            winner = hashArray[i].getKey() + "," + maxScore;
	        }
		  else if (hashArray[i] != null && hashArray[i].getValue() == maxScore)
		  {
			  winner += hashArray[i].getKey()+ "," + maxScore;
		  }
	  }
	  
	  return winner;
  }
  
 


}
