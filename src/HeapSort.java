/*
 * Name: Mohamed Elmostafa Elfaki
 * PID:  A16317776
 */

/**
 * This class implements a sorting algorithm that uses the heap structure to sort
 * the input integer array
 * @author Mohamed Elmostafa Elfaki
 * @since May 16th, 2022
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
        int defaultSize = 6;
        int defaultBranchingFactor = 2;
        dHeap<Integer> SortQueue = new dHeap<>(defaultBranchingFactor,defaultSize,false);
        for (int mystart = start; mystart < end; mystart++){
            SortQueue.add(arr[mystart]);
        }
        for (int mystart = start; mystart < end; mystart++){
            arr[mystart] = SortQueue.remove();
        }

    }
}
