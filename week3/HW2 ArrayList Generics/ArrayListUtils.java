import java.util.ArrayList;

public class ArrayListUtils {
    public static <T> void swap(ArrayList<T> list, int index1, int index2) {
        if (list == null) {return;}
        if (index1 < 0 || index2 < 0) {return;}
        if (index1 >= list.size() || index2 >= list.size()) {return;}
        if (index1 == index2) {return;}
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static <T extends Comparable<T>> T findMax(ArrayList<T> list) {
        if (list == null || list.isEmpty()) {return null;}
        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T cur = list.get(i);
            if (cur == null) {continue;}
            if (max == null || cur.compareTo(max) > 0) {
                max = cur;
            }
        }
        return max;
    }

    public interface Predicate<T> {boolean test(T value);}

    public static <T> ArrayList<T> filter(ArrayList<T> list, Predicate<T> condition) {
        ArrayList<T> result = new ArrayList<>();
        if (list == null || condition == null) {return result;}
        for (T item : list) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void reverse(ArrayList<?> list) {if (list == null) return;reverseHelper(list);}

    private static <T> void reverseHelper(ArrayList<T> list) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            swap(list, i, j);
            i++;
            j--;
        }
    }

    public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> result = new ArrayList<>();
        if (list1 != null) result.addAll(list1);
        if (list2 != null) result.addAll(list2);
        return result;
    }

    public static <T extends Number> double sum(ArrayList<T> numbers) {
        if (numbers == null || numbers.isEmpty()) {return 0.0;}
        double total = 0.0;
        for (T n : numbers) {
            if (n == null) {continue;}
            total += n.doubleValue();
        }
        return total;
    }

    public static <T extends Number> double average(ArrayList<T> numbers) {
        if (numbers == null || numbers.isEmpty()) {return 0.0;}
        double total = 0.0;
        int count = 0;
        for (T n : numbers) {
            if (n == null) {continue;}
            total += n.doubleValue();
            count++;
        }
        if (count == 0) {return 0.0;}
        return total / count;
    }

    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> numbers, T threshold) {
        ArrayList<T> result = new ArrayList<>();
        if (numbers == null || threshold == null) {return result;}
        for (T n : numbers) {
            if (n == null) {continue;}
            if (n.compareTo(threshold) > 0) {
                result.add(n);
            }
        }
        return result;
    }

    public static double sumNumbers(ArrayList<? extends Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {return 0.0;}
        double sum = 0.0;
        for (Number n : numbers) {
            if (n == null) {continue;}
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void addNumbers(ArrayList<? super Integer> list) {
        if (list == null) {return;}
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void printList(ArrayList<?> list) {
        if (list == null) {
            System.out.println("null");
            return;
        }
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
    /*
    When to use each wildcard
    -Upper: when you only need to read numbers from the list structure

    -Lower: when you want to add Integers/data into the list structure

    -Unbounded: when code does not depend on type parameter
     */
}