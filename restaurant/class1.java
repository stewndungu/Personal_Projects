package class1;

import java.util.Scanner;

import java.util.ArrayList;

import java.util.*;


public class class1 {

	static ArrayList<String>itemName = new ArrayList<String>();
	static ArrayList<String>itemNume = new ArrayList<String>();
	static ArrayList<Integer> itemCode = new ArrayList<Integer>();
	static ArrayList<Integer>itemCude = new ArrayList<Integer>();
	static ArrayList<Float> itemPrice = new ArrayList<Float>();
	static ArrayList<Float> itemPruce = new ArrayList<Float>();
	static ArrayList<Integer> itemQty = new ArrayList<Integer>();
	static ArrayList<Integer> itemQyy = new ArrayList<Integer>();
	static ArrayList<String> itemDescription = new ArrayList<String>();
	
	static ArrayList<String> basketName = new ArrayList<String>();
	static ArrayList<String> basketNume = new ArrayList<String>();
	static ArrayList<Integer> basketCode = new ArrayList<Integer>();
	static ArrayList<Integer>basketCude = new ArrayList<Integer>();
	static ArrayList<Float> basketPrice = new ArrayList<Float>();
	static ArrayList<Float> basketPruce = new ArrayList<Float>();
	static ArrayList<Integer> basketQty = new ArrayList<Integer>();
	static ArrayList<Integer> basketQyy = new ArrayList<Integer>();
	static ArrayList<String> basketDescription = new ArrayList<String>();
	
	
	

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		itemName.add("Pepperoni Pizza 12in");
		itemPrice.add((float) 9.99);
		itemCode.add(0);
		itemDescription.add("This is our signature freshly made pizza. Pick from Pepperoni, Cheese, Vegetarian, or Deep Dish pizzas");
		
		itemName.add("Vegan Pizza 12in");
		itemPrice.add((float) 11.39);
		itemCode.add(1);
		itemDescription.add("Our Vegetarian");
		
		itemName.add("Deep Dish Pizza 12in");
		itemPrice.add((float) 10.59);
		itemCode.add(2);
		itemDescription.add("try our 2in thick pizza");
		
		itemName.add("Juicy Medium Rare Steak" );
		itemPrice.add((float) 12.59);
		itemCode.add(3);
		itemDescription.add("Try our juicy steak");
		
		itemName.add("Premium Veggie Burger");
		itemPrice.add((float) 15.99);
		itemCode.add(4);
		itemDescription.add("Try our 100% plant based burgers");
		
		itemNume.add("Coke     ");
		itemPruce.add((float) 2.19);
		itemCude.add(0);
		
		
		itemNume.add("Fanta    ");
		itemPruce.add((float)     2.19);
		itemCude.add(1);
		
		itemNume.add("Water    ");
		itemPruce.add((float)     0.99);
		itemCude.add(2);
		
		itemNume.add("Heineken 440 ML");
		itemPruce.add((float)5.99);
		itemCude.add(3);
		
		itemNume.add("Guiness 440 ML" );
		itemPruce.add((float) 5.99);
		itemCude.add(4);
		
		
		
	
		
		
		
		
		
		
		
		Scanner input= new Scanner (System.in);
		String Customer,Neme,Nume;
		double Joes;
		int num1, num2, answer,answer2, answer3;
		int  tempItemQty, tempItemCode, tempItemCude, tempItemQyy;
		float Cust, Cost,boost,amount,SubTotal;
		
	
		
		

		//Asking the user their name
		System.out.println("Welcome to the LeNoir.");
		
		System.out.println("What is your name?");
		Customer= input.nextLine();
		
