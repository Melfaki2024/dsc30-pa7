/*
 * Name: Mohamed Elmostafa Elfaki
 * PID:  A16317776
 */

/**
 * This class implements a sorting algorithm that uses the heap structure to sort
 * the input integer array
 */
public class HeapSort {
    /**
     * This function sorts the array arr between index start and end
     * (both inclusive) in ascending order. This method uses a dHeap
     * instance or directly heapifys the array.
     */
    public static void heapSort(int[] arr, int start, int end) {
        /* I loop through start to end (inclusive) and add it
        * to my min-heap and remove it immediatly to assign it to
        * the array. */
        dHeap<Integer> SortQueue = new dHeap<>(2,6,false);
        for (int mystart = start; mystart < end; mystart++){
            SortQueue.add(arr[mystart]);
        }
        for (int mystart = start; mystart < end; mystart++){
            arr[mystart] = SortQueue.remove();
        }

    }
}
