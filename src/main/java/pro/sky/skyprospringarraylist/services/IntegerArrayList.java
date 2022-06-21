package pro.sky.skyprospringarraylist.services;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringarraylist.exceptions.ItemNotFoundException;
import pro.sky.skyprospringarraylist.exceptions.MyArrayIndexOutOfBoundsException;
import pro.sky.skyprospringarraylist.exceptions.TypeIsNotValidException;
import pro.sky.skyprospringarraylist.interfaces.MyArrayList;

@Service
public class IntegerArrayList implements MyArrayList<Integer> {
    private Integer [] array;
    private int size = 0;
    private int maxSize = 5;

    public IntegerArrayList() {
        this.array = new Integer [this.maxSize];
    }

    // Расширение массива вдвое при заполнении.
    private void grow() {
        this.maxSize = this.maxSize*3/2;
        Integer [] doubleArray = new Integer[this.maxSize];
        if (this.size >= 0) System.arraycopy(this.array, 0, doubleArray, 0, this.size);
        this.array = doubleArray;
    }

    // затирание элемента index
    // сдвигом массива влево на 1 элемент
    private void shiftToLeft (int index) {
        if (index<0 || index>=this.size) {
            throw new MyArrayIndexOutOfBoundsException();
        }
        if (this.size - 1 - index >= 0)
            System.arraycopy(this.array, index + 1, this.array, index, this.size - 1 - index);
        this.array[this.size - 1] = null;
        this.size--;
    }

    @Override
    public Integer add(Integer item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        int index = this.size;
        if (this.size==this.maxSize) grow();
        this.array[index]=item;
        this.size++;
        return this.array[index];
    }

    @Override
    public Integer add(int index, Integer item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        if (index<0 || index>=this.size) {
            throw new MyArrayIndexOutOfBoundsException();
        }
        if (this.size==this.maxSize) grow();
        if (this.size - index >= 0) System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
        this.array[index]=item;
        this.size++;
        return this.array[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        if (index<0 || index>=this.size) {
            throw new MyArrayIndexOutOfBoundsException();
        }
        this.array[index]=item;
        return this.array[index];
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException();
        } else {
            Integer temp = this.array[index];
            shiftToLeft(index);
            return temp;
        }
    }

    @Override
    public Integer remove(int index) {
        if (index<0 || index>=this.size) {
            throw new MyArrayIndexOutOfBoundsException();
        }
        else {
            Integer temp = this.array[index];
            shiftToLeft(index);
            return temp;
        }
    }

    @Override
    public boolean contains (Integer item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        this.sort();
        return binarySearch(item);
    }

    private boolean binarySearch (Integer item) {
        int min = 0;
        int max = this.size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(this.array[mid])) {
                return true;
            }

            if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        for (int i=0; i<this.size; i++) {
            if (this.array[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        for (int i=this.size-1; i>=0; i--) {
            if (this.array[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index<0 || index>=size) {
            throw new MyArrayIndexOutOfBoundsException();
        }
        else {
            return this.array[index];
        }
    }

    @Override
    public boolean equals(MyArrayList otherList) {
        if (otherList == null) {
            throw new NullPointerException();
        }
        if
        (otherList.getClass() != IntegerArrayList.class) {
            throw new TypeIsNotValidException();

        } else {
            if (otherList.size() != this.size) return false;
            for (int i=0; i<this.size; i++) {
                if (!this.array[i].equals(otherList.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        for (int i=0; i<this.size; i++) {
            this.array[i]=null;
        }
        size=0;
    }

    @Override
    public Integer[] toArray() {
        Integer [] array2 = new Integer[this.size];
        System.arraycopy(this.array, 0, array2, 0, this.size);
        return array2;
    }

    // рекурсивная быстрая сортировка
    private void sort() {
        Sort.quickSort (this.array, 0, this.array.length-1);
    }
}
