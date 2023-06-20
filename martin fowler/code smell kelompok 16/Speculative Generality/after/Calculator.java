public class Calculator {
    
    public static void divide(double num1, double num2, String operator){
        System.out.println(num1 / num2);
    }
  
    public static void multiply(double num1, double num2, String operator){
        System.out.println(num1 * num2);
    }
  
    public static void add(double num1, double num2, String operator){
        System.out.println(num1 + num2);
    }
  
    public static void subtract(double num1, double num2, String operator){
        System.out.println(num1 - num2);
    }
    
    public static void modulus(double num1, double num2, String operator){
        System.out.println(num1 % num2);
    }
    
    public static void main(String[] args) {
        Calculator.calculate(10, 5, "+"); 
        Calculator.calculate(10, 5, "-"); 
        Calculator.calculate(10, 5, "*"); 
        Calculator.calculate(10, 5, "/"); 
        Calculator.calculate(10, 5, "%"); 
        Calculator.calculate(10, 5, "$"); 
    }
}
