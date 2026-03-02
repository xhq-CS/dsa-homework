import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private int credits;
    private String instructor;
    private int maxEnrollment;
    private ArrayList<String> prerequisites;

    //Constructor
    public Course(String courseCode, String courseName, int credits, String instructor, int maxEnrollment) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
        this.maxEnrollment = maxEnrollment;
        this.prerequisites = new ArrayList<>();
    }

    //Getters
    public String getCourseCode() {return courseCode;}
    public String getCourseName() {return courseName;}
    public int getCredits() {return credits;}
    public String getInstructor() {return instructor;}
    public int getMaxEnrollment() {return maxEnrollment;}

    //Setters
    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
    public void setCourseName(String courseName) {this.courseName = courseName;}
    public void setCredits(int credits) {this.credits = credits;}
    public void setInstructor(String instructor) {this.instructor = instructor;}
    public void setMaxEnrollment(int maxEnrollment) {this.maxEnrollment = maxEnrollment;}

    //toString
    @Override
    public String toString() {
        return "Course Code: " + this.courseCode + " | Course Name: " + this.courseName + " | Total Credits: " +
                this.credits + " | Max Enrollment: " + this.maxEnrollment  + " | Prerequisites: " + this.prerequisites;
    }

    //add Prerequisite courses
    public void addPrerequisite(String courseCode) {this.prerequisites.add(courseCode);}

    //checks if courseCode is a prerequisite
    public boolean hasPrerequisite(String courseCode) {return this.prerequisites.contains(courseCode);}

    //returns copy of prerequisites list
    public ArrayList<String> getPrerequisites() {return new ArrayList<>(prerequisites);}
}