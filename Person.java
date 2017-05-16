public class Person{
    
    private String name;
    private String gender;
    private int age;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public boolean setName (String newName) {
        if (!newName.isEmpty() && newName != null) {
            name = newName;
			return true;
        }
		return false;
    }

    public boolean setGender(String newGender) {
		switch (newGender) {
			case "M":
				gender = "M";
				return true;
			case "F":
				gender = "F";
				return true;
			default:
				return false;
		}
    }

	public boolean setAge(int newAge) {
		if (newAge >= 0) {
			age = newAge;
		   	return true;	
		}
		return false;
	}
}
        
