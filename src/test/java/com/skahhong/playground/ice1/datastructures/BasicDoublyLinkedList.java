package com.skahhong.playground.ice1.datastructures;

public class BasicDoublyLinkedList<E> {

  //---------------- nested Node class ----------------
  /**
   * Node of a doubly linked list, which stores a reference to its
   * element and to both the previous and next node in the list.
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;               // reference to the element stored at this node

    /** A reference to the preceding node in the list */
    private Node<E> prev;            // reference to the previous node in the list

    /** A reference to the subsequent node in the list */
    private Node<E> next;            // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param p  reference to a node that should precede the new node
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> p, Node<E> n) {
      element = e;
      prev = p;
      next = n;
    }

    // public accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that precedes this one (or null if no such node).
     * @return the preceding node
     */
    public Node<E> getPrev() { return prev; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Update methods
    /**
     * Sets the node's previous reference to point to Node n.
     * @param p    the node that should precede this one
     */
    public void setPrev(Node<E> p) { prev = p; }

    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------
 
   // instance variables of the BasicDoublyLinkedList
  private Node<E> head;                    // header sentinel

  /** Sentinel node at the end of the list */
  private Node<E> tail;                   // trailer sentinel

  /** Number of elements in the list (not including sentinels) */
  private int size = 0;                      // number of elements in the list

  /** Constructs a new empty list. */
  public BasicDoublyLinkedList() {} //constructs an initially empty list

  // public accessor methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  public int getSizeSlow() {
    int count = 0;

    Node<E> walk = head;

    while(walk != null) {
      count++;

      walk = walk.getNext();
    }

    return count;
  }

  public int getSizeFast() {
    if(head == null) {
      return 0;
    }

    int count = 1;

    Node<E> walkHead = head;
    Node<E> walkTail = tail;

    while(walkHead != tail ) {
      if(walkHead == walkTail) {
        count++;
        return count;
      } else if (walkHead.getPrev() == walkTail) {
        return count;
      }

      walkHead = walkHead.getNext();
      walkTail = walkTail.getPrev();
    }

    return count;
  }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list.
   * @return element at the front of the list (or null if empty)
   */
  public E first() {
    if (isEmpty()) return null;
    return head.getElement();   // first element is beyond header
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {
    if (isEmpty()) return null;
    return tail.getElement();    // last element is before trailer
  }

   // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    head = new Node<>(e, null, head);        // create and link a new node
    if (isEmpty())
      tail = head;                           // special case: new node becomes tail also
    else
      head.next.setPrev(head);
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) {                 // adds element e to the end of the list
    Node<E> newest = new Node<>(e, tail, null);    // node will eventually be the tail
    if (isEmpty())
      head = newest;                         // special case: previously empty list
    else
      tail.setNext(newest);                  // new node after existing tail
    tail = newest;                           // new node becomes the tail
    size++;
  }
 
  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    E answer = head.getElement();
    head = head.getNext();                   // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null;                           // special case as list is now empty
    else
      head.setPrev(null);                    // if not empty set the head's backward reference
    return answer;
  }

  /**
   * Removes and returns the last element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeLast() {
    if (isEmpty()) return null;              // nothing to remove
    E answer = tail.getElement();
    tail = tail.getPrev();                   // will become null if list had only one node    
    size--;
    if (size == 0)
      head = null;                           // special case as list is now empty
    else
      tail.setNext(null);                    // if not empty set the tail's forward reference
    return answer;
  }

  @SuppressWarnings({"unchecked"})
  public boolean equals(Object o) {
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;
    BasicDoublyLinkedList<E> other = (BasicDoublyLinkedList<E>) o;   // use nonparameterized type
    if (size != other.size) return false;
    Node<E> walkA = head;                               // traverse the primary list
    Node<E> walkB = other.head;                         // traverse the secondary list
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;   // if we reach this, everything matched successfully
  }

  public int hashCode() {
    int h = 0;
    for (Node<E> walk=head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
      h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
    }
    return h;
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }

  public E getMiddleOld() {
    if(head == null) return null;

    Node<E> singleWalker = head;
    Node<E> doubleWalker = head;

    int timesDoubleWalkerMoved = 0;
    while(doubleWalker.getNext() != null) {
      doubleWalker = doubleWalker.getNext();

      timesDoubleWalkerMoved++;

      if(timesDoubleWalkerMoved != 0 && timesDoubleWalkerMoved % 2 == 0) {
        singleWalker = singleWalker.getNext();
      }
    }

    return singleWalker.getElement();
  }

  public E getMiddleNew() {
    if (head == null) return null;

    Node<E> singleWalker = head;
    Node<E> doubleWalker = head;

    while (doubleWalker.getNext() != null) {
      doubleWalker = doubleWalker.getNext().getNext();
      if(doubleWalker == null) return singleWalker.getElement();
      singleWalker = singleWalker.getNext();
    }

    return singleWalker.getElement();
  }

  public E getMiddleOptimized() {
    if (head == null) return null;

    Node<E> singleWalker = head;
    Node<E> doubleWalker = head;

    while (doubleWalker.getNext() != null && doubleWalker.getNext().getNext() != null) {
      singleWalker = singleWalker.getNext();
      doubleWalker = doubleWalker.getNext().getNext();
    }

    return singleWalker.getElement();
  }

  public static void main(String[] args){

      BasicDoublyLinkedList<Integer> emptyList = new BasicDoublyLinkedList<Integer>();
      emptyList.addFirst(2);
      emptyList.addLast(1);
      System.out.println(emptyList.getMiddleNew());

      BasicDoublyLinkedList<Integer> myList = new BasicDoublyLinkedList<Integer>();
      myList.addLast(1);
      myList.addLast(2);
      myList.addLast(3);
      myList.addLast(4);
      myList.addLast(5);
      System.out.println(myList.getMiddleNew());

      BasicDoublyLinkedList<Integer> urList = new BasicDoublyLinkedList<Integer>();
      urList.addFirst(2);
      urList.addLast(1);
      System.out.println(myList.getMiddleNew());

//      System.out.println(urList.size());
  }
}
