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
**Description**: *This method determines whether the array includes the requested object. If the object is present in the array, it returns true; otherwise, it returns false.*

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

