import java.io.Console;
import java.util.*;

public class RegisterManipulator {
	
	private static Console cons = System.console();

	private	static String showOptions() {
	
		String input = cons.readLine("\n What would you like to do? \n \n \t 1. Get register \n \t 2. Get details \n \t 3. Add person \n \t 4. Remove person \n \t 5. Quit program \n");
		return input;
	}

	private static boolean performAction(String selection) {
		switch (selection) {
			case "1":
				displayRegister(Register.getRegister());
				return true;
			case "2":
				getDetails();				
				return true;
			case "3":
				Register.addPerson(createPerson());
				return true;
			case "4":
				deletePerson();
				return true;
			case "5":
				return false;
			default: 
				System.out.println("Please select one of the available options");
				return true;
		}
	}

	private static void displayRegister(List<Person> register) {
		for (int i = 0; i < register.size(); i++) {
			int num = i + 1;
			System.out.println("\n" + num + ". " + register.get(i).getName());
		}	
	}

	private static void getDetails() {
		String pers = cons.readLine("\n Which person would you like to get the details from? \n");
		boolean success = false;
		if (isNumber(pers)) {
			success = showDetails(Integer.parseInt(pers));
		} else {
			success = showDetails(pers);
		}
		if (success == false) System.out.println("\n Person not found \n");
	}

	private static boolean showDetails(int num) {
		Person person = Register.getPerson(num);
		return displayDetails(person);
	}

	private static boolean showDetails(String name) {
		Person person = Register.getPerson(name);
		return displayDetails(person);
	}

	private static boolean displayDetails(Person person) {
		if (person != null) {
			System.out.print("\nName: " + person.getName() + " \n");	
			System.out.print("Gender: " + person.getGender() + "\n");
			System.out.print("Age: " + person.getAge() + "\n");
			return true;
		}
		return false;
	}

	private static Person createPerson() {
		boolean valid = true;
		Person newPerson = new Person();

		do {
			String name = cons.readLine("\n What is the person's name? \n");
			valid = newPerson.setName(name);
			if (valid == false) System.out.println("\n Please enter a name");
		} while (valid == false);

		do {
			String gender = cons.readLine("\n What is the person's gender (M/F)? \n");
			valid = newPerson.setGender(gender);
			if (valid == false) System.out.println("\n Please enter either M or F");
		} while (valid == false);

		do {
	   		String ageString = cons.readLine("\n What is the person's age? \n");	
			int age = Integer.parseInt(ageString);
			valid = newPerson.setAge(age);
			if (valid == false) System.out.println("\n Please enter a positive number");
		} while (valid == false);

		return newPerson;
	}	

	private static void deletePerson() {
		String del = cons.readLine("\n Which person would you like to delete? \n");
		boolean success = false;
		if (isNumber(del)) {
			success = Register.removePerson(Integer.parseInt(del));
		} else {
		   	success = Register.removePerson(del);
		}
		if (success == false) System.out.println("\n Person not found \n");
	}

	private static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static boolean start() {
		String selection = showOptions();
		return performAction(selection);
	}

	public static void main(String[] args) {
		boolean keepGoing = true;
		do {
			keepGoing = start();
		} while (keepGoing);
	}	
}
