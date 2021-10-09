
package test;
import java.util.*;


class Solution
{
	
	Vector<Integer> pair;
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	
	public int planTrip(int[] moneyDistributed, int numPairs , int[][] coldWarMembers) 
    {
		int totalCllectedAmount=0;
    	for(int i = 0; i < numPairs; i++)
        {
    		pair=new Vector<Integer>();
    		for(int j = 0; j <2; j++)
    		{
    			
    			pair.add(coldWarMembers[i][j]);
    		}	
    	
    		getMoney(moneyDistributed,pair);
    	}
    	
//    	System.out.println("Iterating Hashmap...");  
    	   for(Map.Entry m : map.entrySet())
    	   {    
//    	    System.out.println(m.getKey()+" "+m.getValue());  
    	    totalCllectedAmount=totalCllectedAmount+(int) m.getValue();
    	   } 
    	   
    	   // get un pair value from all pairs
    	   int counter=1;
    	   boolean flag=false;
    	   for(int i = 0; i < numPairs; i++)
           {
       			for(int j = 0; j <2; j++)
	       		{		
	       			if(counter==coldWarMembers[i][j]){
	       				
	       			}
	       			else
	       			{
	       				flag=true;
	       				break;
	       			}
	       			
	       		}	
       			counter++;
       	  }
    	   if(flag==true)
    	   {
//    	   System.out.print("Unpair value is");
//    	   System.out.print(moneyDistributed[counter]);
    	   totalCllectedAmount=totalCllectedAmount+moneyDistributed[counter];
    	   }
    	   else
    	   {
    		   System.out.print("Unpair value not found");
        	      
    	   }
    	   
    	return totalCllectedAmount;
    }

	private void getMoney(int [] moneyDistributed, Vector<Integer> pair ) 
	{
		
		
			if(moneyDistributed[pair.get(0)-1]>moneyDistributed[pair.get(1)-1])
			{   
				if(!map.containsKey(pair.get(0)-1))
				map.put(pair.get(0),moneyDistributed[pair.get(0)]);
			}
			else
				if(!map.containsKey(pair.get(1)-1))
				map.put(pair.get(1)-1,moneyDistributed[pair.get(1)-1]);
		}
		
	}


public class Main
{
    static Scanner s = new Scanner(System.in);
    public static int[] takeInput(String input)
    {
        if (input.length() == 0) {
          return new int[0];
        }
        String[] parts = input.split(" ");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++)
        {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    public static void main(String[] args)
    {
        String line = s.nextLine();
        int[] moneyDistributed = takeInput(line.trim());
        int numPairs = s.nextInt();
        int[][] coldWarMembers = new int[numPairs][2];
        for(int i = 0; i < numPairs; i++)
        {
            coldWarMembers[i][0] = s.nextInt();
            coldWarMembers[i][1] = s.nextInt();
        }

        System.out.print("total collected money is "+new Solution().planTrip(moneyDistributed, numPairs , coldWarMembers));
    }
}
