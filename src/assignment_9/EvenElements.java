package assignment_9;


public class EvenElements {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] input1 = {1, 2, 5, 8, 1, 2, 6, 9, 7, 4, 3, 5, 2, 2};
        int[] input2 = {1, 2, 1, 8, 2, 1, 9, 3, 2, 4};
        displayInput(input1);
        System.out.println("Output 1: " + findEvenElements(input1));
        displayInput(input2);
        System.out.println("Output 2: " + findEvenElements(input2));
	
        
	}
	
	public static String findEvenElements(int[] inputs)
	{
		EHashTable hash = new EHashTable(100);
		String result="";
		for(int i =0; i < inputs.length; i++)
		{
			if(hash.isExist(inputs[i]))
			{
				hash.increment(inputs[i]);
			}
			else
			{
				 EDataItem  data = new EDataItem(inputs[i]);
				 hash.insert(data);
						 
			}
				
		}
		result = hash.findEvenCount();
		return result;
	}
	public static void displayInput(int[] input)
	{		System.out.print("input: ");
		for (int i = 0; i < input.length; i ++)
		{
			System.out.print(input[i] + " ");
		}
		System.out.println();
		
	}

}

class EDataItem 
{
  private int iData;
  private int count = 0;

  public EDataItem(int ii) 
  {
    iData = ii;
    count = 1;
  }

  public int getKey() 
  {
    return iData;
  }
  public int getValue()
  {
	  return count;
  }
  
  public void incrementCount()
  {
	  count++;
  }

}

class EHashTable 
{
  private EDataItem[] hashArray;
  private int arraySize;
  private EDataItem nonItem;
  private int items = 0;

  public EHashTable(int size) 
  {
    arraySize = size;
    hashArray = new EDataItem[arraySize];
    nonItem = new EDataItem(-1);
  }

  public void displayTable() 
  {
    System.out.print("Table: ");
    for (int j = 0; j < arraySize; j++) 
    {
      if (hashArray[j] != null)
        System.out.print(hashArray[j].getKey() + " : " + hashArray[j].getValue()+" , ");
      else
        System.out.print("** ");
    }
    System.out.println("");
  }

  public int hashFunc(int key) 
  {
    return key % arraySize;
  }

  public void insert(EDataItem item) 
  {
   
    int key = item.getKey();
    int hashVal = hashFunc(key);
    int step = 1;
    while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) 
    {
      hashVal += step * step;
      step++;
      hashVal %= arraySize;
    }
    hashArray[hashVal] = item;
    this.items++;
  }

  public EDataItem delete(int key) 
  {
    int hashVal = hashFunc(key);
    int step = 1;
    while (hashArray[hashVal] != null) {
      if (hashArray[hashVal].getKey() == key) 
      {
        EDataItem temp = hashArray[hashVal];
        hashArray[hashVal] = nonItem;
        return temp;
      }
      hashVal += step * step;
      step++;
      hashVal %= arraySize;
    }
    return null;
  }

  public EDataItem find(int key)
  {
    int hashVal = hashFunc(key);

    int step = 1;
    while (hashArray[hashVal] != null) 
    {
    	int val = hashArray[hashVal].getKey();
      if ( val == key)
        return hashArray[hashVal];
      hashVal += step * step;
      step++;
      hashVal %= arraySize;
    }
    return null;
  }
  
  public String findEvenCount()
  {
	  StringBuilder result = new StringBuilder();
	  for(int i=0; i < arraySize; i++)
	  {
		  if (hashArray[i]!= null && hashArray[i].getValue()%2 == 0)
		  {
			  result.append(hashArray[i].getKey()).append(" ");
		  }
	  }
	  
	  return result.length() > 0 ? result.toString().trim() : "NONE";
  }
  public void increment(int key)
  {
	  int hashVal = hashFunc(key);

	    int step = 1;
	    while (hashArray[hashVal] != null) 
	    {
	    	int val = hashArray[hashVal].getKey();
	      if ( val == key)
	      {
	    	  hashArray[hashVal].incrementCount();
	      }
	       
	      hashVal += step * step;
	      step++;
	      hashVal %= arraySize;
	    }
	 
  }
  public boolean isExist(int key)
  {
	 
	  EDataItem check = this.find(key);
	  
	  if (check!=null)
	  {
		  return true;
	  }
	 
	  return  false;
  }





}
