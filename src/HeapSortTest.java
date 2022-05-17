/*
 * Name: Mohamed Elmostafa Elfaki
 * PID:  A16317776
 */

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class HeapSortTest {
    @Test
    public void HeapSort_heapSort_test1(){
        int[] test = new int[]{5,4,3,2,1};
        HeapSort.heapSort(test,0,test.length);
    }
    @Test
    public void HeapSort_heapSort_test2(){
        int[] test = new int[]{3,1,5,4,2};
        HeapSort.heapSort(test,0,test.length);
    }
    @Test
    public void HeapSort_heapSort_test3(){
        int[] test = new int[]{3,3,5,4,2};
        HeapSort.heapSort(test,0,test.length);
    }
    @Test
    public void HeapSort_heapSort_test4(){
        int[] test = new int[]{1,2,5,4,3};
        HeapSort.heapSort(test,2,test.length);
    }

}