package WeeklyReport;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import Provider.Provider;
import Member.Member;
import Service.Service;
import DataCenter.DataCenter;

// Done by Clark Potter
// edited by Stewart Ndung'u

public class WeeklyReport{
	
	
    
   

    // Add service to the weekly report has been moved to DataCenter
    /*
    public void addService(Service service) {
        services.add(service);
    }
	*/
    
    //List the services of the providers has been added by Stewart Ndung'u
    // Calculate total fee for the week
    /*
    public double calculateTotalFee() {
        double total = 0.0;
        for (Service service : services) {
            total += service.getFee();
        }
        return total;
    }
*/
    // Getters and setters have been moved to DataCenter
    /*
    public Provider getProvider() {
        return provider;
    }

    public List<Service> getServices() {
        return services;
    }
	*/
	
	
	///THis is the summary Week Report make sure it only does for a week 
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        
        //sets that the end of the week is on Friday so Saturday - Friday
        DayOfWeek  dayOfWeek =DayOfWeek.FRIDAY;
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime nextTargetDay = now.with(TemporalAdjusters.nextOrSame(dayOfWeek));
		LocalDateTime endDate = nextTargetDay;
		LocalDateTime startDate = endDate.minusWeeks(1);
        
        
        List<Provider> allProviders = DataCenter.getAllProviders(); 
        report.append("------- Summary Report for All Providers -------\n\n");
        
        // Print Provider details
        double totalFee = 0.0;
        int totalConsultations = 0, numberOfProviders= 0 ;
        for(Provider provider : allProviders) {
        	 double Fee =0.0; 
        	 int Consultations = 0;
        	report.append(provider.toString()).append("\n");
        	 report.append("\nServices Provided:\n");
             
        	
             //get service of each provider
             List<Service> providerServices = DataCenter.getServicesForProvider(provider);
	        for (Service service : providerServices) {
	        	
	        	//this will compare services within the week it is called upon
	        	LocalDateTime serviceDateTime = LocalDateTime.parse(service.getDateOfService() + " 00:00", java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	        	if(!serviceDateTime.isBefore(startDate) && !serviceDateTime.isAfter(endDate))
	        	{
	            report.append(service.toString()).append("\n");
	            Fee += service.getFee();
	            Consultations++;
	        	}
	        }
	        
	        report.append(String.format("Total Fee for provider: $%-10.2f\n", Fee));
	        report.append(String.format("Total Consultations   : " + Consultations +"\n\n"));
	        totalFee +=Fee;
	        if(totalFee != 0.0) {
	        	numberOfProviders++;
	        }
	        
	        totalConsultations +=Consultations;
	        
        }
        // Print total fee for the week
        report.append(String.format("\n\n-- Total number of providers     : " + numberOfProviders));
        report.append(String.format("\n-- Total number of consultations : "+ totalConsultations));
        report.append(String.format("\n-- Total Fee for Week            : $%-10.2f --\n\n", totalFee));
        report.append("------- End of Summary Report for All Providers -------\n\n");

        return report.toString();
    }
    
    //Generate report for the sole Provider
    public String providerGenerateReport(Provider provider)
    {
    	StringBuilder report = new StringBuilder();
    	report.append("--- Weekly Report for Provider ---\n\n");
    	report.append(provider.toString()).append("\n\n");

    	List<Service> providerServices = DataCenter.getServicesForProvider(provider);
    	 double totalFee = 0.0;
    	 // go through each service that is attached to that provider
         for (Service service : providerServices) { 
             report.append(String.format("%-10s%-19s%-25s%-9s%-8.2f%-3d%n",
                     service.getDateOfService(), service.getReceivedDateTime(),
                     service.getMemberName(), service.getMemberNumber(),
                     service.getFee(), service.getConsultations()));
             totalFee += service.getFee();
         }

         report.append(String.format("\nTotal Fee for Week: $%10.2f\n", totalFee));
         
         report.append("--- End of Weekly Report for Provider ---\n\n");
    	
    	return report.toString();
    }
    
    //Generate report for the sole member
   
    public String memberGenerateReport(Member member)
    {
    	StringBuilder report = new StringBuilder();
    	List<Service> memberServices = DataCenter.getServicesForMember(member) ; 
    	 report.append("--- End of Services Report for Member ---\n\n");
    	 report.append(member.toString()).append("\n\n");
    	 
    	 double totalFee=0.0;
    	 
    	 for (Service service : memberServices) { 
    	
             report.append(String.format("%-10s%-19s%-25s%-9s%-8.2f%-3d%n",
                     service.getDateOfService(), service.getReceivedDateTime(),
                     service.getMemberName(), service.getMemberNumber(),
                     service.getFee(), service.getConsultations()));
             totalFee += service.getFee();
         }
    	 report.append(String.format("\nTotal Fee for Week: $%10.2f\n", totalFee));
         
         report.append("--- End of Weekly Report for Member ---\n\n");
    	
    	return report.toString();
    }
	
	
}


