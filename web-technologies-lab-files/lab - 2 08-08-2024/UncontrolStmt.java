import java.util.Scanner;

class UncontrolStmt {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a num to end loop : ");
		int end = sc.nextInt();
		System.out.print("Enter a num to skip it's multiples : ");
		int skip_factor = sc.nextInt();

		int i = 0; 
		while (true){
			i++;
			if(i == end + 1) break;
			if(i % skip_factor == 0) continue;
			System.out.println(i);
		}
	}
}
