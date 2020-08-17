package assignment6;

import java.util.Scanner;

public class ContactBuilder {	
	public static void main(String[] args) throws PhoneNumberException{
		Scanner scan = new Scanner(System.in);
		
		String name, number;
		int count = 0;
		String input = "y";
		
		//array for storing 10 contacts
		Contact[] contacts = new Contact[10];		
		
		//continues until array is full or user ends input
		while(input.equals("y")){
			System.out.println("Enter the contact's name: ");
			name = scan.nextLine();
			
			System.out.println("Enter the contact's phone number: \nUse format Nxx-xxxx or XXX-Nxx-xxxx, N cannot be 0 or 1");
			number = scan.nextLine();
			
			//try object to see if input is legal
			try{
				Contact c = new Contact(name, number);
				contacts[count] = c;
				
				//will only output success if contact creation does not throw an exception beforehand
				System.out.println("Contact successfully created!");
			}
			
			catch(PhoneNumberException e){
				System.out.println(e.getMessage());
			
				//deletes value from the array and resets the count
				contacts[count] = null;
				count--;
				System.out.println("Invalid contact has been deleted.");
			}
			
			count++;
			
			//makes sure contacts array stays in bounds
			if(count == 10){
				System.out.println("\nMaximum number of contacts stored.\n");
				break;
			}
			
			System.out.println("\nWould you like to add another contact? [y/n]");
			input = scan.nextLine();
		}
		
		System.out.println("List of contacts:");
		//prints all contacts in the array, returns null for an empty value
		for(int i = 0; i<contacts.length; i++){
			
			//checks if contact exists before printing it
			if(!(contacts[i] == null)){
				System.out.println(contacts[i]);
			}
		}
	}
}