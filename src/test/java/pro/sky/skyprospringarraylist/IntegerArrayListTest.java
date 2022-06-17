package pro.sky.skyprospringarraylist;

import org.junit.jupiter.api.Test;
import pro.sky.skyprospringarraylist.exceptions.ItemNotFoundException;
import pro.sky.skyprospringarraylist.exceptions.MyArrayIndexOutOfBoundsException;
import pro.sky.skyprospringarraylist.exceptions.TypeIsNotValidException;
import pro.sky.skyprospringarraylist.services.IntegerArrayList;
import pro.sky.skyprospringarraylist.services.StringArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerArrayListTest {

    private final IntegerArrayList out = new IntegerArrayList();

    @Test
    public void add () {
        Integer [] expectedArray = {123, 45, 892, 65, 18, 17};

        out.add(123);
        out.add(45);
        out.add(892);
        out.add(65);
        out.add(18);
        out.add(17);
        Integer[] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void addShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            Integer s1 = null;
            out.add(s1);
        });
    }

    @Test
    public void addByIndex () {
        Integer [] expectedArray = {123, 45, 892};

        out.add(45);
        out.add(892);
        out.add(0,123);
        Integer [] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void addByIndexShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add(333);
            Integer s1 = null;
            out.add(0,s1);
        });
    }

    @Test
    public void addShouldMyArrayIndexOutOfBoundsExceptionTooMuch () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add(2, 100);
        });
    }

    @Test
    public void addShouldMyArrayIndexOutOfBoundsExceptionTooLess () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add(-1, 562);
        });
    }

    @Test
    public void setByIndex () {
        Integer [] expectedArray = {5, 8, 10};

        out.add(20);
        out.add(8);
        out.add(10);
        out.set(0,5);
        Integer [] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void setByIndexShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add(180);
            Integer s1 = null;
            out.set(0,s1);
        });
    }

    @Test
    public void setShouldMyArrayIndexOutOfBoundsExceptionTooMuch () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.set(2, 666);
        });
    }

    @Test
    public void setShouldMyArrayIndexOutOfBoundsExceptionTooLess () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.set(-1, 999);
        });
    }

    @Test
    public void remove () {
        Integer [] expectedArray = {90, 60, 10};

        out.add(90);
        out.add(100);
        out.add(120);
        out.add(60);
        out.add(10);
        out.remove(Integer.valueOf(120));
        out.remove(Integer.valueOf(100));
        Integer [] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void removeShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add(514);
            Integer s1 = null;
            out.remove(Integer.valueOf(s1));
        });
    }

    @Test
    public void removeShouldItemNotFoundException () {
        assertThrows(ItemNotFoundException.class, () -> {
            out.add(10);
            out.add(20);
            out.add(30);
            out.remove(Integer.valueOf(40));
        });
    }

    @Test
    public void removeByIndex () {
        Integer [] expectedArray = {20, 40, 50};

        out.add(10);
        out.add(20);
        out.add(30);
        out.add(40);
        out.add(50);
        out.remove(0);
        out.remove(1);
        Integer [] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void removeByIndexShouldMyArrayIndexOutOfBoundsExceptionTooMuch () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add(500);
            out.add(150);
            out.add(28);
            out.remove(4);
        });
    }

    @Test
    public void removeByIndexShouldMyArrayIndexOutOfBoundsExceptionTooLess () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add(500);
            out.add(150);
            out.add(28);
            out.remove(-2);
        });
    }

    @Test
    public void contains () {
        out.add(25);
        out.add(30);
        out.add(35);
        out.add(40);
        out.add(45);
        boolean temp = out.contains(35);

        assertTrue(temp);
    }

    @Test
    public void containsShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add(18);
            Integer s1 = null;
            out.contains(s1);
        });
    }

    @Test
    public void notContains () {
        out.add(25);
        out.add(30);
        out.add(35);
        out.add(40);
        out.add(45);
        boolean temp = out.contains(100);

        assertFalse(temp);
    }

    @Test
    public void indexOf () {
        int index = 3;

        out.add(25);
        out.add(30);
        out.add(35);
        out.add(40);
        out.add(40);
        int result = out.indexOf(40);

        assertEquals(index, result);
    }

    @Test
    public void indexOfShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add(15);
            Integer s1 = null;
            out.indexOf(s1);
        });
    }

    @Test
    public void indexOfNotFound () {
        int index = -1;

        out.add(25);
        out.add(30);
        out.add(35);
        out.add(40);
        out.add(45);
        int result = out.indexOf(190);

        assertEquals(index, result);
    }

    @Test
    public void lastIndexOf () {
        int index = 4;

        out.add(25);
        out.add(30);
        out.add(35);
        out.add(45);
        out.add(45);
        int result = out.lastIndexOf(45);

        assertEquals(index, result);
    }

    @Test
    public void lastIndexOfShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add(215);
            Integer s1 = null;
            out.lastIndexOf(s1);
        });
    }

    @Test
    public void lastIndexOfNotFound () {
        int index = -1;

        out.add(25);
        out.add(8);
        out.add(78);
        out.add(49);
        out.add(97);
        int result = out.lastIndexOf(266);

        assertEquals(index, result);
    }

    @Test
    public void getByIndex () {
        Integer expected = 78;

        out.add(25);
        out.add(8);
        out.add(78);
        out.add(49);
        Integer result = out.get(2);

        assertEquals(expected, result);
    }

    @Test
    public void getShouldMyArrayIndexOutOfBoundsExceptionTooMuch () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add(88);
            out.add(41);
            out.get(4);
        });
    }

    @Test
    public void getShouldMyArrayIndexOutOfBoundsExceptionTooLess () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.get(-5);
        });
    }

    @Test
    public void equals () {
        IntegerArrayList sev2 = new IntegerArrayList();
        sev2.add(156);
        sev2.add(951);
        sev2.add(258);

        out.add(156);
        out.add(951);
        out.add(258);

        boolean result = out.equals(sev2);

        assertTrue(result);
    }

    @Test
    public void equalsShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            IntegerArrayList sev2 = null;
            out.equals(sev2);
        });
    }

    @Test
    public void equalsShouldTypeIsNotValidException () {
        assertThrows(TypeIsNotValidException.class, () -> {
            StringArrayList temp = new StringArrayList();
            out.equals(temp);
        });
    }

    @Test
    public void size () {
        out.add(45);
        out.add(11);
        out.add(24);
        out.add(0, 65);
        out.add(0, 77);
        out.add(0, 87);
        out.remove(Integer.valueOf(77));
        out.remove(Integer.valueOf(11));

        int result = out.size();

        assertEquals(result, 4);
    }

    @Test
    public void isNotEmpty () {
        out.add(15);
        out.add(452);
        out.add(36);

        boolean result = out.isEmpty();

        assertFalse(result);
    }

    @Test
    public void isEmpty () {
        out.add(63);
        out.remove(0);

        boolean result = out.isEmpty();

        assertTrue(result);
    }

    @Test
    public void clear () {
        out.add(63);
        out.add(68);
        out.add(62);
        out.clear();

        boolean result = out.isEmpty();

        assertTrue(result);
    }

    @Test
    public void toArray () {
        Integer [] expected = {65,24,89};

        out.add(65);
        out.add(24);
        out.add(89);
        Integer [] result =  out.toArray();

        assertArrayEquals(expected, result);
    }
}
