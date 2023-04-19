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

