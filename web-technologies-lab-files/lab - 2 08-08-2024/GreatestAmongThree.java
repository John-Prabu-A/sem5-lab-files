import java.util.Scanner;

class GreatestAmongThree {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		System.out.print("Enter three numbers: ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		if(a > b && a > c) {
			System.out.println("Max : "+ a);
		} else if(b > c) {
			System.out.println("Max : "+ b);
		} else {
			System.out.println("Max : "+ c);
		}
	}
}
