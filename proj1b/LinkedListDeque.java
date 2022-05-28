public class LinkedListDeque<T> implements Deque<T> {

    private Node sentinel;
    private int size;

    private class Node {
        protected T value;
        protected Node prev;
        protected Node next;

        Node(T val, Node p, Node n) {
            value = val;
            prev = p;
            next = n;
        }

        Node(Node p, Node n) {
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Adds an item of type `T` to the front of the deque.
     */
    @Override
    public void addFirst(T value) {
        Node node = new Node(value, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
    }

    /**
     * Adds an item of type `T` to the back of the deque.
     */
    @Override
    public void addLast(T value) {
        Node node = new Node(value, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space
     */
    @Override
    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr.next != sentinel) {
            System.out.print(ptr.value);
            System.out.print(" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    /**
     * Returns the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node removeNode = sentinel.next;
        sentinel.next = removeNode.next;
        removeNode.next.prev = sentinel;
        size--;
        return removeNode.value;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node removeNode = sentinel.prev;
        removeNode.prev.next = sentinel;
        sentinel.prev =  removeNode.prev;
        size--;
        return removeNode.value;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     */
    @Override
    public T get(int index) {
        int i = 0;
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            if (i == index) {
                return ptr.value;
            }
            i++;
            ptr = ptr.next;
        }
        return null;
    }

    private T getRecursiveHelper(Node ptr, int index, int target) {
        if (index == target) {
            return ptr.value;
        } else if (ptr == sentinel) {
            return null;
        } else {
            return getRecursiveHelper(ptr.next, index + 1, target);
        }
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, 0, index);
    }
}
