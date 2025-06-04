# Table of Contents
- [Choco-Data Center (Java)](#choco-data-center--java-)
- [Description of Actors](#description-of-actors)
- [Walkthrough Description](#walkthrough-description)
- [How to begin](#how-to-begin)
- [Reasons for creation of this project](#reasons-for-creation-of-this-project)
- [End of Project Review](#end-of-project-review)
- [Update](#update)


# Choco-Data Center (Java)


Hey, this is a University project for a Software Engineering class. Long story short, there is this company called Choc-An where they give therapeutic services for people addicted to chocolate. And we need to create a system for them that goes from checking in, service, bill, reports at the end of week and month

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
    You should be able to leave the "Center" once you are prompted back to the very begin and hit the number that results in termination of the code

# How to begin

Once you paste the code to your respective IDE, all you need is to run

There are instructions prompts that appear before every decision one can make on the command line of your IDE

# Reasons for creation of this project
 1. Team Collaboration : The class heavily stressed the key to learn how to code with other team members from readable code and coordination of tasks
 2. Modulation: In this project that involves a team and a reasonable size of code, subdividing and modulazing the work and code is key for it to be readable and debuggable
 3. SDLC: The class introduced the software development life cycle. The types of life cycles for various jobs and teams. Their advantages and limitations. Having a process from idea to project line. This involved using use case, activity, class & sequence diagrams. These diagrams allowed us to then proceed with coding the project

# End of Project Review
  Pro:
  
    1. The project stressed me to make my code readable for other teammates to read an understand what I was saying
    2. Seeing how other classmates wrote code , at times better than me, allowed me to improved my problem solving in situations involving debugging
    3. Earned 100/100

  Con:
  
    1. The collaboration was abit loose and up in the air until the few days before "Launch". So moving forward, I need to be more assertive in scheduling time frames and goals to reduce anxiety

# Update
      

