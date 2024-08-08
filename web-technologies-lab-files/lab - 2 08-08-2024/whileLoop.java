import java.util.Scanner;

class WhileLoop {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int n = sc.nextInt();
		int num = n;
		long sum = 0;
		while(num != 0) {
			sum += num;
			num--;
		}
		System.out.println("Sum of " + n + " natural numbers is " + sum);
	}
}
