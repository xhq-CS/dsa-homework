import java.util.Objects;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private double gpa;
    private String major;
    private int year;

    //Student Class Constructor
    public Student(String studentId, String firstName, String lastName, String email, double gpa, String major, int year) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gpa = gpa;
        this.major = major;
        this.year = year;
    }
    //Student Class Getters
    public String getStudentId() {return studentId;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getEmail() {return email;}
    public double getGpa() {return gpa;}
    public String getMajor() {return major;}
    public int getYear() {return year;}

    //Student Class Setters
    public void setStudentId(String studentId) {this.studentId = studentId;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {this.email = email;}
    public void setGpa(double gpa) {this.gpa = gpa;}
    public void setMajor(String major) {this.major = major;}
    public void setYear(int year) {this.year = year;}

    //Full name getFirstName + getLastName
    public String getFullName() {
        return firstName + " " + lastName;
    }

    //toString Method
    @Override
    public String toString() {
        return "Student ID: " + getStudentId() + " | Student Name: " + getFullName() + " | Email: " + getEmail() +
                " | GPA: " + getGpa() + " | Major: " + getMajor() + " | School Year: " + getYear();
    }

    //equals Method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Student student = (Student) obj;
        return Objects.equals(this.studentId, student.studentId);
    }

    //hashCode Method
    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
