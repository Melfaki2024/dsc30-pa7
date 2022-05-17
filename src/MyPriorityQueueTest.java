/*
 * Name: Mohamed Elmostafa Elfaki
 * PID:  A16317776
 */

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyPriorityQueueTest {
    @Test
    public void MyPriorityQueue_constuctor_test1(){
        MyPriorityQueue<Integer> test = new MyPriorityQueue<>(6);
        test.offer(10);
        test.offer(15);
        test.offer(56);
        test.offer(67);
        test.offer(9);
        assert (test.poll().equals(67));
    }
    @Test
    public void MyPriorityQueue_constuctor_test2() {
        MyPriorityQueue<Integer> test = new MyPriorityQueue<>(6);
        test.offer(10);
        test.offer(15);
        test.offer(56);
        test.offer(67);
        test.offer(9);
        assert (test.peek().equals(67));
    }
    @Test
    public void MyPriorityQueue_constuctor_test3() {
        MyPriorityQueue<Integer> test = new MyPriorityQueue<>(6);
        test.offer(10);
        test.offer(15);
        test.offer(56);
        test.offer(67);
        test.offer(9);
        test.poll();
        test.poll();
        test.poll();
        assert (test.peek().equals(10));
    }

}