import java.util.Scanner;

class Else_CS {
	public static void main(String args[]) {
		// vote eligibility
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int age = sc.nextInt();

		//checking age >= 18
		if(age >= 18) {
			System.out.println("You are eligible to vote!");
		} else {
			System.out.println("You are not eligible to vote!");
		}
	}
}
