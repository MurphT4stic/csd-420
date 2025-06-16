//Tabari Harvey, Module-4 Programming Assignment CSD-420
import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversalTest {
    public static void main(String[] args) {
        testTraversal(50000);
        testTraversal(500000);

    }

    public static void testTraversal(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) list.add(i);{

         long startTime = System.nanoTime();
         Iterator<Integer> iterator = list.iterator();
         while (iterator.hasNext()) iterator.next();{
         long iteratorTime = System.nanoTime() - startTime;

         startTime = System.nanoTime();
         for (int i = 0; i < list.size(); i++) list.get(i);{
             long getTime = System.nanoTime() - startTime;

             System.out.println("Size:" + size);
             System.out.println("Iterator time: " + iteratorTime/ 1_000_000);
             System.out.println("get index time" + getTime/1_000_000);
             System.out.println();
                }
            }
        }
    }
}
