public class MyLinkedList <E> implements MyList {
    private int size;
    private Node<E> head;
    private Node<E> tail;
    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    /**
     * @function size returns the length of the LinkedList
     * @noparams
     * @return int
     * **/
    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
    /**
     * @function contains true if Object o in LinkedList
     * @param o search object
     * @return boolean
     * **/
    @Override
    public boolean contains(Object o) {
        if (head.element == o) {
            return true;
        }
        Node<E> ptr = head.next;
        while (ptr != null) {
            if (ptr.equals(o)) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }
    /**
     * @function add adds an object to the LinkedList
     * @param item object to add
     * @return void
     * **/
    @Override
    public void add(Object item) {
        Node<E> newNode = new Node<E>((E) item, null, null);
        if (head == null) {
            head = newNode;
            tail=head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    /**
     * @function add adds an object to a specific index
     * @param item object to add
     * @param index index where to add item
     * @return void
     * **/

    @Override
    public void add(Object item, int index) {
        checkIndex(index);
        Node<E> newNode = new Node<E>((E) item, null, null);
        if (index == 0) {
            add(item);
            return;
        }
        Node<E> ptr = head;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                Node<E> temp = ptr.next;
                ptr.next = newNode;
                newNode.prev = ptr;
                newNode.next = temp;
                temp.prev = newNode;
            }
            ptr = ptr.next;
        }
        size++;
    }
    /**
     * @function remove removes an object from the LinkedList
     * @param item object of deletion
     * @return boolean
     * **/

    @Override
    public boolean remove(Object item) {
        Node<E> newNode = new Node<E>((E) item, null, null);
        if (head.element== newNode.element) {
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        Node<E> ptr = head.next;
        while (ptr != null) {
            if (ptr.element == newNode.element) {
                Node<E> temp = ptr.prev;
                temp.next = ptr.next;
                Node<E> temp2 = ptr.next;
                temp2.prev = temp;
                size--;
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }
    /**
     * @function remove removes an object from the LinkedList
     * @param index index of the item to delete
     * @return Object
     * **/

    @Override
    public Object remove(int index) {
        checkIndex(index);
        if (index == 0) {
            Object removed = head.element;
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return removed;
            }
            head = head.next;
            head.prev = null;
            size--;
            return removed;
        }
        if (index == size-1) {
            Object removed = tail.element;
            tail = tail.prev;
            tail.next = null;
            size--;
            return removed;
        }
        Node<E> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (index == i) {
                Node<E> p = ptr.prev;
                Node<E> n = ptr.next;
                Object removed = ptr.element;

                p.next = n;
                n.prev = p;
                size--;
                return removed;
            }
            ptr = ptr.next;
        }
        return null;
    }
    /**
     * @function clear clears the LinkedList
     * @noparam
     * @return void
     * **/
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    /**
     * @function get returns an object from the LinkedList under its index
     * @param index object index
     * @return E
     * **/

    @Override
    public Object get(int index) {
        checkIndex(index);
        if (index == 0) {
            return head.element;
        }
        Node<E> newNode = head.next;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                return newNode.element;
            }
            newNode = newNode.next;
        }
        return null;
    }
    /**
     * @function indexOf returns the index of the first occurrence of the object
     * @param o search object
     * @return int
     * **/

    @Override
    public int indexOf(Object o) {
        Node<E> newNode = new Node<E>((E) o, null, null);
        if (head.element == newNode.element) {
            return 0;
        }
        Node<E> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (ptr.element == newNode.element) {
                return i;
            }
            ptr = ptr.next;
        }
        return -1;
    }
    /**
     * @function lastIndexOf returns the index of the last occurrence of the object in the LinkedList
     * @param o search object
     * @return int
     * **/


    @Override
    public int lastIndexOf(Object o) {
        Node<E> newNode = new Node<E>((E) o, null, null);
        if (tail.element == newNode.element) {
            return size-1;
        }
        Node<E> ptr = tail.prev;
        for (int i = size-1; i >= 1; i--) {
            if (ptr.element == newNode.element) {
                return i;
            }
            ptr = ptr.prev;
        }
        return -1;
    }

    @Override
    public void sort() {

    }
    /**
     * @function checkIndex checks the index for its validity
     * @param index index
     * @return void
     * **/

    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}