import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystemMain {
    //=============== MENU METHODS ===============
    public static void addStudent(Scanner input, StudentManager sm) {
        double gpa;
        int year;

        System.out.print("Enter Student ID: ");
        String id = input.nextLine().trim();

        System.out.print("Enter First Name: ");
        String fn = input.nextLine().trim();

        System.out.print("Enter Last Name: ");
        String ln = input.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = input.nextLine().trim();

        while (true) {
            System.out.print("Enter GPA: ");
            String line = input.nextLine().trim();
            try {
                gpa = Double.parseDouble(line);
                if (gpa < 0.0 || gpa > 4.0) {
                    System.out.println("GPA must be between 0.0 and 4.0");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Numbers only PLEASE!");
            }
        }

        System.out.print("Enter Major: ");
        String major = input.nextLine().trim();

        while (true) {
            System.out.print("Enter Year (1-4): ");
            String line = input.nextLine().trim();
            try {
                year = Integer.parseInt(line);
                if (year < 1 || year > 4) {
                    System.out.println("Year must be 1 to 4!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Numbers only PLEASE!");
            }
        }
        sm.addStudent(new Student(id, fn, ln, email, gpa, major, year));
        System.out.println("Student added!\n");
    }

    public static void removeStudent(Scanner input, StudentManager sm) {
        System.out.print("Enter Student ID to remove: ");
        String id = input.nextLine().trim();

        boolean removed = sm.removeStudent(id);
        System.out.println("Student Removed? " + removed + "\n");
    }

    public static void findStudent(Scanner input, StudentManager sm) {
        System.out.print("Enter Student ID to find: ");
        String id = input.nextLine().trim();

        Student s = sm.findStudent(id);
        System.out.println(s == null ? "Not found!\n" : (s + "\n"));
    }

    public static void listAllStudents(StudentManager sm) {
        sm.printAllStudents();
        System.out.println();
    }

    public static void addCourse(Scanner input, CourseManager cm) {
        int credits;
        int max;

        System.out.print("Enter Course Code: ");
        String code = input.nextLine().trim();

        System.out.print("Enter Course Name: ");
        String name = input.nextLine().trim();

        while (true) {
            System.out.print("Enter Credits: ");
            String line = input.nextLine().trim();
            try {
                credits = Integer.parseInt(line);
                if (credits <= 0) {
                    System.out.println("Credits must be positive!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Numbers only PLEASE!");
            }
        }
        System.out.print("Enter Instructor: ");
        String instructor = input.nextLine().trim();

        while (true) {
            System.out.print("Enter Max Enrollment: ");
            String line = input.nextLine().trim();
            try {
                max = Integer.parseInt(line);
                if (max <= 0) {
                    System.out.println("Max enroll must be positive!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Numbers only PLEASE!");
            }
        }

        Course c = new Course(code, name, credits, instructor, max);

        System.out.print("Add prerequisite course code: ");
        while (true) {
            String p = input.nextLine().trim();
            if (p.isEmpty()) break;
            c.addPrerequisite(p);
            System.out.print("Add another prerequisite: ");
        }
        cm.addCourse(c);
        System.out.println("Course added!\n");
    }

    public static void enrollStudent(Scanner input, StudentManager sm, CourseManager cm, EnrollmentManager em) {
        System.out.print("Enter Student ID: ");
        String studentId = input.nextLine().trim();

        if (sm.findStudent(studentId) == null) {
            System.out.println("Student not found!\n");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = input.nextLine().trim();

        if (cm.findCourse(courseCode) == null) {
            System.out.println("Course not found!\n");
            return;
        }
        System.out.print("Enter Semester (ex. Fall 2026): ");
        String semester = input.nextLine().trim();

        em.enrollStudent(studentId, courseCode, semester);
        System.out.println("Enrollment added!\n");
    }

    public static void assignGrade(Scanner input, EnrollmentManager em) {
        System.out.print("Enter Enrollment ID (ex. E001): ");
        String eid = input.nextLine().trim();

        String grade;
        while (true) {
            System.out.print("Enter Grade (A/B/C/D/F): ");
            grade = input.nextLine().trim().toUpperCase();

            if (grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("F")) {
                break;
            }
            System.out.println("Invalid grade. Enter ONLY A, B, C, D, or F.");
        }
        em.assignGrade(eid, grade);
        System.out.println("Grade assigned!\n");
    }

    public static void calculateStudentGpa(Scanner input, StudentManager sm, EnrollmentManager em) {
        System.out.print("Enter Student ID: ");
        String id = input.nextLine().trim();

        if (sm.findStudent(id) == null) {
            System.out.println("Student not found!\n");
            return;
        }
        double gpa = em.calculateStudentGpa(id);
        System.out.printf("Calculated GPA: %.2f%n%n", gpa);
    }

    public static void generateReports(StudentManager sm, CourseManager cm, EnrollmentManager em) {
        System.out.println("---------- Generated Reports ----------");

        System.out.println("\nTotal Students: " + sm.getTotalStudents());
        System.out.printf("Average GPA: %.2f%n", sm.getAverageGpa());

        System.out.println("\nTotal Courses: " + cm.getTotalCourses());

        System.out.println("\n--- All Students ---");
        sm.printAllStudents();

        System.out.println("\n--- All Courses ---");
        cm.printAllCourses();

        System.out.println("\n--- All Enrollments ---");
        em.printAllEnrollments();

        //Generic utilities
        System.out.println("\n--- Generic Utilities ---");
        ArrayList<Student> cs = sm.getStudentsByMajor("Computer Science");
        if (cs.size() >= 2) {
            ArrayListUtils.swap(cs, 0, 1);
            System.out.println("Swapped CS Elements (0,1): " + cs);
        }
        Student max = ArrayListUtils.findMax(cs);
        System.out.println("Max CS Element: " + max);

        //Generic
        System.out.println("\n--- Generic Data Structures ---");
        GenericStack<String> stack = new GenericStack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("Stack pop: " + stack.pop());

        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Queue dequeue: " + queue.dequeue());

        System.out.println();
    }

    //=============== MENU INPUT ===============
    public static int menuInt(Scanner input) {
        int option = 0;
        String line = input.nextLine().trim();

        try {
            option = Integer.parseInt(line);
            switch (option) {
                case 1:
                    System.out.println("Add Student Selected");
                    break;
                case 2:
                    System.out.println("Remove Student Selected");
                    break;
                case 3:
                    System.out.println("Find Student Selected");
                    break;
                case 4:
                    System.out.println("List All Students Selected");
                    break;
                case 5:
                    System.out.println("Add Course Selected");
                    break;
                case 6:
                    System.out.println("Enroll Student Selected");
                    break;
                case 7:
                    System.out.println("Assign Grade Selected");
                    break;
                case 8:
                    System.out.println("Calculate Student GPA Selected");
                    break;
                case 9:
                    System.out.println("Generate Reports Selected");
                    break;
                case 10:
                    System.out.println("Exit Selected");
                    break;
                default:
                    System.out.println("Invalid option. Enter 1 - 10.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid option. Integer only!");
        }
        return option;
    }

    //=============== SAMPLE DATA ===============
    private static void addSampleData(StudentManager sm, CourseManager cm, EnrollmentManager em) {
        //10 students
        sm.addStudent(new Student("S001", "Justin", "Bieber", "jb@university.edu", 3.8, "Music Theory", 2));
        sm.addStudent(new Student("S002", "Donald", "Trump", "dontrump@university.edu", 3.5, "Political Science", 3));
        sm.addStudent(new Student("S003", "Charlie", "Kirk", "charlieK@university.edu", 3.9, "Communications", 2));
        sm.addStudent(new Student("S004", "Wumpus", "Wumpus", "wumpus@university.edu", 3.2, "Zoology", 1));
        sm.addStudent(new Student("S005", "Jong", "Kim", "kju@university.edu", 3.0, "History", 4));
        sm.addStudent(new Student("S006", "Steve", "Jobs", "stevejobs@university.edu", 3.1, "Business", 2));
        sm.addStudent(new Student("S007", "Mark", "SuckABird", "MarkZuck@university.edu", 3.7, "Computer Science", 1));
        sm.addStudent(new Student("S008", "Jeff", "Bezos", "jbezos@university.edu", 2.9, "Physics", 3));
        sm.addStudent(new Student("S009", "LeGoat", "James", "kingjames@university.edu", 2.5, "Exercise Science", 2));
        sm.addStudent(new Student("S010", "Kevin", "Nguyen", "knguyen@university.edu", 3.4, "Computer Science", 3));

        //5 courses
        Course c1 = new Course("CISC1110", "Intro to CS", 4, "Prof. Jordan", 30);
        Course c2 = new Course("CISC3130", "Data Structures", 4, "Prof. Hulse", 35);
        Course c3 = new Course("MATH1201", "Calculus I", 4, "Prof. Patel", 40);
        Course c4 = new Course("PHYS1010", "Physics I", 3, "Prof. Jada", 35);
        Course c5 = new Course("BIOL1001", "Biology I", 3, "Prof. Curry", 35);

        c2.addPrerequisite("CISC1110");

        cm.addCourse(c1);
        cm.addCourse(c2);
        cm.addCourse(c3);
        cm.addCourse(c4);
        cm.addCourse(c5);

        //enrollments
        em.enrollStudent("S001", "CISC1110", "Fall 2026");
        em.enrollStudent("S002", "MATH1201", "Fall 2026");
        em.enrollStudent("S003", "MATH1201", "Fall 2026");
        em.enrollStudent("S004", "CISC1110", "Fall 2026");
        em.enrollStudent("S005", "BIOL1001", "Fall 2026");
        em.enrollStudent("S006", "PHYS1010", "Fall 2026");

        em.assignGrade("E001", "F");
        em.assignGrade("E002", "C");
        em.assignGrade("E003", "A");
        em.assignGrade("E004", "A");
        em.assignGrade("E005", "B");
        em.assignGrade("E006", "D");
    }

    //=============== MAIN ===============
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        CourseManager cm = new CourseManager();
        EnrollmentManager em = new EnrollmentManager();

        addSampleData(sm, cm, em);

        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("--------- Interactive Menu ---------");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Find Student");
            System.out.println("4. List All Students");
            System.out.println("5. Add Course");
            System.out.println("6. Enroll Student in Course");
            System.out.println("7. Assign Grade");
            System.out.println("8. Calculate Student GPA");
            System.out.println("9. Generate Reports");
            System.out.println("10. Exit\n");
            System.out.print("Choose an option: ");

            option = menuInt(input);

            switch (option) {
                case 1:
                    addStudent(input, sm);
                    break;
                case 2:
                    removeStudent(input, sm);
                    break;
                case 3:
                    findStudent(input, sm);
                    break;
                case 4:
                    listAllStudents(sm);
                    break;
                case 5:
                    addCourse(input, cm);
                    break;
                case 6:
                    enrollStudent(input, sm, cm, em);
                    break;
                case 7:
                    assignGrade(input, em);
                    break;
                case 8:
                    calculateStudentGpa(input, sm, em);
                    break;
                case 9:
                    generateReports(sm, cm, em);
                    break;
                case 10:
                    System.out.println("Exiting Now!!!");
                    break;
                default:
                    break;
            }
        } while (option != 10);
        input.close();
    }
}