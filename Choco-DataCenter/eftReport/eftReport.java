package eftReport;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

//Done by Stewart Ndung'u
//edited by Alexander Gray


import java.util.List;

import DataCenter.DataCenter;
import Provider.Provider;
import Service.Service;

public class eftReport {
	
    
    //generate the eft file for each  month
    public static String generateEFTReport() {
        StringBuilder report = new StringBuilder();
        
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime startDate = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime endDate = endOfMonth;
        
        
        List<Provider> allProviders = DataCenter.getAllProviders(); 
        report.append("------- EFT Report for All Providers this Month -------\n\n");
      
        for(Provider provider : allProviders) {
        	 double Fee =0.0; 
        	
        	report.append(provider.toString()).append("\n");
        	
             
        	
             //get service of each provider
             List<Service> providerServices = DataCenter.getServicesForProvider(provider);
	        for (Service service : providerServices) {
	        	LocalDateTime serviceDateTime = LocalDateTime.parse(service.getDateOfService() + " 00:00", java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	        		//just adding up the fee amount of the services each provider had
	        	if(!serviceDateTime.isBefore(startDate) && !serviceDateTime.isAfter(endDate))
	        	{
	            Fee += service.getFee();
	        	}
	        }
	        
	        report.append(String.format("Total Amount for provider: $%-10.2f\n\n", Fee));
	     
	        
        }
        
        report.append("------- End of EFT Report for All Providers this Month -------\n\n");
        
        return report.toString();
    }
	
	
}
