package Company;

public class Person {
    private String name;
    private int age;
    private Address home;

    public Person(String name, int age, Address home, int salary) {
        this.name = name;
        this.age = age;
        this.home = home;
    }
    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public Address gethome(){
    	return home;
    }   
    public class Address {
    	private String street;
        private String city;
        private String state;
        private String zipCode;
    
    
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
}
}
