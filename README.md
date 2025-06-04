# Table of Contents
- [Choco-Data Center (Java)](#choco-data-center--java-)
- [Description of Actors](#description-of-actors)
- [Walkthrough Description](#walkthrough-description)
- [How to begin](#how-to-begin)


# Choco-Data Center (Java)


Hey, this is a University for a Software Engineering class. Long story short, there is this service called Choc-An where they give therapeutic services for people addicted to chocolate. I know weird case study!

# Description of Actors
Either way the idea was to create a system that have these Prime actors:

    Manager: The person can get collect summary reports and accounting report 
      ( As of 6/4/2025, this person is not in the project yet)
  
    Provider: The person doing the service 
 
    Customer:  The person being down the service on
 
    Data Center: Holds critical information (Name / Birth date / ID number( I keep calling it credentials so they are the same thing)
 
    Operator Terminal: Area where the operator can interact with the data center
  
# Walkthrough Description
The bare bone walkthrough scenario happens on the command Line:
    
     provider entering their credentials (type number when the prompt starts to)
     operator scans the customers credentials ( basically like the provider, enter their number credentials)
        -> If new customer (this will be prompted first just incase they are new), operator enters their credentials
        -> If existing, first the system checks if they have paid
            ---> If they have not, it prompts for a payment before continueing
            ---> If they have, it continues as usual
            
    Provider Directory showing what services are there will display
    The Customer then can choose their service
      ->They will receive a bill
    IF the customer or provider wants a summary report for a week, they will receive
    Every week on Friday, a weekly report of provider's services will be created and sent providers and manager 
        (Need to make sure it actually sends to the manager)
    Monthly report is also generated if needed

# How to begin

Once you paste the code to your respective IDE, all you need is to run

There are instructions prompts that appear before every decision one can make on the command line of your IDE

  
      

