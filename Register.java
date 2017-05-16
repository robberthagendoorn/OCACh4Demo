import java.util.*;
import java.util.function.*;

public class Register {

	private static List<Person> register = new ArrayList<Person>();
	
	public static Person getPerson(String name) {
		for (Person person : register) {
			if (person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}

	public static Person getPerson(int num) {
		int idx = num - 1;
		if (idx < register.size()) {
			Person person = register.get(idx);
			return person;
		}
		return null;
	}
	
	public static List<Person> getRegister() {
		return register;
	}

	public static void addPerson(Person person) {
		register.add(person);
	}

	public static boolean removePerson(String name) {
		Person person = getPerson(name);
		return deletePerson(person);
	}

	public static boolean removePerson(int num) {
		Person person =getPerson(num);
		return deletePerson(person);
	}
	
	private static boolean deletePerson(Person person) {
		if (person != null) {
			register.remove(person);
			return true;
		}
		return false;
	}

}
