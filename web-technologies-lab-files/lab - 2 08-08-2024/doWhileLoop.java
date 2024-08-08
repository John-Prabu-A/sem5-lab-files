import java.util.Scanner;

class DoWhileLoop {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		int n = 1;
		do {
			System.out.println(n);
			n++;
		} while(n <= num);

	}
}