		//the board
		System.out.println(Customer +  ", Please look and Choose a seat or seats (Space each individual number)");
		
		
			String board [][] = {  {  "XX",  "01", "02",  "XX",  "04",  "05",  "06"},
								   {  "10",  "11", "12",  "13",  "14",  "XX",  "16"},
								   {  "20",  "21", "22",  "23",  "24",  "25",  "26"},
								   {  "30",  "XX", "32",  "XX",  "34",  "35",  "36"},
								   {  "XX",  "41", "42",  "43",  "44",  "45",  "46"},
								   {  "50",  "51", "52",  "53",  "XX",  "55",  "XX"}};


		
		while(true) {
			// displays the board
			for (int O=0; O < 6; O++) {
				for(int K=0; K < 7; K++) {
					System.out.print(board[O][K] + "|_|");
				}
				System.out.println();
			}
			// user can enter the number
			num1=input.nextInt();
			num2=input.nextInt();
			//decides if the seat is occupied or not. If not, the seat is occupied. If so, asks to choose another seat 	 
			if((board[num1][num2]) != "XX" ) {
				 board[num1][num2]="XX";
				 System.out.println("Thank you,"+ Customer+". Please head to your seat.");
				 
				 //will display the board
					  System.out.println("Here is the menu!");
				System.out.println();
					System.out.println("Menu:                   Price:  Code:\tDescription\t");
					
					
						for(int N=0; N<itemName.size(); N++) {	
							System.out.println(itemName.get(N) + "\t"+itemPrice.get(N)+ "\t"+ itemCode.get(N) +"\t:"+itemDescription.get(N));
						}
						System.out.println();
						System.out.println("Drinks:         Price:  Code");
						
						for(int P=0; P < itemNume.size();P++) {
						System.out.println(itemNume.get(P)+"\t"+itemPruce.get(P)+"\t"+itemCude.get(P));
						}
						// Asks the Customer their order 
				
						while (true) {
						
							System.out.println("What would you like to eat today! ( Enter the code for the food)");
							tempItemCode=input.nextInt();
							
							System.out.println("How many?");
							tempItemQty=input.nextInt();
							
							basketCode.add(tempItemCode);
							basketName.add(itemName.get(tempItemCode));
							basketQty.add(tempItemQty);
						    basketPrice.add(tempItemQty * itemPrice.get(tempItemCode));
							Cost= (tempItemQty * itemPrice.get(tempItemCode));
							Neme=(itemName.get(tempItemCode));
							
							// displays their food
							System.out.println("Code\t:Name:\t\tPrice: Quantity");
							for( int U=0; U<basketName.size(); U++) {
							System.out.println(basketCode.get(U) + "\t" + basketName.get(U) + "\t:" + basketPrice.get(U) + "\t" + "\t" + basketQty.get(U));
							}
						
							System.out.println("What to drink? (Enter the code for a drink");
							tempItemCude=input.nextInt();
							
							System.out.println("How many?");
							tempItemQyy=input.nextInt();
							
							basketCude.add(tempItemCude);
							basketNume.add(itemNume.get(tempItemCude));
							basketQyy.add(tempItemQyy);
							basketPruce.add(tempItemQyy * itemPruce.get(tempItemCude));
							Cust= (tempItemQyy * itemPruce.get(tempItemCude));
							Nume=(itemNume.get(tempItemCude));
							
							//displays their drinks
							System.out.println("Code\t:Name\t\tPrice:  Quantity");
							for( int G=0; G<basketNume.size(); G++) {
							System.out.println(basketCude.get(G) + "\t" + basketNume.get(G) + "\t:" + basketPruce.get(G) + "\t" + "\t" + basketQyy.get(G));
							}
							
							boost= Cost + Cust;
							
							// Asks for confirmation. If not, it returns back to ask to their order
							System.out.println("is this the confirmed order? (Yes=3) (No=4)");
							answer2=input.nextInt();
							while (answer2 == 3) {
								//Adds their order and produces a receipt
								System.out.println("The true total price is"+"\t"+(boost)+"\t"+"For"+"\t"+Neme+"\t"+"&"+"\t"+Nume);
								System.out.println("Please enter the payment amount");
								amount=input.nextFloat();
								
								SubTotal= amount- boost;
								while(amount > boost) {
								// checks if the payment was paid in full or not
								System.out.println("Your change is" +"\t" + SubTotal);
								System.out.println();
								System.out.println("Your receipt");
								System.out.println( "The Customer:" + Customer);
								System.out.println("Seat #:"   + num1 + num2);
								System.out.println(Neme +"\t:" + Cost); 
								System.out.println(Nume +"\t:" + Cust);
								System.out.println("Total"+"\t"+ boost);
								System.out.println("Paid" +"\t"+ amount);
								System.out.println("Change"+"\t" + SubTotal);
								
								System.out.println();
								System.out.println("Thank You for eating at LeNoir");
								System.out.println();
								System.out.println("Have a Nice day!");
								return;
								} if (amount < boost){
									System.out.println("You are short in payment. Please pay in full!");
									continue;
								}
								return;
							} if(answer2 == 4) {
								//Returns back to asking for an order
								continue;
							
							}
							
						}
							
								
							
				  
	
	
				  }
					else{
						// Asks for another seat
				 System.out.println("Sorry, that seat is not available. Please choose another seat.");
				   
				  }
		}
		}
				
		

		
			
		
	
		
	}

		
	


