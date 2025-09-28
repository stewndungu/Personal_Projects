package ProviderDirectory;

import java.util.Scanner;



public class ProviderDirectory
{
	/*
	class thePair
	{
		double Fee;
		int consultationNumber;
		
		public  thePair (double Fee, int consultationNumber) {
			this.Fee=Fee;
			this.consultationNumber = consultationNumber;
			
		}
	}
	*/
	public static void providerDirectory()
	{
		System.out.println("Here are the options for you to choose from");
		System.out.println("Here are the Service Options");
	   	System.out.println("Residential treatment $79.99          : Press '1'");
	   	System.out.println("Outpatient treatment  $89.99          : Press '2'");
	   	System.out.println("Medication-assisted treatment $101.99 : Press '3'\n\n");
	}
	
	//When entering the service details, this will pop up for the provider to choose from
	public static double[] Directory(double Fee, double consultationNumber)
		{
	   	String Answer;
	   	int integer;
	   	double newFee = 0.0,newConsultation=0.0;
	   	Scanner scanner =new Scanner(System.in);
	   	System.out.println("Here are the Service Options");
	   	System.out.println("Residential treatment $79.99          : Press '1'");
	   	System.out.println("Outpatient treatment  $89.99          : Press '2'");
	   	System.out.println("Medication-assisted treatment $101.99 : Press '3'");
	   	Answer=scanner.nextLine();
	   	while(true)
	   	{
		   	try
		   	{
		   		integer =Integer.parseInt(Answer);
		   		
		   		if(integer == 1)
		   		{
		   			System.out.println("Thank you for your Selection");
		   			
		   			newFee = 79.99;
		   			newConsultation = 110;
		   			break;
		   			
		   			
		   		}
		   		else if(integer == 2)
		   		{
		   			System.out.println("Thank you for your Selection");
		   			newFee = 89.99;
		   			newConsultation = 120;
		   			break;
		   		}
		   		else if(integer == 3)
		   		{
		   			System.out.println("Thank you for your Selection");
		   			newFee =101.99;
		   			newConsultation = 130;
		   			break;
		   		}
		   		else
		   		{
		   			System.out.println("Please enter an option");
		   			Answer=scanner.nextLine();
		   		}
		   	}
		   	catch(NumberFormatException e)
		   	{
		   		System.out.println("Please try again");
		   		Answer=scanner.nextLine();
		   	}
	   	}
	   	return new double[]{newFee,newConsultation};
			
		}

	
		
}
   