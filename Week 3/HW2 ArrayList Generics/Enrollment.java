public class Enrollment {
    private String enrollmentId;
    private String studentId;
    private String courseCode;
    private String grade;
    private String semester;

    //Constructor
    public Enrollment(String enrollmentId, String studentId, String courseCode, String grade, String semester) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.grade = grade;
        this.semester = semester;
    }

    //Getters
    public String getEnrollmentId() {
        return enrollmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getGrade() {
        return grade;
    }

    public String getSemester() {
        return semester;
    }

    //Setters
    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Enrollment Info [Enrollment ID: " + this.enrollmentId + " | Student ID: " + this.studentId +
                " | Course Code: " + this.courseCode + " | Grade: " + this.grade + " | Semester: " + this.semester + "]";
    }

    //converts letter grade to points (A=4.0, B=3.0, C=2.0, D=1.0, F=0.0)
    public double getGradePoints() {
        if (grade == null || grade.trim().isEmpty()) {
            return 0.0;
        }
        String g = grade.trim().toUpperCase();
        switch (g) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }

    //returns true if grade is A, B, C, or D
    public boolean isPassing() {
        if (grade == null || grade.trim().isEmpty()) {return false;}
        String g = grade.trim().toUpperCase();
        switch (g) {
            case "A":
                return true;
            case "B":
                return true;
            case "C":
                return true;
            case "D":
                return true;
            default:
                return false;
        }
    }
}
