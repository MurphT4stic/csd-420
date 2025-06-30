//Tabari Harvey, Module-6 Programming Assignment, CSD420
package GenericBubble;

import java.util.Comparator;

public class GenericBubbleSort {

    // Use Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Use Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Print array
    public static <E> void printArray(E[] array) {
        System.out.print("Array = {");
        for (E e : array) {
            System.out.print(" [" + e + "] ");
        }
        System.out.println("};\n");
    }
}

