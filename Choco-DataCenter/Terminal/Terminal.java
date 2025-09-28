package Terminal;

//Done by Stewart Ndung'u

import Member.Member;

import Provider.Provider;
import ProviderDirectory.ProviderDirectory;
import Service.Service;
import WeeklyReport.WeeklyReport;
import DataCenter.DataCenter;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Terminal {

	
	// Takes the string from the function call and checks in the DataCenter if it exists
	private static String providerLogin(String providerNumber) {
		
		//We should receive a boolean back, if it exists or not
		Scanner scanner = new Scanner(System.in);
		Boolean response= DataCenter.checkProviderLogin(providerNumber);
		//String newProviderNumber=providerNumber;
		while(true)
		{
			if(response == true)
			{
				//because its true, we reach into the provider's details to get the name and print it out as a welcome
				
			Provider provider= DataCenter.providers.get(providerNumber);
			String providerName=provider.getName() ;
			 System.out.println("Welcome " + providerName + "!\n");
			
			 break;
			}
			else
			{
				//error if not true and asks to type it again
				System.out.println("Number is Invalid! Please enter it again! ");
				providerNumber = scanner.nextLine();
				response= DataCenter.checkProviderLogin(providerNumber);	
				
				
			}
			
		}
		
		 return providerNumber;
	}
	
	// like providerLogin it checks if the member's ID number when swiped exists in the database
	private static int memberLogin(int memberNumber)
	{
		//We should receive a boolean back, if it exists or not
		Scanner scanner = new Scanner(System.in);
		int response= DataCenter.checkMemberLogin(memberNumber);
		while(true)
		{
			if(response == 1)
			{
				Member member= DataCenter.members.get(memberNumber);
				String memberName= member.GetName();
			 System.out.println("Welcome back " +memberName +"! You can proceed!\n");
			 break;
			}
			else if(response == 2)
			{
				System.out.println("Your Membership has been Suspended!");
				System.out.println("Enter 'Pay' to pay and proceed");
				String payAnswer=scanner.nextLine();
				while(true)
				{
					if(payAnswer.equals("Pay") || payAnswer.equals("pay") )
					{
						DataCenter.processMemberPayment(memberNumber);
						System.out.println("Thank You! for Your Payment & Continued Business !!\n");
						break;
					}
					else {
						System.out.println("Please Pay!!");
						payAnswer=scanner.nextLine();
						
					}
				}
				break;
			}
			else
			{
				System.out.println("Number is Invalid! Please enter it again! ");
				memberNumber = Integer.parseInt(scanner.nextLine());
				response= DataCenter.checkMemberLogin(memberNumber);	
				
				
			}
			
		}
		
		return memberNumber;
	}
	
	//procedure for adding a service
	public static Service setServiceDetails(Scanner scanner)
	{
		int memberId,newMemberId;
		double fee=0.0,consultations=0.0;
		String checkMemberId, memberName;
		System.out.println("\nEnter Service Details:");
        System.out.print("Date of Service (yyyy-MM-dd): ");
        String dateOfService = scanner.nextLine();
        
        //sends you to a provider directory to choose
        double[] result = ProviderDirectory.Directory(fee,consultations);
        fee = result[0];
       int Consultations= (int) result[1];
       
  	
        // reenter the provider number
        System.out.print("Enter Provider Number: ");
        String providerNumber = scanner.nextLine();
        //returns the number back espeially if it was changed because of incorrect number
        String newProviderNumber=providerLogin(providerNumber);
        Provider provider= DataCenter.providers.get(newProviderNumber);
        String providerId= provider.getNumber();
        
        //reenter member Id and take details
        System.out.print("Enter Member ID: ");
        checkMemberId=scanner.nextLine();
        while(true)
        {
	        try {
	        	memberId = Integer.parseInt(checkMemberId);
	        	newMemberId=memberLogin(memberId);
	          
	        	break;
	        }
	        catch(NumberFormatException e)
	   		{
	   			System.out.println("Please write a valid number!");
		    	   checkMemberId=scanner.nextLine();
	   			
	   		}
        }
        //returns back the member when logged in especially if the number was incorrect to begin with
        
        Member member = DataCenter.members.get(newMemberId);
        memberName= member.GetName();
        
        
        LocalDateTime receivedDateTime = LocalDateTime.now();
  
        // Add the service through DataCenter
        Service service = new Service(dateOfService, receivedDateTime, memberName, providerId, fee, Consultations);
        System.out.println("Service details: " + service);
       
		
		return service;
	}
	
	// function that takes the users input and puts it into the member object
	public static Member setMemberDetailsFromUser(Scanner scanner)
		{
			System.out.println("\nEnter Member Details:");
	        System.out.print("User ID: ");
	        String ID=scanner.nextLine();
	        int userID; 
	        //check if its an actual string
	        while(true)
		       {
			       try {
				        userID = Integer.parseInt(ID);
				       break;
			       }
			       catch(NumberFormatException e)
			       {
			    	  System.out.println("Invalid number, Try Again!");
			    	  ID = scanner.nextLine();
			    	  
			       }
		       }
	        
	        
	        System.out.print("Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Member/Provider (true for Member, false for Provider): ");
	        String answer= scanner.nextLine().toLowerCase();
	        boolean isMember ;
	        // checks to make sure it is a boolean answer
	        while(true)
		       {
			       if(answer.equals("true") || answer.equals("false"))
			       {
			    	   isMember = Boolean.parseBoolean(answer);
			    	   break;
			       }
			       else
			       {
			    	   System.out.println("Please enter true or false");
			    	   answer= scanner.nextLine().toLowerCase();
			    	   
			       }
		       }
	        
	        System.out.print("State: ");
	        String state = scanner.nextLine();
	        System.out.print("Zip Code: ");
	        String ZipCode=scanner.nextLine();
	        int zipCode;
	        
	        while(true)
		       {
			       try {
				        zipCode = Integer.parseInt(ZipCode);
				       break;
			       }
			       catch(NumberFormatException e)
			       {
			    	  System.out.println("Invalid number, Try Again!");
			    	  ZipCode = scanner.nextLine();
			    	  
			       }
		       }
	        
	        System.out.print("Address: ");
	        String address = scanner.nextLine();
	        System.out.print("City: ");
	        String city = scanner.nextLine();
	        System.out.print("You will receive a first month free\n");
	        Boolean paid= true;
	        
	        //userID, name, isMember, state, zipCode, address, city
	        Member member = new Member(userID, name, isMember, state, zipCode, address, city,paid); 
	        System.out.println("Member Details: " + member);
	        return member;
		}
	
	//procedure in adding a new Provider
	public static Provider setProviderDetailsFromUser(Scanner scanner) {
			
			// gets all the info
			System.out.println("Enter Provider Details:");
	        System.out.print("Name: ");
	        String providerName = scanner.nextLine();
	        System.out.print("Number: ");
	        String providerNumber = scanner.nextLine();
	        System.out.print("Street Address: ");
	        String providerStreetAddress = scanner.nextLine();
	        System.out.print("City: ");
	        String providerCity = scanner.nextLine();
	        System.out.print("State: ");
	        String providerState = scanner.nextLine();
	        System.out.print("Zip Code: ");
	        String providerZipCode = scanner.nextLine();
	        
	       // error checking to make sure it went through
	        Provider provider = new Provider(providerName, providerNumber, providerStreetAddress, providerCity, providerState, providerZipCode);
	       
	        System.out.println("Provider Details: " + provider);
	        
	        return provider;
			
		}
	
	
	public static void operationPortal() {
		
	}
	
	
	//a portal to enter the details for the provider or member and do a service
	public static void operatorPortal ()
	{
		// Ask if the the user wants to create a new user or use an existing
		Scanner scanner = new Scanner(System.in);
		System.out.println("If ENTERING a new Provider, type '1'");
		System.out.println("If ENTERING an existing Provider, type '2'");
		System.out.println("If REMOVING an existing Provider, type '3'");
		System.out.println("If UPDATING an existing Provider, type '4'\n");
		String firstAnswer=scanner.nextLine();
		
		int integer=Integer.MAX_VALUE;
	       
	       while(true)
	       {
	    	   
	    	   try {
	    		   integer =Integer.parseInt(firstAnswer);
	    		 //enter a new provider
			       if(integer == 1)
			       {
			    	   Provider provider = setProviderDetailsFromUser(scanner);
						DataCenter.addProvider(provider);
						System.out.println("Provider added successfully!");	
						System.out.println("Login the Provider in....\n");
			    	   break;
			       }
			       // enter an existing one: Check the DataCenter for the Pseudo's number
			       else if(integer==2)
			       {
			    	   System.out.println("Please enter your Provider Number : ");
						String providerNumber = scanner.nextLine();
						
						//takes the providerNUmber to the Datacenter to verify
						providerLogin(providerNumber);
						break;
			       }
			       else if(integer == 3)
			       {
			    	   System.out.println("Please enter your Provider Number that you want to remove : ");
						String providerNumber = scanner.nextLine();
						
						//takes the providerNumber to the Datacenter to delete
						DataCenter.deleteProvider(providerNumber);
						
						break;
			       }
			       else if(integer == 4)
			       {
			    	   System.out.println("Please enter your Provider Number you want to update : ");
						String providerNumber = scanner.nextLine();
						
						
						//takes the providerNUmber to the Datacenter to delete
						Provider provider = setProviderDetailsFromUser(scanner);
						DataCenter.updateProvider(providerNumber,provider);
						break;
			       }
			       else if(integer != 1 || integer != 2 || integer != 3 || integer != 4)
			       {
			    	   System.out.println("Please choose a valid option!");
			    	   firstAnswer=scanner.nextLine();
			       }
	   				}
		   		catch(NumberFormatException e)
		   		{
		   			System.out.println("Please choose a valid option!");
			    	   firstAnswer=scanner.nextLine();
		   			
		   		}
	    	 
	    		
			       
	       }
	       System.out.println("Do you want to start a service! (yes or no)");
    	   String reply= scanner.nextLine().toLowerCase();
		
	       while(true)
	       {
	    	  
	    	   if(reply.equals("yes"))
	    	   {
	    		   System.out.println("Great!, Let's enter a Member");
	    			System.out.println("If New Member, press '3'");
	    			System.out.println("If Existing Member, press '4'");
	    			String secondAnswer=scanner.nextLine();
	    			
	    			int integer2=Integer.MAX_VALUE;
	    		       
	    		       while(true)
	    		       {
	    		    	   //checks if secondAnswer is an integer
	    		    	   try {
	    		   			integer2 =Integer.parseInt(secondAnswer);
	    		   			//if its 3, then setup a new member
	    			   			if(integer2 == 3)
	    					       {
	    					    	   Member member = setMemberDetailsFromUser(scanner);
	    					    	   DataCenter.addMember(member);
	    								System.out.println("Member added successfully! \n");	
	    								System.out.println("Login the Member in....\n");
	    					    	   break;
	    					       }
	    					       // enter an existing one: Check the DataCenter for the Pseudo's number
	    					     else if(integer2 == 4)
	    					       {
	    					    	   System.out.println("Please enter your Member Number : ");
	    								String memberNumber=scanner.nextLine();
	    								int memberNumberAnswer=Integer.MAX_VALUE;
	    								
	    								//makes sure you entered an integer 
	    								while(true)
	    								{
	    									try {
	    										//if goes through, send to verify the login
	    										  memberNumberAnswer = Integer.parseInt(memberNumber);
	    										memberLogin(memberNumberAnswer);
	    										break;
	    							   				}
	    								   	catch(NumberFormatException e)
	    								   		{
	    								   		//it will keep asking until you enter the right option
	    									    	   System.out.println("Please enter a valid number!");
	    									    	   memberNumber=scanner.nextLine();							   			
	    								   		}
	    							
	    								}
	    								break;
	    								
	    					       }
	    			   			//If its a number but not the option numbers then ask again
	    					     else if(integer2 != 3 || integer != 4) {
	    					    	   System.out.println("Please choose a valid option!");
	    					    	   secondAnswer=scanner.nextLine();
	    					       }
	    		   			
	    		   				}
	    			   		catch(NumberFormatException e)
	    			   		{
	    			   		//it will keep asking until you enter the right option
	    				    	   System.out.println("Please choose a valid option!");
	    				    	   secondAnswer=scanner.nextLine();
	    			   			
	    			   		}
	    		    	
	    		       }
	    		   
	    		   System.out.println("Let's beginning your service! \n\n");
	    	       System.out.println("Service Completed! \n");
	    	       Service service= setServiceDetails(scanner);
	    	       DataCenter.addService(service);
	    	       System.out.println("\nThank you for your service!\n");
	    	       
	    	       break;
	    	   }
	    	   else if(reply.equals("no"))
	    	   {
	    		   // if you decline, then sends you back
	    		   System.out.println("That's all right\n");
	    		   break;
	    	   }
	    	   else
	    	   {
	    		   // it will keep until it gets the right option
	    		   System.out.println("Please enter a correct option\n");
	    		   reply= scanner.nextLine().toLowerCase();
	    	   }
	    	   
	       }
		
	
	       
		    
	   
	       
	}

	
	//Portal for a provider to ask for a report
	public static void providerReportPortal()
	{
	
		Scanner scanner = new Scanner(System.in);
		String providerNumber;
		
		System.out.println("Hello sole Provider \n");
	       System.out.println("Please enter your number!\n");
	        providerNumber = scanner.nextLine();
	     
	       providerLogin(providerNumber);
	       Provider provider= DataCenter.providers.get(providerNumber);
	       WeeklyReport weeklyReportProvider = new WeeklyReport();
	       System.out.println(weeklyReportProvider.providerGenerateReport(provider));
	       
	      // scanner.close();
	}
	
	//Portal for a member to ask for a report if manually at the office
	public static void memberReportPortal()
	{
		Scanner scanner = new Scanner(System.in);
		  System.out.println("Here is the sole Member \n");
	       System.out.println("Please enter your number!\n");
	       int memberNumber;
	       
	       while(true)
	       {
		       try {
			        memberNumber = Integer.parseInt(scanner.nextLine());
			       
			       
			       memberLogin(memberNumber);
			       Member member= DataCenter.members.get(memberNumber);
			       WeeklyReport weeklyReportMember = new WeeklyReport();
			       System.out.println(weeklyReportMember.memberGenerateReport(member));
			       break;
		       }
		       catch(NumberFormatException e)
		       {
		    	  System.out.println("Invalid number, Try Again!");
		    	  memberNumber = Integer.parseInt(scanner.nextLine());
		    	  
		       }
	       }
	       // scanner.close();
	}

	
	
}