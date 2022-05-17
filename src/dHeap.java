/*
 * Name: Mohamed Elmostafa Elfaki
 * PID:  A16317776
 */

import java.util.*;

/**
 * This class implements the head interface to create d-ary heaps.
 * 
 * @param <T> Generic type
 */
public class dHeap<T extends Comparable<? super T>> implements dHeapInterface<T> {

    private T[] heap; // heap array
    private int d; // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // boolean to indicate whether heap is max or min
    private int HEAP_DEFAULT_SIZE = 6;
    private int BINARY_SIZE = 2;
    private int DOUBLING_SIZE = 2;
    private int initial_size;

    /**
     * Initializes a binary max heap with capacity = 6
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        heap = (T[]) new Comparable[HEAP_DEFAULT_SIZE];
        d = BINARY_SIZE;
        nelems = 0;
        isMaxHeap = true;
        initial_size = 0;
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        heap = (T[]) new Comparable[heapSize];
        d = BINARY_SIZE;
        nelems = 0;
        isMaxHeap = true;
        initial_size = heapSize;
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        /* TODO */
        if (d < 1){
            throw new IllegalArgumentException();
        }
        heap = (T[]) new Comparable[heapSize];
        this.d = d;
        nelems = 0;
        initial_size = heapSize;
        if (isMaxHeap == true){
            this.isMaxHeap  = true;
        }
        else{
            this.isMaxHeap = false;
        }
    }

    /**
     * Returns the number of elements stored in the heap.
     *
     * @returns the number of elements of the heap.
     */
    @Override
    public int size() {
        int num_elements = 0;
        for (int i = 0; i< heap.length; i++){
            if (heap[i] != null){
                num_elements++;
            }
        }
        return num_elements;
    }

    /**
     * Adds the given data to the heap.
     *
     * @throws NullPointerException if the data is null.
     */
    @Override
    public void add(T data) throws NullPointerException {
        /* first I create a local variable index which records
         * the latest added value to my tree. I also use local variable
         * heap_full to ascertain if I have to resize my heap. I also
         * then use a for loop to actually add the data into my heap
         * so that I can, when I reach the point that heap is null,
         * use bubbleUp to shift the tree into proper order. */
        if (data == null){
            throw new NullPointerException();
        }
        int index = 0;
        int heap_full = heap.length - 1;
        //I first have to add the data
        for (int i = 0; i < heap.length; i++){
            if (heap[i] == null){
                heap[i] = data;
                index = i;
                bubbleUp(index);
                return;
            }
            else if (heap_full == 0){
                resize();
            }
            heap_full --;
        }
    }

    /**
     * Returns and removes the root element from the heap.
     *
     * @throws NoSuchElementException if the heap is empty.
     * @return the removed root element.
     */
    @Override
    public T remove() throws NoSuchElementException {
        /* first I check if the array only contains one node, if so, I
        * just remove that node and return it, else, I take the root node
        * and assign it to the latest added node and assign that node to null.
        * After this, I use trickleDown from the top to shift the tree into
        * proper order. */
        if (heap[0] == null){ //heap is empty
            throw new NoSuchElementException();
        }
        if (size() == 1){ //if this array is empty
            T temp = heap[0];
            heap[0] = null;
            return temp;
        }
        else{
            T temp = heap[0];
            heap[0] = heap[size() - 1];
            heap[size() - 1] = null;
            trickleDown(0);
            return temp;
        }
    }

    /**
     * Clears all elements in the heap.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        heap = (T[]) new Comparable[initial_size];
    }

    /**
     * Returns the root element of the heap.
     *
     * @throws NoSuchElementException if the heap is empty.
     * @return the root of the heap.
     */
    public T element() throws NoSuchElementException {
        /* TODO */
        if (heap[0] == null){
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    /**
     * This function percolates downward the heap tree and
     * shifts it around so that one of the propertys, min or
     * max, is maintained.
     */
    private void trickleDown(int index) {
        /* This is a percolating down algorithm for both min-heap and max-heap. */
        int child_index = d * index + 1;
        T value = heap[index];
        while (child_index < size()){
            T neut_value = value;
            int neut_index = -1;
            for (int i = 0; i < d && i + child_index < size(); i++){
                if (heap[i + child_index].compareTo(neut_value) > 0 && isMaxHeap == true){ //if this child is greater
                    neut_value = heap[i + child_index];
                    neut_index = i + child_index;
                }
                else if (heap[i + child_index].compareTo(neut_value) < 0 && isMaxHeap == false){
                    neut_value = heap[i + child_index];
                    neut_index = i + child_index;
                }
            }
            if (neut_value == value){
                return;
            }
            else{
                T temp = heap[index];
                heap[index] = heap[neut_index];
                heap[neut_index] = temp;
                index = neut_index;
                child_index = d + index + 1;
            }
        }
    }
    /**
     * This function percolates upward the heap tree and
     * shifts it around so that one of the propertys, min or
     * max, is maintained.
     */
    private void bubbleUp(int index) {
        /* This is a percolating up algorithm for both min-heap and max-heap. */
        while (index > 0){
            int parent_index = parent(index);
            if (heap[index].compareTo(heap[parent_index]) <= 0 && isMaxHeap == true){
                return;
            }
            else if (heap[parent_index].compareTo(heap[index]) <= 0 && isMaxHeap == false){
                return;
            }
            else {
                T temp = heap[index];
                heap[index] = heap[parent_index];
                heap[parent_index] = temp;
                index = parent_index;
            }
        }
    }
    /**
     * This function doubles the heap size.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        /* TODO */
        T[] array_copy = (T[]) new Comparable[heap.length * DOUBLING_SIZE];
        for (int i = 0; i< heap.length;i++){
            array_copy[i] = heap[i];
        }
        heap = array_copy;
    }
    /**
     * This function returns the index of the parent node.
     *
     * @return the index of the parent node.
     */
    private int parent(int index) {
        return (index - 1) / d;
    }

}
