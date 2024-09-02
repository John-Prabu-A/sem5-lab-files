class Addition {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    public static double add(double a, double b) {
        return a + b;
    }
    public static String add(String a, String b, String c) {
        return a + b + c;
    }
}

class Shape {
    public void draw() {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) 
                System.out.print(" *");
            System.out.println();
        }
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        for(int i = 0; i < 5; i++) {
            for(int j = i; j < 5; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.println();

        }
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(j == 0 || i ==0 || j == 4 || i == 4)
                    System.out.print(" *");
                else 
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}

public class Polymorphism {
    public static void main(String args[]) {
        // compile time polymorphism
        int a = 7;
        int b = 5;
        int c = 6;
        double d = 4.2;
        double e = 7.2;
        String fname = "John";
        String lname = "Prabu";
        System.out.println("CompileTime Polymorphism : \n");
        System.out.print(a + " + " + b + " = ");
        System.out.println(Addition.add(a,b));
        
        System.out.print(a + " + " + b + " + " + c + " = ");
        System.out.println(Addition.add(a,b,c));
        
        System.out.print(d + " + " + e + " = ");
        System.out.println(Addition.add(d,e));
        
        System.out.print(fname + " + space + " + lname + " = ");
        System.out.println(Addition.add(fname, " ", lname));

        // Run time polymorphism
        System.out.println("\n\nRun Time Polymorphism : \n");
        System.out.println("Draw Shape (base draw method): ");
        Shape s = new Shape();
        s.draw();

        System.out.println("Draw Triangle (overrides shape's draw method)");
        Triangle t = new Triangle();
        t.draw();

        System.out.println("Draw Square (overrides shape's draw method)");
        Square sq = new Square();
        sq.draw();


    }
}
