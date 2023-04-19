
public class MyArrayList<E> implements MyList {
    private E[] arr;
    private int size;
    /**
     * @function constructor
     * @noparam
     * @return void
     **/
    public MyArrayList() {
        this.arr = (E[]) new Object[5];
        this.size = 0;
    }
    /**
     * @function size outputs the length of the array
     * @noparams
     * @return int
     * **/
    @Override
    public int size() {
        return size;
    }
    /**
     * @function contains true if Object o in array
     * @param o search object
     * @return boolean
     * **/

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i<size; i++){
            if (arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    /**
     * @function add adds an object to the array
     * @param item object to add
     * @return void
     * **/

    @Override
    public void add(Object item) {
        if (size == arr.length){
            E[] newArr = (E[]) new Object[arr.length*2];
            for (int i=0; i< arr.length; i++){
                newArr[i] = arr[i];
            }
            arr=newArr;
        }
        arr[size++]=(E) item;
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
        if (size == arr.length){
            E[] newArr = (E[]) new Object[arr.length*2];
            for(int i=0; i<size; i++){
                newArr[i]=arr[i];
            }
            arr=newArr;

        }
        for (int i = size - 1; i>=index; i--){
            arr[i + 1]=arr[i];
        }
        arr[index]=(E)item;
        size++;
    }
    /**
     * @function remove removes an object from the array
     * @param item object of deletion
     * @return boolean
     * **/
    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
        return false;
    }
    /**
     * @function remove removes an object from the array
     * @param index index of the item to delete
     * @return Object
     * **/

    @Override
    public Object remove(int index) {
        checkIndex(index);
        E removedElement = (E) arr[index];
        for (int i = index; i< size-1; i++){
            arr[i]=arr[i+1];
        }
        arr[size - 1] = null;
        size--;
        return removedElement;
    }
    /**
     * @function clear clears the array
     * @noparam
     * @return void
     * **/

    @Override
    public void clear() {
        this.arr = (E[]) new Object[5];
        this.size = 0;
    }
    /**
     * @function get returns an object from the array under its index
     * @param index object index
     * @return Object
     * **/
    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }
    /**
     * @function indexOf returns the index of the first occurrence of the object
     * @param o объект for search
     * @return int
     * **/

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @function lastIndexOf returns the index of the last occurrence of the object in the array
     * @param o объект for search
     * @return int
     * **/

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void sort() {
    }
    /**
     * @function checkIndex checks the index for its validity within the data structure
     * @param index index
     * @return void
     * **/

    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }


}
