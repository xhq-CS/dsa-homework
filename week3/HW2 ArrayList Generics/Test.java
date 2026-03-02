public class Test {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2));
        manager.addStudent(new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3));
        manager.addStudent(new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2));

        manager.printAllStudents();
        System.out.println("Average GPA: " + manager.getAverageGpa());
        System.out.println("CS Students: " + manager.getStudentsByMajor("Computer Science").size());
    }
}
