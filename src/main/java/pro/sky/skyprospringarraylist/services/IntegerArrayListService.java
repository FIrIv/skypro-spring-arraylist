package pro.sky.skyprospringarraylist.services;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringarraylist.exceptions.MyArrayIndexOutOfBoundsException;
import pro.sky.skyprospringarraylist.interfaces.StringList;

@Service
public class IntegerArrayListService implements StringList {
    private Integer [] array;
    private int size = 0;
    private int maxSize = 5;

    public IntegerArrayListService() {
        this.array = new Integer [this.maxSize];
    }

    // Расширение массива вдвое при заполнении.
    private void doubleTheMaxSize() {
        this.maxSize = this.maxSize*2+1;
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
    public String add(String item) {
        return null;
    }

    @Override
    public String add(int index, String item) {
        return null;
    }

    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}
