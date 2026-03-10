import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //===================== STUDENT MANAGER =====================
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2));
        manager.addStudent(new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3));
        manager.addStudent(new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2));

        manager.printAllStudents();
        System.out.println("Average GPA: " + manager.getAverageGpa());
        System.out.println("CS Students: " + manager.getStudentsByMajor("Computer Science").size());

        //===================== COURSE MANAGER =====================
        CourseManager courseManager = new CourseManager();
        courseManager.addCourse(new Course("CISC3130", "Data Structures", 3, "Dr. Smith", 30));
        courseManager.addCourse(new Course("MATH101", "Calculus I", 4, "Dr. Johnson", 25));

        EnrollmentManager enrollmentManager = new EnrollmentManager();
        enrollmentManager.enrollStudent("S001", "CISC3130", "Fall 2024");
        enrollmentManager.assignGrade("E001", "A");
        System.out.println("Student GPA: " + enrollmentManager.calculateStudentGpa("S001") + "\n");

        //===================== GENERIC LIST =====================
        GenericList<String> strings = new GenericList<>();
        strings.add("Hello");

        GenericList<Integer> numbers = new GenericList<>();
        numbers.add(42);

        GenericList<Student> students = new GenericList<>();
        students.add(new Student("S001", "Justin", "Bieber", "jb@university.edu", 3.8, "Music Theory", 2));

        //===================== ARRAYLIST UTILS =====================
        //Task 4.3
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        System.out.println("Sum: " + ArrayListUtils.sum(ints));
        System.out.println("Average: " + ArrayListUtils.average(ints) + "\n");

        // Task 4.4
        ArrayList<Integer> wildInts = new ArrayList<>();
        wildInts.add(6);
        wildInts.add(7);
        System.out.printf("Sum ints: %.1f%n", ArrayListUtils.sumNumbers(wildInts));

        ArrayList<Double> wildDoubles = new ArrayList<>();
        wildDoubles.add(6.8);
        wildDoubles.add(7.9);
        System.out.printf("Sum doubles: %.1f%n", ArrayListUtils.sumNumbers(wildDoubles));

        ArrayList<Number> wildNums = new ArrayList<>();
        ArrayListUtils.addNumbers(wildNums);
        ArrayListUtils.printList(wildNums);

        ArrayList<Object> wildObject = new ArrayList<>();
        ArrayListUtils.addNumbers(wildObject);
        ArrayListUtils.printList(wildObject);


        //===================== GENERIC STACK =====================
        GenericStack<String> stack = new GenericStack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("\n" + stack.pop());  // Second

        //===================== GENERIC STACK =====================
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("\n" + queue.dequeue());  // 10

        //===================== PAIR =====================
        ArrayList<Pair<String, Double>> coursePairs = new ArrayList<>();
        coursePairs.add(new Pair<>("CISC3130", 3.7));
        coursePairs.add(new Pair<>("CISC3115", 3.3));

        ArrayList<Pair<Student, Course>> enrollmentPairs = new ArrayList<>();
        Student s = new Student("S001", "Donald", "Trump", "dontrump@university.edu", 3.5, "Political Science", 3);
        Course c = new Course("CISC3130", "Data Structures", 4, "Prof. Hulse", 35);
        enrollmentPairs.add(new Pair<>(s, c));

        System.out.println("\n" + coursePairs);
        System.out.println(enrollmentPairs);
    }
}
