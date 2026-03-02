import java.util.Vector;

public class VectorUtils {

    public static <T> void swap(Vector<T> vec, int index1, int index2) {
        if (vec == null) {return;}
        if (index1 < 0 || index2 < 0 || index1 >= vec.size() || index2 >= vec.size() ) {return;}
        T temp = vec.get(index1);
        vec.set(index1, vec.get(index2));
        vec.set(index2, temp);
    }

    public static <T extends Comparable<T>> T findMax(Vector<T> vec) {
        if (vec == null || vec.isEmpty()) {return null;}
        T result = vec.getFirst();
        for (int i = 1; i < vec.size(); i++) {
            if (result.compareTo(vec.get(i)) < 0) {
                result = vec.get(i);
            }
        }
        return result;
    }

    public static Vector<Product> filterProducts(Vector<Product> vec, String category) {
        Vector<Product> filtered = new Vector<>();
        if (vec == null) {return filtered;}
        if (category == null || category.isEmpty()) {return filtered;}

        for (Product p : vec) {
            if (p == null) {continue;}
            if (category.equals(p.getCategory()) && p.getCategory() != null) {
                filtered.add(p);
            }
        }
        return filtered;
    }

    public static <T extends Number> double sumNumbers(Vector<T> numbers) {
        if (numbers == null || numbers.isEmpty()) {return 0;}
        double sum = 0.0;
        for (T num : numbers) {
            if (num == null) {continue;}
            else {
                sum += num.doubleValue();
            }
        }
        return sum;
    }

    public static <T extends Number> double averageNumbers(Vector<T> numbers) {
        if (numbers == null || numbers.isEmpty()) {return 0.0;}
        double sum = 0.0;
        int count = 0;
        for (T num : numbers) {
            if (num == null) {continue;}
            else {
                sum += num.doubleValue();
                count++;
            }
        }
        if  (count == 0) {return 0.0;}
        return sum / count;
    }
}
