package edu.grinnell.csc207.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queues implemented with arrays.
 *
 * @author Samuel A. Rebelsky
 * @author Princess Alexander
 * @author David William Stroud
 */
public class ArrayBasedQueue<T> implements Queue<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The values stored in the queue.
   */
  T[] values;

  /**
   * The index of the front of the queue.
   */
  int front;

  /**
   * The number of elements in the queue.
   */
  int size;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new queue that holds up to capacity elements.
   */
  @SuppressWarnings({"unchecked"})
  public ArrayBasedQueue(int capacity) throws Exception {
    if (capacity <= 0) {
      throw new Exception("Queues must have a positive capacity.");
    } // if (capacity <= 0)
    // Yay Java! It's not possible to say new T[capacity], so we use
    // this hack and suppress warnings with the annotation above.
    this.values = (T[]) new Object[capacity];
    this.front = 0;
    this.size = 0;
  } // ArayBasedQueue(int capacity)

  // +---------------+---------------------------------------------------
  // | Queue Methods |
  // +---------------+

  @Override
  public boolean isEmpty() {
    return this.size == 0; // CORRECTION
  } // isEmpty()

  @Override
  public boolean isFull() {
    return this.size == this.values.length; // MADE CORRECTION
  } // isFull()

  @Override
  public void put(T val) throws Exception {
    if (this.isFull()) {
      throw new Exception("no more room!");
    } // this.isFull()
    this.values[this.back()] = val;
    ++this.size;
  } // put(T)

  @Override
  public T get() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("empty");
    } // if empty
    // Grab and clear the element at the front of the queue
    T result = this.values[this.front];
    this.values[this.front] = null;
    this.front = (this.front + 1) % this.values.length; // CORRECTION: Wraparound fix
    --this.size;
    // And we're done
    return result;
  } // get(T)

  @Override
  public T peek() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("empty");
    } // if empty
    return this.values[this.front];
  } // peek()

  @Override
  public T dequeue() throws Exception {
    return this.get();
  } // dequeue

  @Override
  public void enqueue(T val) throws Exception {
    this.put(val);
  } // enqueue

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int offset = 0;


      @Override
      public T next() throws NoSuchElementException {
        if (!this.hasNext()) {
          throw new NoSuchElementException("no elements remain");
        } // if no elements
        T result = values[(offset + front) % values.length];
        offset = (offset + 1);
        return result;

      } // next()
    
      @Override
      public boolean hasNext() {
        return offset >= size;
      } // hasNext()
    
      @Override
      public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
      } // remove()
    };
  } // iterator()

  // +----------------+--------------------------------------------------
  // | Helper Methods |
  // +----------------+

  /**
   * Get the index of the back of the queue. MADE CORRECTIONS
   * The back is where we add the next element.
   */
  int back() {
    return (this.front + this.size) % this.values.length;
  } // back()

} // class ArrayBasedQueue<T>