// base class
class Student {
    protected int rollno;
    protected String name;
    static protected String college = "MIT";
    
    //constructor
    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
    
    // getters and setters
    public void setName(String name) { this.name = name; } 
    public String getName() { return name; }

    public void setRollNo(int rollno) { this.rollno = rollno; }
    public int getRollNo() { return rollno; }

    public String getCollege() { return college; }

    // func member
    void displayInfo() {
        System.out.println("Name : " + name + "\nRoll No : " + rollno + "\nCollege : " + college);
    }
}

/**
 * Gradable
 */ 
interface Gradeable {
    float grade = 0; // by default access modifier public static final
    void setGrade(float grade); // public abstract
    public float getGrade(); // public abstract
}

class UGStudent extends Student implements Gradeable {
    private float grade;
    private String major;

    public UGStudent(int rollno, String name, float grade, String major) {
        super(rollno, name);
        this.grade = grade;
        this.major = major;
    }

    @Override
    public void setGrade(float grade) { this.grade = grade; }
    @Override
    public float getGrade() { return grade; } 
    
    public void setMajor(String major) { this.major = major; }
    public String getMajor() { return major; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Grade : " + grade);
        System.out.println("Major : " + major);
    }
}

class PGStudent extends Student implements Gradeable {
    private float grade;
    private String thesisTitle;

    public PGStudent(int rollno, String name, float grade, String thesisTitle) {
        super(rollno, name);
        this.grade = grade;
        this.thesisTitle = thesisTitle;
    }

    @Override
    public void setGrade(float grade) { this.grade = grade; }
    @Override
    public float getGrade() { return grade; } 

    public void setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; }
    public String getThesisTitle() { return thesisTitle; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Grade : " + grade);
        System.out.println("Thesis Title : " + thesisTitle);
    }
}



public class Inheritance {
    
    public static void main(String args[]) {
        // base class object
        Student s = new Student(2022506001, "Student1");
        s.displayInfo();
        System.out.println();
        // multi inheritance using interface
        UGStudent s1 = new UGStudent(2022506113, "John Prabu A", 10, "Information Technology");
        s1.displayInfo();
        System.out.println();
        PGStudent s2 = new PGStudent(2023506113, "Sripathy", 10, "Web Automation");
        s2.displayInfo();
        System.out.println();
    }
}
