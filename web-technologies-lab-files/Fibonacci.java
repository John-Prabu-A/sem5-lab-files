import java.util.Scanner;

class Fibonacci {

	static void PrintFibonacci(int n) {
		int a = -1;
		int b = 1;
		int c;
		while(n!=0) {
			c = a+b;
			System.out.println(c);
			a = b;
			b = c;
			n--;	
		}
	}

	public static void main(String args[]) {
		// 5.Write a java program to generate the first n terms of the Fibonacci sequence.
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = scanner.nextInt();
		PrintFibonacci(n);
	}
}
