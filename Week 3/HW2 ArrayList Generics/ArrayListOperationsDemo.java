import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListOperationsDemo {
    public static void main(String[] args) {
        //Array to ArrayList:
        Student[] studentArr = {
                new Student("S001", "Justin", "Bieber", "jb@university.edu", 3.8, "Music Theory", 2),
                new Student("S002", "Donald", "Trump", "dontrump@university.edu", 3.5, "Political Science", 3),
                new Student("S003", "Charlie", "Kirk", "charlieK@university.edu", 3.9, "Communications", 2)};
        List<Student> list = Arrays.asList(studentArr);
        ArrayList<Student> newList = new ArrayList<>(list);

        System.out.println("Convert Array to ArrayList");
        System.out.println("Original array: " + Arrays.toString(studentArr));
        System.out.println("asList: " + list);
        System.out.println("new ArrayList: " + newList);

        newList.add(new Student("S004", "Wumpus", "Wumpus", "wumpus@university.edu", 3.2, "Zoology", 1));
        newList.remove(0);
        System.out.println("After adding/removing: " + newList + "\n");

        //Demonstrate adding/removing after conversion
        try {
            list.add(new Student("S005", "Jong", "Kim", "kju@university.edu", 3.0, "History", 4));
        } catch (UnsupportedOperationException ex) {
            System.out.println("list.add() no work");
        }
        try {
            list.remove(0);
        } catch (UnsupportedOperationException ex) {
            System.out.println("list.remove() no work\n");
        }

        //ArrayList to Array:
        System.out.println("ArrayList to Array");
        ArrayList<Student> studentsAL = new ArrayList<>();
        studentsAL.add(new Student("S006", "Steve", "Jobs", "stevejobs@university.edu", 3.1, "Business", 2));
        studentsAL.add(new Student("S007", "Mark", "SuckABird", "MarkZuck@university.edu", 3.7, "CS", 1));
        studentsAL.add(new Student("S008", "Jeff", "Bezos", "jbezos@university.edu", 2.9, "Physics", 3));

        Student[] studentsArray = studentsAL.toArray(new Student[0]);

        System.out.println("ArrayList: " + studentsAL);
        System.out.println("Array: " + Arrays.toString(studentsArray) + "\n");

        //SubList Operations:
        System.out.println("SubList Operations");
        ArrayList<Student> subListDemo = new ArrayList<>(newList);
        System.out.println("Original sublist: " + subListDemo);

        List<Student> subList = subListDemo.subList(0, Math.min(2, subListDemo.size()));
        System.out.println("SubList(0 to 2): " + subList);

        System.out.println("Removing first element from subList...");
        if (!subList.isEmpty()) subList.remove(0);

        System.out.println("SubList after remove: " + subList);
        System.out.println("Original sublist after: " + subListDemo + "\n");

        //ArrayList Sorting:
        System.out.println("ArrayList Sorting");
        ArrayList<Student> sortList = new ArrayList<>(newList);

        System.out.println("Before sort: " + sortList);
        //Sort By GPA
        Collections.sort(sortList, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {return Double.compare(b.getGpa(), a.getGpa());}
        });
        System.out.println("Sorted by GPA: " + sortList);

        //Sort By Last Name
        Collections.sort(sortList, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.getLastName().compareTo(b.getLastName());
            }
        });
        System.out.println("Sorted by last name: " + sortList + "\n");

        //ArrayList Searching:
        System.out.println("ArrayList Searching");
        //indexOf
        Student search = sortList.get(0);
        System.out.println("Student Search: " + search);

        System.out.println("indexOf: " + sortList.indexOf(search));
        System.out.println("contains: " + sortList.contains(search));
        //binarySearch
        Comparator<Student> lastName = new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {return a.getLastName().compareTo(b.getLastName());}
        };

        Collections.sort(sortList, lastName); // ensure sorted for binarySearch
        int index = Collections.binarySearch(sortList, search, lastName);

        System.out.println("List sorted binarySearch: " + sortList);
        System.out.println("binarySearch index: " + index);
    }
}