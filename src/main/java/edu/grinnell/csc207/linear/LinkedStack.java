package edu.grinnell.csc207.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple array-based stack.
 *
 * @author Samuel A. Rebelsky
 * @author Princess Alexander
 */
public class LinkedStack<T> implements Stack<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The top of the stack.
   */
  Node<T> top;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new stack.
   */
  public LinkedStack() {
    this.top = null;
  } // LinkedStack(int)

  // +-------------------------+-----------------------------------------
  // | LinearStructure Methods |
  // +-------------------------+

  @Override
  public boolean isEmpty() {
    return this.top == null;
  } // isEmpty()

  @Override
  public boolean isFull() {
    return false;
  } // isFull()

  // @Override
  // public T peek() {
  //   return this.top.value;
  // } // peek()

  // Peek at the top element without removing it (Modified)
  @Override
  public T peek() throws Exception {
      if (this.isEmpty()) {
          throw new Exception("Stack is empty");
      }
      return this.top.value;
  }

  @Override
  public void put(T val) throws Exception {
    if (this.isFull()) {
      throw new Exception("full");
    } // if full
    this.top = new Node<T>(val, this.top);
  } // put(T)

  @Override
  public T get() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("empty");
    } // if empty
    T result = this.top.value;
    this.top = this.top.next;
    return result;
  } // get()

  @Override
  public Iterator<T> iterator() {
    return new LinkedStackIterator<T>(this);
  } // iterator()

  // +---------------+---------------------------------------------------
  // | Stack Methods |
  // +---------------+

  // @Override
  // public void push(T val) throws Exception {
  //   this.put(val);
  // } // push(T)
  // Push an element onto the stack
  @Override
  public void push(T val) {
      this.top = new Node<T>(val, this.top);  // (Modified) New node points to the previous top
  }

  // @Override
  // public T pop() throws Exception {
  //   return this.get();
  // } // pop

  // Pop the top element from the stack
  @Override
  public T pop() throws Exception {
      if (this.isEmpty()) {
          throw new Exception("Stack is empty");
      }
      T result = this.top.value;
      this.top = this.top.next;  // (Modified) Move the top to the next node
      return result;
  }

} // LinkedStack<T>


class LinkedStackIterator<T> implements Iterator<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The next node in the iteration.
   */
  Node<T> next;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public LinkedStackIterator(LinkedStack<T> ls) {
    this.next = ls.top;
  } // LinkedStackIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next() throws NoSuchElementException {
    T result = this.next.value;
    this.next = this.next.next;
    return result;
  } // next()

  @Override
  public boolean hasNext() {
    return (this.next != null);
  } // hasNext()

  @Override
  public void remove() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  } // remove()
} // LinkedStackIterator<T>
