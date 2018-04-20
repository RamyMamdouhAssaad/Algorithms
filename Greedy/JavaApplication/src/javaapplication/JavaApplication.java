/*
greedy choice : 
1. Sort all Sessions according to their finish line
2. Start by including the first Session found in your sorted set + assigning flag =1 (means it is added)
3. Use the recently added Sessions to compare with the other Sessions Start times .
4. countine until there is no more mutually compatible Sessions.
5. Then u can add a room
6. By that method u can activate minimum amount of rooms to a given number of sessions 
*/
package javaapplication;

import java.util.Scanner;


public class JavaApplication {

    public static void main(String[] args) {
    
       String SessionName;
       int SessionStartTime;
       int SessionFinishTime;
       int lastFinishTime;
       int numberOfSessions ; 
       int room=0 ;
       boolean change=false  ;
        
       
       Scanner inputScanner = new Scanner(System.in);
       System.out.println("please enter the number of sessions : ") ;
       numberOfSessions=inputScanner.nextInt(); 
       Session Sessions[] = new Session[numberOfSessions] ;
       
       // for loop for entering name,start-time and finish-time of Sessions 
       for(int i =0 ; i<numberOfSessions ; i++) 
       {
            System.out.println("please enter the name of the Session");
            SessionName = inputScanner.next();
            System.out.println("please enter Starting time of this session(24 hours format)");
            SessionStartTime = inputScanner.nextInt();
            System.out.println("please enter ending time of this session(24 hours format)");
            SessionFinishTime = inputScanner.nextInt();
           Sessions[i]=new Session(SessionName, SessionStartTime, SessionFinishTime);
           
        }
       
       
     /* nested loops for sorting Sessions by Finish TIme (bubble_sort) and comparing Start times after
     to find the correct solution when comparing finish with start time 
     */
       
       for(int i=0 ; i<numberOfSessions-1 ; i++)
        
       {
	
           for(int j= 0 ; j<numberOfSessions-1-i; j++)
		
           {
	
               if(Sessions[j].finishTime>Sessions[j+1].finishTime)//comparing finish time
		
               {
                
                int tempEnd =Sessions[j].finishTime;
		Sessions[j].finishTime=Sessions[j+1].finishTime ;
                Sessions[j+1].finishTime=tempEnd ; 
		
                int tempStart =Sessions[j].startTime;
                Sessions[j].startTime=Sessions[j+1].startTime ;	
                Sessions[j+1].startTime=tempStart ; 
                String tempName =Sessions[j].name;
                Sessions[j].name=Sessions[j+1].name ;
                Sessions[j+1].name=tempName ; 
			
               }
                        //if there are more than two that have the same finish time then compare 
                        //their start time 
                        
               if((Sessions[j].finishTime==Sessions[j+1].finishTime)&&(Sessions[j].startTime>Sessions[j+1].startTime))
                        
               {
                   int tempStart =Sessions[j].startTime;
                   Sessions[j].startTime=Sessions[j+1].startTime ;
	           Sessions[j+1].startTime=tempStart ; 
		   String tempName =Sessions[j].name;
		   Sessions[j].name=Sessions[j+1].name ;
		   Sessions[j+1].name=tempName ; 
                            
                       
               }
		
           }


       }
        
   
       Sessions[0].flag=1 ; //Session one is assigned to a specfic room
       lastFinishTime=Sessions[0].finishTime ; 
   
       for (int k=1 ;k<numberOfSessions ;k++)
   
       {
      
           change =false ; //change variable is to know whether there is a change in flags
         //change -> true -> Add that specific room that contain new assigned sessions
       
          if(k>1)//in order for every loop to start from begining to have the maximum amount of Sessions
        
          {
         
              lastFinishTime=0;    
        
          }
         
// Use the recently added Sessions to compare with the other Sessions Start times.
    
          for(int i =1 ; i<numberOfSessions; i++)
    
          {
        
       
              if((Sessions[i].startTime>=lastFinishTime) )
        
              {
        
                  if (Sessions[i].flag==0)//Session hasn't been taken yet 
          
                  {
                      Sessions[i].flag=1 ; //change flag =1 means that it is taken now
                      lastFinishTime=Sessions[i].finishTime ;
                      change = true ; //if any flag is changed ->true is assigned
           
                  }
           
                  else //nothing happens in(if)skip the current iteration
                  
                  {
               
                      continue ;
            
                  }
       
              }  
   
          }
    
          if (change==true)//assign a new room for the Sessions taken
   
          {
        
              room =room+1 ;
       
          }
 
       }
   
       
  
    System.out.println("number of rooms "+room) ; 
   
    }

}



