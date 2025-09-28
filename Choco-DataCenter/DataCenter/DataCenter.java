package DataCenter;

//Template structure by Stewart Ndung'u
//Edited by Ferah Aloimany

import Provider.Provider;
import eftReport.eftReport;
import Member.Member;
import Service.Service;

import WeeklyReport.WeeklyReport;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;



public class DataCenter
{
	public static Map<String, Provider> providers;  
    public static Map<Integer, Member> members; 
    private static List<Service> services;
    
    // this is a pseudo provider; think of it as an admin that can be used to for checking
    static {
    	 providers = new HashMap<>();
    	 Provider pseudoProvider = new Provider(
                 "Pseudo ",
                 "9999",
                 "123 Fake St.",
                 "Anytown",
                 "CA",
                 "90210"
             );
    	 providers.put(pseudoProvider.getNumber(), pseudoProvider);
    }
    //pseudo member all ready in the database
    static {
    	members = new HashMap<>();
    	 Member pseudoMember = new Member(
    	            12345,
    	            "John Doe",
    	            true,  // Assuming 'true' means member, 'false' means provider
    	            "CA",
    	            90210,
    	            "1 Fake St.",
    	            "Anytown",
    	            true
    	        );
    	 members.put(pseudoMember.GetID(), pseudoMember);
    	 
    	 Member notPaidPseudoMember = new Member(
    			 
    			 12346,
    			 "James Doe",
    			 true,
    			 "NY",
    			 78920,
    			 "Somewhere",
    			 "Somecity",
    			 false

    			 );
    	 members.put(notPaidPseudoMember.GetID(), notPaidPseudoMember);
    	 
    }
    //Pseudo service in the list 
    static {
    	services= new ArrayList<>();
    	
    	 Service initialService = new Service(
    	            "2024-04-17",
    	            LocalDateTime.now(),
    	            "John Doe", 
    	            "9999",     
    	            100.0,
    	            101001
    	        );
    	        services.add(initialService);
    	
    }
   
    public  DataCenter() {
    	DataCenter.providers = new HashMap<>();
    	DataCenter.members = new HashMap<>();
    	DataCenter.services = new ArrayList<>();
      
    }
    
    
    // Deletes Provider
    public static void deleteProvider(String providerNumber) {
        providers.remove(providerNumber);
      
    }
   
    // Updates Provider
    public static void updateProvider(String providerNumber, Provider newProvider) {
        if (providers.containsKey(providerNumber)) {
            providers.put(providerNumber, newProvider);
        }
    }
    
    //adds a provider
    public static void addProvider(Provider provider)
    {
    	// checking that && !this.providers.containsKey(provider.getNumber())
    	 if (provider != null && !providers.containsKey(provider.getNumber())) {
             providers.put(provider.getNumber(), provider);
             System.out.println("Provider added: " + provider);
         } else if (provider == null) {
             System.out.println("Error: Cannot add Provider with no detail.");
         } else if (!providers.containsKey(provider.getNumber()))  {
             System.out.println("Error: Provider with number " + provider.getNumber() + " already exists.");
         }
    }
   
    //gets a provider
    public Provider getProvider(String providerNumber) {
    	//it was this.providers
        if (DataCenter.providers.containsKey(providerNumber)) {
            return DataCenter.providers.get(providerNumber);
        } else {
            System.out.println("Error: Provider with number " + providerNumber + " not found.");
            return null;
        }
    }

    
    //gets all the providers
    public static List<Provider> getAllProviders() {
    	//checks if the prvider is empty
        if (providers.isEmpty()) {
            System.out.println("Warning: No providers found.");
            return new ArrayList<>(); 
        } else {
            return new ArrayList<>(providers.values());
        }
    }

    //adds a member
    public static void addMember(Member member) {
        if (member != null && !members.containsKey(member.GetID())) {
            members.put(member.GetID(), member);
            System.out.println("Member added: " + member);
        } else if (member == null) {
            System.out.println("Error: Cannot add null Member.");
        } else {
            System.out.println("Error: Member with ID " + member.GetID() + " already exists.");
        }
    }

