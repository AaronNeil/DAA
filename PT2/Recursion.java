package PT2;

public class Recursion {
    
    public static int factorial(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int number = 5; // Example number
        int result = factorial(number);
        System.out.println("The factorial of " + number + " is: " + result);
    }
}
