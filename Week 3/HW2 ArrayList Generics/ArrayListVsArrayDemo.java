import java.util.ArrayList;
import java.util.Random;

public class ArrayListVsArrayDemo {
    public static void main(String[] args) {
        //Create both Student[] array and ArrayList<Student>
        Student[] studentArr = new Student[3];
        studentArr[0] = new Student("S001", "Justin", "Bieber", "jb@university.edu", 3.8, "Music Theory", 2);
        studentArr[1] = new Student("S002", "Donald", "Trump", "dontrump@university.edu", 3.5, "Political Science", 3);
        studentArr[2] = new Student("S003", "Charlie", "Kirk", "charlieK@university.edu", 3.9, "Communications", 2);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("S001", "Justin", "Bieber", "jb@university.edu", 3.8, "Music Theory", 2));
        studentList.add(new Student("S002", "Donald", "Trump", "dontrump@university.edu", 3.5, "Political Science", 3));
        studentList.add(new Student("S003", "Charlie", "Kirk", "charlieK@university.edu", 3.9, "Communications", 2));

        System.out.println("Array Size: " + studentArr.length);
        System.out.println("ArrayList Size: " + studentList.size());

        //Perform operations:
        //Add elements (show array limitation)
        studentList.add(new Student("S004", "Wumpus", "Wumpus", "wumpus@university.edu", 3.2, "Zoology", 1));
        System.out.println("ArrayList after add: size = " + studentList.size());

        //Remove elements (array limitation)
        studentArr[1] = null;
        System.out.println("Array after remove: " + studentArr[1]);
        studentList.remove(1);
        System.out.println("ArrayList size after: " + studentList.size() + "\n");

        //Resize (show ArrayList advantage)
        Student[] bigArr = new Student[studentArr.length + 2];
        for (int i = 0; i < studentArr.length; i++) {
            bigArr[i] = studentArr[i];
        }
        studentArr = bigArr;
        System.out.println("Resized array: " + studentArr.length + "\n");

        //Measure performance:
        //Time to add 10,000 students
        int pAdd = 10000;
        long startAddAL = System.nanoTime();
        ArrayList<Student> pList = new ArrayList<>();
        for (int i = 0; i < pAdd; i++) {
            pList.add(makeStudent(i));
        }
        long eAddAL = System.nanoTime();
        long AddedTimeAL = eAddAL - startAddAL;

        long sAddArr = System.nanoTime();
        Student[] pArr = new Student[pAdd];
        for (int i = 0; i < pAdd; i++) {
            pArr[i] = makeStudent(i);
        }
        long eAddArr = System.nanoTime();
        long AddTimeArr = eAddArr - sAddArr;

        //Time to access 1,000 random students
        int pAccess = 1000;
        Random rand = new Random();

        long startALAccess = System.nanoTime();
        for (int i = 0; i < pAccess; i++) {
            int idx = rand.nextInt(pAdd);
            Student s = pList.get(idx);
        }
        long endALAccess = System.nanoTime();
        long alAccessTime = endALAccess - startALAccess;

        long startArrAccess = System.nanoTime();
        for (int i = 0; i < pAccess; i++) {
            int idx = rand.nextInt(pAdd);
            Student s = pArr[idx];
        }
        long endArrAccess = System.nanoTime();
        long arrAccessTime = endArrAccess - startArrAccess;

        double AddedTimeALms = AddedTimeAL / 1000_000.0;
        double AddTimeArrms  = AddTimeArr  / 1000_000.0;
        double alAccessTimems = alAccessTime / 1000_000.0;
        double arrAccessTimems = arrAccessTime / 1000000.0;

        //Print comparison report
        System.out.println("Add " + pAdd + " students:");
        System.out.printf("ArrayList time: %.3fms%n", AddedTimeALms);
        System.out.printf("Array time: %.3fms%n%n", AddTimeArrms);

        System.out.println("Access " + pAccess + " random students:");
        System.out.printf("ArrayList time: %.3fms%n", alAccessTimems);
        System.out.printf("Array time: %.3fms%n", arrAccessTimems);

        //Summary: when to use each
        /*
        When to use array
        -Size is fixed, and you want fast direct access
        -When you don’t need to add or remove often

        When to use arraylist
        -Need methods like add,remove, sort, search, and resize
         */

    }

    //Create Test Student Objects
    private static Student makeStudent(int i) {
        String id = String.format("S%05d", i);
        return new Student(id, "First" + i, "Last" + i, "s" + i + "@university.edu",
                (i % 41) / 10.0, "Major" + (i % 5), (i % 4) + 1);
    }
}