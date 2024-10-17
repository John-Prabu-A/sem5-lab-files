
// import java.lang.*;
import java.lang.StringBuffer;

// base class
class Vehicle {
	private String make;
	private String model;
	private int year;
	private StringBuffer str;

	// constructor
	public Vehicle(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.str = new StringBuffer("");
	}

	// getters and setters
	public String getMake() {
		return this.make;
	}

	public String getModel() {
		return this.model;
	}

	public int getYear() {
		return this.year;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	// display method
	public void displayInfo() {
		System.out.println("Make : " + make + "\n" + "Model : " + model + "\n" + "Year : " + year);
		str.reverse();
		System.out.println("Str : " + str);
		int cap = str.capacity();
		System.out.println("capacity : " + cap);
		String str2 = new String(str);
		System.out.println("Upper case : " + str2.toUpperCase());
		System.out.println("Lower Case : " + str2.toLowerCase());

		System.out.println("capacity : " + str2.length());
	}

	// start method overloading
	public void start() {
		System.out.println("Vehicle is Starting...");
	}

	public void start(String keyType) {
		System.out.println("Vehicle is Starting with a " + keyType + " key...");
	}
}

// derived class (inheritance)
class Car extends Vehicle {
	private int numOfDoors;

	// constructor
	Car(String make, String model, int year, int numOfDoors) {
		super(make, model, year);
		this.numOfDoors = numOfDoors;
	}

	// getter and setter for new property
	public int getNumOfDoors() {
		return this.numOfDoors;
	}

	public void setNumOfDoors(int n) {
		this.numOfDoors = n;
	}

	// override display method
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Number of Doors : " + numOfDoors);
	}
}

// deriver class (motor cycle)
class MotorCycle extends Vehicle {
	private boolean hasSideCar;

	// constructor
	MotorCycle(String make, String model, int year, boolean hasSideCar) {
		super(make, model, year);
		this.hasSideCar = hasSideCar;
	}

	// getter and setter for new property
	public boolean getHasSideCar() {
		return this.hasSideCar;
	}

	public void setHasSideCar(boolean h) {
		this.hasSideCar = h;
	}

	// override display info
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Has Side Car : " + (hasSideCar ? "YES" : "NO"));
	}
}

class ClassesAndObjects {
	public static void main(String args[]) {
		// creating obj
		Vehicle vehicle = new Vehicle("Genric", "Model", 2000);
		Car car = new Car("Toyota", "Camry", 2020, 4);
		MotorCycle motorCycle = new MotorCycle("Harley-Davidson", "Sportstar", 2024, true);

		// display method polymorphism
		vehicle.displayInfo();
		vehicle.start();
		vehicle.start("Electronic");

		System.out.println();

		car.displayInfo();
		car.start();

		System.out.println();

		motorCycle.displayInfo();
		motorCycle.start();
	}
}
