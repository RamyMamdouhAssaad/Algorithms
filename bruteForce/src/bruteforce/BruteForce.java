/*
Brute Force : 
Find all possibilities but applying a constraint to limit the solutions to be compared later
ex: if there are 7 bricks and we need to choose 4 as the width hole  
so equation of all possibilities = 7-(4-1)=4
after getting all sums compare them and find the indexes corresponding to that sum 
 */

package bruteforce;

import java.util.Scanner;


public class BruteForce {

    public static void main(String[] args) {
  
       
        int numberOfPlanks,widthHole,brickHeight ;
        int minSum=Integer.MAX_VALUE ;
        int count ; 
        
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("please enter the number of planks in the fence : ") ;
        numberOfPlanks=inputScanner.nextInt(); 
        System.out.println("please enter width of the hole : ") ;
        widthHole=inputScanner.nextInt(); 
        int possibilities=numberOfPlanks-(widthHole-1) ;//equation of all possibilities
        int index[]=new int [widthHole] ; //index array [ width hole number] 
        int sum[]=new int [possibilities] ;
        
        
        plank planks[] = new plank[numberOfPlanks] ;
        System.out.println("enter the heights of the Planks consecutively");
       //intalization of the array of sum with 0        
        for(int i =0 ; i<possibilities; i++)
    
        {
        
            sum[i]=0 ; 
      
        }
        //inserting into planks class
     
        
        for(int i =0 ; i<numberOfPlanks ;i++)
       
        {
            brickHeight=inputScanner.nextInt() ; 
            planks[i]=new plank(brickHeight) ;
        
        }
       //nested loops for summation of each possibility 
        //
        for(int i =0 ; i<possibilities;i++)
       
        {
         
            for(int k=i ;k<widthHole+i ;k++ )
          
            {
           
                sum[i]=sum[i]+planks[k].height ;
           
            }
           
     
        
        }
       
      //comparing all sums 
      //if the required sum is found ->obtain indexes from it 
      
        for(int i =0 ;i<possibilities ; i++)
      
       {
          
           if(sum[i]<minSum)
         
           {
            
               minSum=sum[i] ;
               count = i ;
           
               for(int j =0 ; j<widthHole ; j++)
          
               {
             
                   index[j]=count ; 
                   count ++ ;
           
               }
            
          
           }
       
       }
       System.out.println("Minimum sum =  "+minSum+"  and the indexes are : ") ;
       
       
       
       for(int i =0 ; i<widthHole ; i++)//indexes
      
       {
        
           System.out.println(index[i]);
       
       }
       
       
    }
    
    
}
