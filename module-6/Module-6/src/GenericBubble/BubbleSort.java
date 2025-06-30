//Tabari Harvey, Module-6 Programming Assignment, CSD420
package GenericBubble;

import java.util.Comparator;

public class BubbleSort {
    public static void main(String[] args) {

        // Use Comparable
        String[] names = {"Zoe", "Adam", "Clara", "Ben"};
        System.out.println("Before Comparable sort:");
        GenericBubbleSort.printArray(names);
        GenericBubbleSort.bubbleSort(names);
        System.out.println("After Comparable sort:");
        GenericBubbleSort.printArray(names);

        // Use Comparator
        Integer[] numbers = {5, 2, 9, 1, 3};
        System.out.println("Before Comparator sort (descending):");
        GenericBubbleSort.printArray(numbers);
        GenericBubbleSort.bubbleSort(numbers, Comparator.reverseOrder());
        System.out.println("After Comparator sort (descending):");
        GenericBubbleSort.printArray(numbers);
    }
}

