package assignment6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
	private String name, phone;
	
	//creating a regular expression to check phone numbers for validity
	//checks for: if an area code exists, first digit cannot be 0 or 1, and dashes at correct positions
	final String regEx = "([0-9]{3}[-])?[2-9]{1}[0-9]{2}[-][0-9]{4}";
	
	public Contact(String n, String p) throws PhoneNumberException{
		setName(n);
		setPhone(p);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPhone(String phone) throws PhoneNumberException{
		//if inputted number matches with regular expression
		if(regexChecker(regEx, phone)){
			this.phone = phone;
		}
		//if input doesn't match regex, throw exception
		else{
			throw new PhoneNumberException("Invalid phone number. Check dashes and that N is not 0 or 1");
		}
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String toString(){
		return "\nName: " + name + "\nPhone Number: " + phone;
	}
	
	//compares input to the defined regular expression
	public boolean regexChecker(String regEx, String number){
		Pattern checkRegEx = Pattern.compile(regEx);
		
		Matcher regexMatcher = checkRegEx.matcher(number);
		
		return regexMatcher.matches();
	}
}
