//Tabari Harvey, Module-3 Programming Assignment CSD-420
import java.util.ArrayList;
import java.util.Random;

public class Arraylist {

    public static void main(String[] args) {
        // Fill list with 50 random integers (1 to 20)
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            list.add(rand.nextInt(20) + 1);
        }

        System.out.println("Original List (with duplicates):");
        System.out.println(list);

        // Call removeDuplicates and print result
        ArrayList<Integer> uniqueList = removeDuplicates(list);

        System.out.println("\nList After Removing Duplicates:");
        System.out.println(uniqueList);
    }

    // Generic method
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
