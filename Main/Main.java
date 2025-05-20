//Done by Stewart Ndung'u
package Main;

import Terminal.Terminal;


import java.util.Scanner;
import DataCenter.DataCenter;
import ProviderDirectory.ProviderDirectory;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;






public class Main {
	

	
	public static void main(String[] args) {
		//Set task to weekly print the summary report every week
		
		 if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY)
		 {
			 DataCenter.Timer();
		 }
		 
		

		
        // Greetings 
		
    	Scanner scanner = new Scanner(System.in);
    	String selectionType;
       int integer=Integer.MAX_VALUE;
       while(true)
       {
       System.out.println("Welcome to ChocAn!");
       System.out.println("To exit                             '0' : Exit");
	   System.out.println("To begin the procedure              '1' : Operator Terminal");
	   System.out.println("To begin Summary report procedure   '2' : SummaryReport");
	   System.out.println("To begin Provider report procedure  '3' : ProviderReport");
	   System.out.println("To begin Member report procedure    '4' : MemberReport");	   System.out.println("To begin EFT report procedure       '5' : EFTprocedure");
	   System.out.println("To view Provider Directory          '6' : Provider Directory\n");
	   selectionType=scanner.nextLine();
       
	  
	       while(true)
	       {
	           try {
	               integer =Integer.parseInt(selectionType);
		               
		               break;
	           }
	           catch(NumberFormatException e) {
	        	   
	        	 //it will keep asking until you enter the right option
	        	   System.out.println("Please choose a valid option!");
	        	   
	        	   System.out.println("To exit                             '0' : Exit");
		    	   System.out.println("To begin the procedure              '1' : Operator Terminal");
		    	   System.out.println("To begin Weekly report procedure    '2' : WeeklyReport");
		    	   System.out.println("To begin Provider report procedure  '3' : ProviderReport");
		    	   System.out.println("To begin Member report procedure    '4' : MemberReport");
		    	   System.out.println("To begin EFT report procedure       '5' : EFTprocedure");
		    	   System.out.println("To view Provider Directory          '6' : Provider Directory\n");
		           selectionType=scanner.nextLine();
	           }
	          
	
		       
	       }
	       if(integer == 0)
	       {
	    	   break;
	       }
       else if(integer == 1)
	       {
	    	  
	    	   Terminal.operatorPortal() ;  
	       }
       else if(integer == 2)
	       {
	    	   
	    	   DataCenter.weeklyReportPortal() ;  
	       }
       else if(integer == 3)
	       {
	    	   
	    	   Terminal.providerReportPortal() ;  
	       }
       else if(integer == 4)
	       {
	    	   
	    	   Terminal.memberReportPortal() ;  
	       }
	   else if(integer == 5)
	       {
	    	   
	    	  DataCenter.EFTReportPortal() ;  
	       }
	   else if(integer == 6)
	       {
	    	   
	    	   ProviderDirectory.providerDirectory() ;  
	       }
     
       }

       
       scanner.close();
    }
	
}