import java.util.*;
import java.lang.*;

public class HCF {
	public static int gcd(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;

		if(a == b) return a;
		if(a > b) return gcd(a - b, b);
		else return gcd(a, b - a);
	}
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 2 numbers to find GCD:");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int result = gcd(num1, num2);
		System.out.println("HCF of " + num1 + " and " + num2 + " is " + result);
	}
}
