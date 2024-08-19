import java.util.Scanner;

class DynamicInput {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter your Roll NO : ");
		int regNo = scanner.nextInt();

		System.out.println("Records:- ");
		System.out.println("Name : " + name);
		System.out.println("Roll No : " + regNo);
	}
}
