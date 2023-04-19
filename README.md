# Assign2-ADS Documentation 

## MyArrayList.java

## :heavy_plus_sign: size 
**Description**: *This method returns the number of elements in the array.*

```java
public int size() {
        return size;
    }
```

## :heavy_plus_sign: contains 
**Description**: *This method contains whether the array includes the requested object. If the object is present in the array, it returns true; otherwise, it returns false.*

```java
public boolean contains(Object o) {
        for(int i = 0; i<size; i++){
            if (arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }
```

## :heavy_plus_sign: add 
**Description**: *This method adds an element to the end of the array. If the array is full, this leads to an increase in the size of the array.*

```java
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
```

## :heavy_plus_sign: add 
**Description**: *This method adds an element at a specified index in the array. If the array is full, this leads to an increase in the size of the array. It shifts all the elements from the specified index to the end of the array one position to the right before inserting the new element.*

```java
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
```

## :heavy_plus_sign: remove
**Description**: *This method removes the element from the array at the given index. After removing the element, it moves all the remaining elements from the supplied index to the array's end by one position to the left.
.*

```java
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
```


## :heavy_plus_sign: remove
**Description**: *This method removes the element at the specified index from the array. It shifts all the elements from the specified index to the end of the array one position to the left after removing the element.*

```java
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
```


## :heavy_plus_sign: clear
**Description**: *This method clears the array by setting its size to 0 and creating a new array of length 5.*

```java
public void clear() {
        this.arr = (E[]) new Object[5];
        this.size = 0;
    }
```


## :heavy_plus_sign: get
**Description**: *This method returns the element at the specified index in the array.*

```java
public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }
```


## :heavy_plus_sign: indexOf
**Description**: *This method returns the index of the first occurrence of the specified object in the array. If the object is not found, it returns -1.*

```java
public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    } 
```

## :heavy_plus_sign: lastIndexOf
**Description**: *This method returns the index of the last occurrence of the specified object in the array. If the object is not found, it returns -1.*

```java
public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
```


## :heavy_plus_sign: checkIndex
**Description**: *This is a helper method that checks if the specified index is valid for the array. If the index is less than 0 or greater than or equal to the size of the array, it throws an IndexOutOfBoundsException.*

```java
public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
```
