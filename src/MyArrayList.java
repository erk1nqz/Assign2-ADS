
public class MyArrayList<E> implements MyList {
    private E[] arr;
    private int size;
    public MyArrayList() {
        this.arr = (E[]) new Object[5];
        this.size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i<size; i++){
            if (arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }

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

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void clear() {
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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
