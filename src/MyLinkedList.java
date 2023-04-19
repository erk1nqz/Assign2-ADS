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
    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

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

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

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

    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}