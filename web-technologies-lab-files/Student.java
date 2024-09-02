import java.util.Scanner;

class Student {
	/*
	 * 
	 * 7.Create a Student class with attributes like name, roll number, and marks in different subjects.
	 * Implement methods to calculate total marks, percentage, and grade.
	 *
	 */
	String name;
	int rollNumber;
	int marks[] = new int[5]; // assuming there are five subjects
	
	public int TotalMarks() {
		int sum = 0;
		for(int mark : marks) {
			sum += mark;
		}
		return sum;
	}

	public float Percentage() {
		return TotalMarks() / 5.0f;
	}

	public String Grade() {
		float markPercentage = Percentage();
		if(markPercentage >= 90) {
			return "O";
		} else if(markPercentage >= 80) {
			return "A+";
		} else if(markPercentage >= 70) {
			return "A";
		} else if(markPercentage >= 60) {
			return "B+";
		} else if(markPercentage >= 50) {
			return "B";
		} else return "C";
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter num of Students : ");
		int n = scanner.nextInt();
		Student students[] = new Student[n];
		scanner.nextLine();
		for(int i =0; i < n; i++) {
			students[i] = new Student();
			System.out.print("Enter Student " + (i+1) + " Name: ");
			students[i].name = scanner.nextLine();
			System.out.print("Enter Student " + (i+1) + " Rollnumber: ");
			students[i].rollNumber = scanner.nextInt();
			System.out.print("Enter marks for all the five subjects: ");
			for(int j = 0; j < 5; j++) {
				students[i].marks[j] = scanner.nextInt();
			}
			scanner.nextLine();
		}
		
		//calculating and displaying total marks, percentage, and grade
		System.out.println(String.format("%-10s %-13s %-10s", "TotalMarks", "Percentage(%)","Grade"));
		for(int i = 0; i < n; i++) {
			System.out.printf("%-10s %-13s %-10s\n",students[i].TotalMarks(), students[i].Percentage(), students[i].Grade());
		}
	}
}
