package pro.sky.skyprospringarraylist.services;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringarraylist.exceptions.ItemNotFoundException;
import pro.sky.skyprospringarraylist.exceptions.MyArrayIndexOutOfBoundsException;
import pro.sky.skyprospringarraylist.exceptions.TypeIsNotValidException;
import pro.sky.skyprospringarraylist.interfaces.MyArrayList;

@Service
public class StringArrayList implements MyArrayList<String> {
    private String [] array;
    private int size = 0;
    private int maxSize = 5;

    public StringArrayList() {
        this.array = new String [this.maxSize];
    }

    // Расширение массива вдвое при заполнении.
    private void grow() {
        this.maxSize = this.maxSize*3/2;
        String [] doubleArray = new String[this.maxSize];
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
    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    public String add(String item) {
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
    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    public String add(int index, String item) {
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
    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    public String set(int index, String item) {
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
    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    public String remove(String item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException();
        } else {
            String temp = this.array[index];
            shiftToLeft(index);
            return temp;
        }
    }

    @Override
    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    public String remove(int index) {
        if (index<0 || index>=this.size) {
            throw new MyArrayIndexOutOfBoundsException();
        }
        else {
            String temp = this.array[index];
            shiftToLeft(index);
            return temp;
        }
    }

    @Override
    // Проверка на существование элемента.
    // Вернуть true/false;
    public boolean contains(String item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        for (int i=0; i<this.size; i++) {
            if (this.array[i].equals(item)) return true;
        }
        return false;
    }

    @Override
    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    public int indexOf(String item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        for (int i=0; i<this.size; i++) {
            if (this.array[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    public int lastIndexOf(String item) {
        if (item == null ) {
            throw new NullPointerException();
        }
        for (int i=this.size-1; i>=0; i--) {
            if (this.array[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    public String get(int index) {
        if (index<0 || index>=size) {
            throw new MyArrayIndexOutOfBoundsException();
        }
        else {
            return this.array[index];
        }
    }

    @Override
    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    public boolean equals(MyArrayList otherList) {
        if (otherList == null) {
            throw new NullPointerException();
        }
        if
        (otherList.getClass() != StringArrayList.class) {
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
    // Вернуть фактическое количество элементов.
    public int size() {
        return this.size;
    }

    @Override
    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    // Удалить все элементы из списка.
    public void clear() {
        for (int i=0; i<this.size; i++) {
            this.array[i]=null;
        }
        size=0;
    }

    @Override
    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    public String[] toArray() {
        String [] array2 = new String[this.size];
        System.arraycopy(this.array, 0, array2, 0, this.size);
        return array2;
    }
}
