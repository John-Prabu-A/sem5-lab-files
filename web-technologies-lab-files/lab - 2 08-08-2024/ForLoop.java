import java.util.Scanner;

class ForLoop {
	public static void main(String args[]) {
		// Finding Factorial
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number between (0 - 10): ");
		int num = sc.nextInt();

		if(num >= 0 && num <= 10) {
			int result = 1;
			for(int i = 2; i <= num; i++) {
				result *= i;
			}
			System.out.println("Factorial of " + num + " is " + result);
		} else {
			System.out.println("Invalid Input!");
		}
	}
}
