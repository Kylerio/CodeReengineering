public class Main {
    public static void main(String[] args) throws Exception {

        employee employee1 = new employee();
        employee1.setName("John");
        employee1.setGender("Male");
        employee1.setAge(26);
        employee1.setSalary(10000);
        employee1.salaryIncrease(100);
    
        employee1.display();
    }
}
