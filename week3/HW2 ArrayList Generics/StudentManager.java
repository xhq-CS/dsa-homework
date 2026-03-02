import java.util.ArrayList;

import static java.lang.Math.round;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {students = new ArrayList<>();}

    //finds student, returns null if not found
    public Student findStudent(String studentId) {
        if (studentId == null) {return null;}
        for (Student student : students) {
            if (studentId.equals(student.getStudentId())) {return student;}
        }
        return null;
    }

    //adds student (check for duplicate studentId)
    public void addStudent(Student student) {
        if (student == null || student.getStudentId() == null) {return;}
        if (findStudent(student.getStudentId()) != null) {return;}
        students.add(student);
    }

    //removes student by ID
    public boolean removeStudent(String studentId) {
        if (studentId == null) {return false;}
        Student s = findStudent(studentId);
        if (s == null) {return false;}
        students.remove(s);
        return true;
    }

    //returns students in major
    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> sMajor = new ArrayList<>();
        if  (major == null) {return sMajor;}
        for (Student student : students) {
            if (student == null) {continue;}
            if (student.getMajor() == null) {continue;}
            if (student.getMajor().equals(major)) {
                sMajor.add(student);
            }
        }
        return sMajor;
    }

    //returns students in year
    public ArrayList<Student> getStudentsByYear(int year) {
        ArrayList<Student> sYear = new ArrayList<>();
        if (year < 1 || year > 4) {return sYear;}
        for (Student student : students) {
            if (student.getYear() == year) {
                sYear.add(student);
            }
        }
        return sYear;
    }

    //returns students with GPA >= minGpa
    public ArrayList<Student> getHonorStudents(double minGpa) {
        ArrayList<Student> sGpa = new ArrayList<>();
        if (minGpa < 0.0 || minGpa > 4.0) {return sGpa;}
        for (Student student : students) {
            if (student.getGpa() >= minGpa) {
                sGpa.add(student);
            }
        }
        return sGpa;
    }

    //calculates average GPA of all students
    public double getAverageGpa() {
        double avg;
        if (students.isEmpty()) {return 0.0;}
        double sum = 0.0;
        for (Student student : students) {
            sum += student.getGpa();
        }
        avg = sum / students.size();
        return Math.round(avg * 10.0) / 10.0;
    }

    //calculates average GPA for major
    public double getAverageGpaByMajor(String major) {
        double avg;
        if (major == null) {return 0.0;}
        ArrayList<Student> byMajor = getStudentsByMajor(major);
        if (byMajor.isEmpty()) {return 0.0;}
        double sum = 0.0;
        for (Student student : byMajor) {
            sum += student.getGpa();
        }
        avg = sum / byMajor.size();
        return Math.round(avg * 10.0) / 10.0;
    }

    //prints all students in formatted table
    public void printAllStudents() {
        if (students == null || students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }
        System.out.printf("------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-18s | %-25s | %-5s | %-20s | %-5s |%n", "Student ID", "Name", "Email", "GPA", "Major", "Year");
        System.out.printf("------------------------------------------------------------------------------------------------------%n");
        for (Student student : students) {
            if (student == null) {continue;}
            System.out.printf("| %-10s | %-18s | %-25s | %-5.1f | %-20s | %-5d |%n",
                    student.getStudentId(), student.getFullName(), student.getEmail(), student.getGpa(),
                    student.getMajor(), student.getYear());
        }
        System.out.printf("------------------------------------------------------------------------------------------------------%n\n");
    }

    //returns number of students
    public int getTotalStudents() {
        return students.size();
    }

    //returns list of all unique majors
    public ArrayList<String> getAllMajors() {
        ArrayList<String> majors = new ArrayList<>();
        if (students.isEmpty()) {return majors;}
        for (Student student : students) {
            if (student.getMajor() == null) {continue;}
            if (!majors.contains(student.getMajor())) {
                majors.add(student.getMajor());
            }
        }
        return majors;
    }
}
