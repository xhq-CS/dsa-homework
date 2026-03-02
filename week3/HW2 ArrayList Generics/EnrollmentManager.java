import java.util.ArrayList;

public class EnrollmentManager {
    private ArrayList<Enrollment> enrollments;

    //Constructor
    public EnrollmentManager() {enrollments = new ArrayList<>();}

    //creates enrollment
    public void enrollStudent(String studentId, String courseCode, String semester) {
        if (studentId == null || courseCode == null || semester == null) {return;}
        if (studentId.isEmpty() || courseCode.isEmpty() || semester.isEmpty()) {return;}
        for (Enrollment e : enrollments) {
            if (e == null) {continue;}
            if (e.getStudentId().equals(studentId) && e.getCourseCode().equals(courseCode)  && e.getSemester().equals(semester)) {
                return;
            }
        }
        String enrollmentId = String.format("E%03d", enrollments.size() + 1);
        Enrollment sEnroll = new Enrollment(enrollmentId, studentId, courseCode, null, semester);
        enrollments.add(sEnroll);
    }

    //removes enrollment
    public boolean dropEnrollment(String enrollmentId) {
        if (enrollmentId == null || enrollmentId.isEmpty()) return false;
        for (int i = 0; i < enrollments.size(); i++) {
            Enrollment e = enrollments.get(i);
            if (e == null) {continue;}
            if (enrollmentId.equals(e.getEnrollmentId())) {enrollments.remove(i); return true;}
        }
        return false;
    }

    //finds enrollment
    public Enrollment findEnrollment(String enrollmentId) {
        if (enrollmentId == null || enrollmentId.isEmpty()) {return null;}
        for (Enrollment e : enrollments) {
            if (e == null) {continue;}
            if (enrollmentId.equals(e.getEnrollmentId())) {return e;}
        }
        return null;
    }

    //returns student's enrollments
    public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) {
        ArrayList<Enrollment> enrollmentsByStudent = new ArrayList<>();
        if (studentId == null || studentId.isEmpty()) {return enrollmentsByStudent;}
        for (Enrollment e : enrollments) {
            if (e == null) {continue;}
            if (studentId.equals(e.getStudentId())) {enrollmentsByStudent.add(e);}
        }
        return enrollmentsByStudent;
    }

    //returns course enrollments
    public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) {
        ArrayList<Enrollment> enrollmentsByCourse = new ArrayList<>();
        if (courseCode == null || courseCode.isEmpty()) {return enrollmentsByCourse;}
        for (Enrollment e : enrollments) {
            if (e == null) {continue;}
            if (courseCode.equals(e.getCourseCode())) {enrollmentsByCourse.add(e);}
        }
        return enrollmentsByCourse;
    }

    //assigns grade to enrollment
    public void assignGrade(String enrollmentId, String grade) {
        if (enrollmentId == null || enrollmentId.isEmpty() || grade == null || grade.isEmpty()) {return;}
        String g = grade.trim().toUpperCase();
        if (!(g.equals("A") || g.equals("B") || g.equals("C") || g.equals("D") || g.equals("F"))) {return;}
        Enrollment e = findEnrollment(enrollmentId);
        if (e == null) {return;}
        e.setGrade(g);
    }

    //calculates GPA from enrollments
    public double calculateStudentGpa(String studentId) {
        if (studentId == null || studentId.isEmpty()) {return 0.0;}
        ArrayList<Enrollment> list = getEnrollmentsByStudent(studentId);
        if (list == null || list.isEmpty()) {return 0.0;}
        double sum = 0.0;
        int count = 0;
        for (Enrollment e : list) {
            if (e == null) {continue;}
            if (e.getGrade() == null) {continue;}
            sum += e.getGradePoints();
            count++;
        }
        if (count == 0) {return 0.0;}
        return sum / count;
    }

    //returns list of student IDs
    public ArrayList<String> getStudentsInCourse(String courseCode) {
        ArrayList<String> iDlist = new ArrayList<>();
        if (courseCode == null || courseCode.isEmpty()) {return iDlist;}
        for (Enrollment e : enrollments) {
            if (e == null) {continue;}
            if (courseCode.equals(e.getCourseCode())) {
                iDlist.add(e.getStudentId());
            }
        }
        return iDlist;
    }

    //returns number of students in course
    public int getEnrollmentCount(String courseCode) {
        if (courseCode == null || courseCode.isEmpty()) {return 0;}
        ArrayList<String> students = getStudentsInCourse(courseCode);
        return students.size();
    }

    //prints all enrollments
    public void printAllEnrollments() {
        if (enrollments == null || enrollments.isEmpty()) {
            System.out.println("No Enrollments Found!");
            return;
        }
        System.out.printf("------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-10s | %-10s | %-12s | %-5s |%n", "Enrollment ID", "Student ID", "Course", "Semester", "Grade");
        System.out.printf("------------------------------------------------------------------------------------------------------%n");

        for (Enrollment e : enrollments) {
            if (e == null) {continue;}
            System.out.printf("| %-15s | %-10s | %-10s | %-12s | %-5s |%n", e.getEnrollmentId(), e.getStudentId(),
                    e.getCourseCode(), e.getSemester(), e.getGrade());
        }
        System.out.printf("------------------------------------------------------------------------------------------------------%n");
    }
}