    //gets the member
    public Member getMember(int memberId) {
    	//it was this.members
        if (DataCenter.members.containsKey(memberId)) {
            return DataCenter.members.get(memberId);
        } else {
            System.out.println("Error: Member with ID " + memberId + " not found.");
            return null;
        }
    }

 // Process Member Payment //edit to make sure it
    public static void processMemberPayment(int memberId) {
        Member member = members.get(memberId);
        if (member != null && !member.GetPaid()) {
            member.InvertPaid();
        }
    }
    
    // Service Operations
    public static void addService(Service service) {
        if (service != null) {
            services.add(service);
            System.out.println("Service added: " + service);
        } else {
            System.out.println("Error: Cannot add null Service.");
        }
    }

    //gets all the services for a specific provider
    public static List<Service> getServicesForProvider(Provider provider) {
        List<Service> providerServices = new ArrayList<>();
        if (provider != null) {
            for (Service service : services) {
                if (service.getMemberNumber().equals(provider.getNumber())) { // Assuming memberNumber in Service refers to Provider number
                    providerServices.add(service);
                }
            }
            if (providerServices.isEmpty()) {
                System.out.println("Warning: No services found for provider " + provider.getNumber());
            }
        } else {
            System.out.println("Error: Cannot get services for null Provider list.");
        }
        return providerServices;
    }
    
    //gets all the services done for a specific member
    public static List<Service> getServicesForMember(Member member)
    {
    	 List<Service> memberServices = new ArrayList<>();
    	 
    	 if(member != null)
    	 {
    		 for (Service service : services)
    		 {
    			 if( service.getMemberName().equals(member.GetName())) {
    				 memberServices.add(service);
    			 }
    		 }
    	 }
    	 if(memberServices.isEmpty())
    	 {
    		 System.out.println("Warning: No services for the member : " + member.GetName());
    		 
    	 }
    	 else {
             System.out.println("Loading Services for Member .....\n\n");
         }
    	return memberServices;
    }

   
    
    // At the end of each week (Saturday or friday) It goes and 
    public static void Timer()
    {
    	 System.out.println("Here is the Weekly Report");
	       WeeklyReport weeklyReport = new WeeklyReport();
	       System.out.println(weeklyReport.generateReport());
    }
    
  
    //initiates the EFt report and prints it
   public static void EFTReportPortal()
   {
	   System.out.println("Here is the EFT Report");
	   System.out.println(eftReport.generateEFTReport());
	   
   }
    //portal for provider to make a report
  	public static void weeklyReportPortal()
  	{
  		   System.out.println("Here is the Weekly Report");
  	       WeeklyReport weeklyReport = new WeeklyReport();
  	       System.out.println(weeklyReport.generateReport());
  	}

  	//checks provider login
  	public static Boolean checkProviderLogin(String Number)
		{
			
			if(providers == null)
			{
				System.out.println("Error: Providers is null");
				return false;
			}
			
			//check the number from the database we have
			//if true then return true back to the terminal and proceed
			//if false then return false back and ask again or enter new credentials
			else if(providers.containsKey(Number) != false)
			{
				return true;
			}
			else
				{
				System.out.println("Error: Provider with number " + Number + " not found.");
				return false;
			}
			
			
		}
	
  	//checks member login
	public static int checkMemberLogin(int Number)
		{
			if(members == null)
			{
				System.out.println("Error: Members is null");
				return 0;
			}
			else if(members.containsKey(Number) != false)
			{
				Member member =members.get(Number);
				if(member.GetPaid())
				{
					//yes the member paid!!!!
					return 1;
				}
				else
				{
					//BOO the member did not pay!
					System.out.println("Error: Member with ID " + Number + " has not paid!");
					return 2;
				}
				
			}
			else
				{
				
					System.out.println("Error: Member with number " + Number + " not found.");
					return 3;
				}
			
			
		}
		


}