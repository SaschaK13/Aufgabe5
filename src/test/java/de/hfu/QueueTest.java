package de.hfu;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    @Test(expected = IllegalArgumentException.class, timeout = 1000)
    public void testNullQueue() {
        Queue queue = new Queue(0);
    }

    @Test(expected = IllegalStateException.class, timeout = 1000)
    public void testDequeueEmptyQueue() {
        Queue queue = new Queue(1);
        queue.dequeue();
    }

    @Test
    public void testEnqueue() {
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(9);
        assertEquals(1, queue.queue[0]);
        assertEquals(5, queue.queue[1]);
        assertEquals(9, queue.queue[2]);

        //zuletzt eingefügtes Element wird überschrieben
        queue.enqueue(7);
        assertEquals(7, queue.queue[2]);
        queue.enqueue(8);
        assertEquals(8, queue.queue[2]);
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        assertEquals(1, queue.head);
        queue.dequeue();
        assertEquals(2, queue.head);
    }
}
