/*
 * Name: Mohamed Elmostafa Elfaki
 * PID:  A16317776
 */

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class dHeapTester {
    @Test
    public void dheap_constuctor_test1(){
        dHeap<Integer> test = new dHeap<>();
        assert (test.size() == 0);
    }
    @Test
    public void dheap_constuctor_test2(){
        dHeap<Integer> test = new dHeap<>();
        test.add(5);
        assert (test.size() == 1);
    }
    @Test
    public void dheap_constuctor_test3(){
        dHeap<Integer> test = new dHeap<>();
        test.add(5);
        Integer expected = 5;
        assert (test.element().equals(expected));
    }
    @Test
    public void dheap_constuctor2_test1(){
        dHeap<Integer> test = new dHeap<>(1);
        test.add(5);
        Integer expected = 5;
        assert (test.element().equals(expected));
    }
    @Test
    public void dheap_constuctor2_test2(){
        dHeap<Integer> test = new dHeap<>(1);
        test.add(5);
        test.add(10);
        Integer expected = 10;
        assert (test.element().equals(expected));
    }
    @Test
    public void dheap_constuctor2_test3(){
        dHeap<Integer> test = new dHeap<>(1);
        test.add(5);
        test.add(10);
        assert (test.size() == 2);
    }
    @Test
    public void dheap_constuctor3_test1(){
        dHeap<Integer> test = new dHeap<>(2,1, false);
        test.add(5);
        test.add(10);
        assert (test.size() == 2);
    }
    @Test
    public void dheap_constuctor3_test2(){
        dHeap<Integer> test = new dHeap<>(2,1, false);
        test.add(5);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        Integer expected = 5;
        assert (test.size() == 6);
    }
    @Test
    public void dheap_constuctor3_test3(){
        dHeap<Integer> test = new dHeap<>(2,1, false);
        test.add(5);
        test.remove();
        test.add(10);
        assert (test.element() == 10);
    }
    @Test (expected = IllegalArgumentException.class)
    public void dheap_constuctor3_exception1(){
        dHeap<Integer> test = new dHeap<>(0,1, false);
        test.add(5);
        test.remove();
        test.add(10);
        assert (test.element() == 10);
    }
    @Test
    public void dheap_size_test1(){
        dHeap<Integer> test = new dHeap<>(2,1, false);
        test.add(5);
        test.add(10);
        assert (test.size() == 2);
    }
    @Test
    public void dheap_size_test2(){
        dHeap<Integer> test = new dHeap<>(2,1, false);
        test.add(5);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        assert (test.size() == 6);
    }
    @Test
    public void dheap_size_test3(){
        dHeap<Integer> test = new dHeap<>(2,1, false);
        test.add(5);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.add(10);
        test.clear();
        assert (test.size() == 0);
    }
    @Test
    public void dheap_add_test1(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(10);
        assert (test.element().equals(10));
    }
    @Test
    public void dheap_add_test2(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.add(4);
        test.add(51);
        assert (test.element().equals(51));
    }
    @Test
    public void dheap_add_test3(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.add(4);
        test.add(51);
        assert (test.remove().equals(51));
    }
    @Test (expected = NullPointerException.class)
    public void dheap_add_exception1(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.add(null);
        test.add(51);
        assert (test.remove().equals(51));
    }
    @Test
    public void dheap_remove_test1(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.remove();
        test.remove();
        assert (test.remove().equals(5));
    }
    @Test
    public void dheap_remove_test2(){
        dHeap<Integer> test = new dHeap<>(7,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.remove();
        test.remove();
        test.remove();
        assert (test.remove().equals(2));
    }
    @Test
    public void dheap_remove_test3(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.remove();
        test.remove();
        test.remove();
        assert (test.remove().equals(2));
    }
    @Test (expected = NoSuchElementException.class)
    public void dheap_remove_exception1(){
        dHeap<Integer> test = new dHeap<>(6,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        assert (test.remove().equals(2));
    }
    @Test
    public void dheap_clear_test1(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.clear();
        assert (test.size() == 0);
    }
    @Test
    public void dheap_clear_test2(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.clear();
        test.add(100);
        assert (test.size() == 1);
    }
    @Test (expected = NoSuchElementException.class)
    public void dheap_clear_test3(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        test.clear();
        test.remove();
        assert (test.size() == 1);
    }
    @Test
    public void dheap_element_test1(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(2);
        assert (test.element().equals(10));
    }
    @Test
    public void dheap_element_test2(){
        dHeap<Integer> test = new dHeap<>(2,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(100);
        test.add(2);
        test.add(9999);
        test.add(1);
        assert (test.element().equals(9999));
    }
    @Test
    public void dheap_element_test3(){
        dHeap<Integer> test = new dHeap<>(3,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(100);
        test.add(2);
        test.add(9999);
        test.add(1);
        test.remove();
        assert (test.element().equals(100));
    }
    @Test (expected = NoSuchElementException.class)
    public void dheap_element_exception1(){
        dHeap<Integer> test = new dHeap<>(4,1, true);
        test.add(5);
        test.add(5);
        test.add(10);
        test.add(100);
        test.add(2);
        test.add(9999);
        test.add(1);
        test.clear();
        assert (test.element().equals(100));
    }
    @Test
    public void dheap_minheap_test1(){
        dHeap<Integer> test = new dHeap<>(4,1, false);
        test.add(5);
        test.add(10);
        assert (test.element().equals(5));
    }
    @Test
    public void dheap_minheap_test2(){
        dHeap<Integer> test = new dHeap<>(4,1, false);
        test.add(5);
        test.add(10);
        test.add(2);
        test.add(28);
        test.add(1);
        assert (test.element().equals(1));
    }
    @Test
    public void dheap_minheap_test3(){
        dHeap<Integer> test = new dHeap<>(4,1, false);
        test.add(5);
        test.add(10);
        test.add(2);
        test.add(28);
        test.add(1);
        test.remove();
        assert (test.element().equals(2));
    }
    @Test
    public void dheap_minheap_test4(){
        dHeap<Integer> test = new dHeap<>(4,1, false);
        test.add(5);
        test.add(10);
        test.add(2);
        test.add(28);
        test.add(1);
        test.remove();
        test.remove();
        assert (test.element().equals(5));
    }
    @Test (expected = NoSuchElementException.class)
    public void dheap_minheap_test5(){
        dHeap<Integer> test = new dHeap<>(4,1, false);
        test.add(5);
        test.add(10);
        test.add(2);
        test.add(28);
        test.add(1);
        test.remove();
        test.remove();
        test.clear();
        assert (test.element().equals(5));
    }
    @Test
    public void dheap_minheap_test6(){
        dHeap<Integer> test = new dHeap<>(4,1, false);
        test.add(5);
        test.add(10);
        test.add(2);
        test.add(28);
        test.add(1);
        test.remove();
        test.remove();
        assert (test.size() == 3);
    }
    @Test
    public void dheap_minheap_test7(){
        dHeap<Integer> test = new dHeap<>(4,1, false);
        test.add(5);
        test.add(10);
        test.add(2);
        test.add(28);
        test.add(1);
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        assert (test.size() == 0);
    }
    @Test
    public void dheap_minheap_test8(){
        dHeap<Integer> test = new dHeap<>(4,1, false);
        test.add(5);
        test.add(10);
        test.remove();
        test.add(1);
        test.add(93);
        test.remove();
        assert (test.element().equals(10));
    }
    @Test
    public void dheap_heap_test9(){
        dHeap<Integer> test = new dHeap<>(4,50, false);
        test.add(5);
        test.add(10);
        test.remove();
        test.add(1);
        test.add(93);
        test.remove();
        assert (test.element().equals(10));
    }

}