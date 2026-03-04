import java.util.ArrayList;

public class ReportGenerator {
    public static void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em) {
        if (studentId == null || studentId.isEmpty() || sm == null || em == null) {
            System.out.println("Invalid input.");
            return;
        }

        Student s = sm.findStudent(studentId);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        ArrayList<Enrollment> enrollments = em.getEnrollmentsByStudent(studentId);

        System.out.println("-------- Student Report --------");
        System.out.println(s);
        System.out.println("Enrollments (" + enrollments.size() + "):");

        for (Enrollment e : enrollments) {
            if (e == null) continue;

            String grade = e.getGrade();
            if (grade == null || grade.trim().isEmpty()) grade = "N/A";

            System.out.println("- " + e.getCourseCode() + " | " + e.getSemester() + " | Grade: " + grade);
        }

        double gpa = em.calculateStudentGpa(studentId);
        System.out.printf("Calculated Enrollment GPA: %.2f%n", gpa);
        System.out.println();
    }

    public static void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em) {
        if (courseCode == null || courseCode.isEmpty() || cm == null || em == null) {
            System.out.println("Invalid input.");
            return;
        }

        Course c = cm.findCourse(courseCode);
        if (c == null) {
            System.out.println("Course not found.");
            return;
        }

        ArrayList<Enrollment> enrollments = em.getEnrollmentsByCourse(courseCode);
        ArrayList<String> studentIds = em.getStudentsInCourse(courseCode);

        System.out.println("-------- Course Report --------");
        System.out.println(c);
        System.out.println("Total Enrollments: " + studentIds.size());
        System.out.println("Enrolled Students:");

        for (String id : studentIds) {
            System.out.println("- " + id);
        }

        double sumPoints = 0.0;
        int gradedCount = 0;

        for (Enrollment e : enrollments) {
            if (e == null) continue;
            String g = e.getGrade();
            if (g == null || g.trim().isEmpty()) continue;

            sumPoints += e.getGradePoints();
            gradedCount++;
        }

        if (gradedCount == 0) {
            System.out.println("Average grade: N/A");
        } else {
            double avg = sumPoints / gradedCount;
            System.out.printf("Average grade points: %.2f%n", avg);
        }

        System.out.println();
    }

    public static void generateMajorReport(String major, StudentManager sm) {
        if (major == null || major.isEmpty() || sm == null) {
            System.out.println("Invalid input.");
            return;
        }

        ArrayList<Student> students = sm.getStudentsByMajor(major);

        System.out.println("-------- Major Report --------");
        System.out.println("Major: " + major);
        System.out.println("Student count: " + students.size());

        for (Student s : students) {
            if (s == null) continue;
            System.out.println("- " + s);
        }

        double avg = sm.getAverageGpaByMajor(major);
        System.out.printf("Average GPA By Major: %.2f%n", avg);
        System.out.println();
    }

    public static void generateHonorRollReport(StudentManager sm, double minGpa) {
        if (sm == null) {
            System.out.println("Invalid input!");
            return;
        }

        ArrayList<Student> honor = sm.getHonorStudents(minGpa);

        System.out.println("-------- Honor Roll Report --------");
        System.out.println("Min GPA: " + minGpa);
        System.out.println("Honor Students: " + honor.size());

        for (Student s : honor) {
            if (s == null) continue;
            System.out.println("- " + s);
        }

        System.out.println();
    }
}