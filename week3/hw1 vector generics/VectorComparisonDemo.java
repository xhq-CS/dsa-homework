import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class VectorComparisonDemo {
    public static void main(String[] args) {
        Vector<Product> vector = new Vector<>();
        ArrayList<Product> array = new ArrayList<>();
        final int add = 10000;
        final int access = 1000;
        Runtime rt = Runtime.getRuntime();

        //-------------------- VECTOR ADDING --------------------
        long startV = System.nanoTime();
        for (int i = 0; i < add; i++) {
            String id = String.format("V%05d", i);

            if (i % 2 == 0) {
                vector.add(new Product(id, "iPhone 15 Pro", "Electronics", 499.99, 69, "Apple"));
            } else {
                vector.add(new Product(id, "Ray-Ban Glasses", "Accessories", 200.00, 3, "Ray-Ban"));
            }
        }
        long endV = System.nanoTime();
        double vAdd = (endV - startV) / 1000000.0;

        //-------------------- VECTOR RANDOM ACCESS --------------------
        Random rdm = new Random(69);
        long startV2 = System.nanoTime();
        for (int i = 0; i < access; i++) {
            int index = rdm.nextInt(vector.size());
            vector.get(index);
        }
        long endV2 = System.nanoTime();
        double vAccess = (endV2 - startV2) / 1000000.0;

        //-------------------- VECTOR MEMORY --------------------
        System.gc();
        long vMem = rt.totalMemory() - rt.freeMemory();
        Vector<Product> v = new Vector<>();
        for (int i = 0; i < add; i++) v.add(new Product("V"+i, "P"+i, "C", 1.0, 1, "S"));
        System.gc();
        double vMB = ((rt.totalMemory() - rt.freeMemory()) - vMem) / (1024.0 * 1024.0);

        //-------------------- ARRAYLIST ADDING --------------------
        long startA = System.nanoTime();
        for (int i = 0; i < add; i++) {
            String id = String.format("A%05d", i);

            if (i % 2 == 0) {
                array.add(new Product(id, "iPhone 15 Pro", "Electronics", 499.99, 69, "Apple"));
            } else {
                array.add(new Product(id, "Ray-Ban Glasses", "Accessories", 200.00, 3, "Ray-Ban"));
            }
        }
        long endA = System.nanoTime();
        double aAdd = (endA - startA) / 1000000.0;

        //-------------------- ARRAYLIST RANDOM ACCESS --------------------
        rdm = new Random(69); // same random pattern as Vector
        long startA2 = System.nanoTime();
        for (int i = 0; i < access; i++) {
            int index = rdm.nextInt(array.size());
            array.get(index);
        }
        long endA2 = System.nanoTime();
        double aAccess = (endA2 - startA2) / 1000000.0;

        //-------------------- ARRAYLIST MEMORY --------------------
        System.gc();
        long aMem = rt.totalMemory() - rt.freeMemory();
        ArrayList<Product> a = new ArrayList<>();
        for (int i = 0; i < add; i++) a.add(new Product("A"+i, "P"+i, "C", 1.0, 1, "S"));
        System.gc();
        double aMB = ((rt.totalMemory() - rt.freeMemory()) - aMem) / (1024.0 * 1024.0);


        //Comparison Report
        System.out.println("----- Vector vs ArrayList Comparison -----");
        System.out.printf("Time to Add: Vector = %.2fms | ArrayList = %.2fms%n", vAdd, aAdd);
        System.out.printf("Time to Access: Vector = %.2fms | ArrayList = %.2fms%n", vAccess, aAccess);
        System.out.printf("Memory Usage(Approx): Vector = %.2f MB | ArrayList = %.2f MB%n", vMB, aMB);
    }
}