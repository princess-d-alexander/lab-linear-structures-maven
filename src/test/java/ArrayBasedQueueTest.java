import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.linear.ArrayBasedQueue;

public class ArrayBasedQueueTest {

    private ArrayBasedQueue<String> queue;

    // Setup method to initialize the queue before each test
    @BeforeEach
    public void setup() throws Exception {
        queue = new ArrayBasedQueue<>(3);  // Capacity of 3 for the queue
    }

    // Test that enqueue and dequeue work correctly in the basic case
    @Test
    public void testEnqueueDequeue() throws Exception {
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals("a", queue.dequeue(), "First dequeued element should be 'a'");
        assertEquals("b", queue.dequeue(), "Second dequeued element should be 'b'");
        assertEquals("c", queue.dequeue(), "Third dequeued element should be 'c'");
    }

    // Test that isEmpty returns true for an empty queue
    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(queue.isEmpty(), "Queue should be empty initially");
        queue.enqueue("a");
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueuing an element");
        queue.dequeue();
        assertTrue(queue.isEmpty(), "Queue should be empty again after dequeuing all elements");
    }

    // Test that isFull returns true when the queue is full
    @Test
    public void testIsFull() throws Exception {
        assertFalse(queue.isFull(), "Queue should not be full initially");
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertTrue(queue.isFull(), "Queue should be full after enqueuing 3 elements");
    }

    // Test that the queue handles wrap-around correctly
    @Test
    public void testWrapAround() throws Exception {
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.dequeue();  // Dequeue one element to make space
        queue.enqueue("d");  // This should go to the front of the array due to wrap-around
        assertEquals("b", queue.dequeue(), "After wrap-around, first dequeued element should be 'b'");
        assertEquals("c", queue.dequeue(), "After wrap-around, second dequeued element should be 'c'");
        assertEquals("d", queue.dequeue(), "After wrap-around, third dequeued element should be 'd'");
    }
}
