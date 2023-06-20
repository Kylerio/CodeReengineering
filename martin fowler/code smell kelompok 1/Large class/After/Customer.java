
public class Customer {
    private String name;
    private int age;
    private Credit Credit;

    public Customer(String n, int a, Credit credit) {
        this.name = n;
        this.age = a;
        this.Credit = credit;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Credit getCredit() {
        return Credit;
    }

    public boolean isAdult() {
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Credit: " + Credit.getAmount());
    }
}
