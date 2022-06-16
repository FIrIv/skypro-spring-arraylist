package pro.sky.skyprospringarraylist;

import org.junit.jupiter.api.Test;
import pro.sky.skyprospringarraylist.exceptions.ItemNotFoundException;
import pro.sky.skyprospringarraylist.exceptions.MyArrayIndexOutOfBoundsException;
import pro.sky.skyprospringarraylist.exceptions.TypeIsNotValidException;
import pro.sky.skyprospringarraylist.services.IntegerArrayListService;
import pro.sky.skyprospringarraylist.services.StringArrayListService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StringArrayListServiceTest {

    private final StringArrayListService out = new StringArrayListService();

    @Test
    public void add () {
        String [] expectedArray = {"Дмитрий", "Елена", "Андрей", "Ярослав", "Антон", "Анна"};

        out.add("Дмитрий");
        out.add("Елена");
        out.add("Андрей");
        out.add("Ярослав");
        out.add("Антон");
        out.add("Анна");
        String [] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void addShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            String s1 = null;
            out.add(s1);
        });
    }

    @Test
    public void addByIndex () {
        String [] expectedArray = {"Дмитрий", "Елена", "Андрей"};

        out.add("Елена");
        out.add("Андрей");
        out.add(0,"Дмитрий");
        String [] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void addByIndexShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add("Rex");
            String s1 = null;
            out.add(0,s1);
        });
    }

    @Test
    public void addShouldMyArrayIndexOutOfBoundsExceptionTooMuch () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add(2, "Андрей");
        });
    }

    @Test
    public void addShouldMyArrayIndexOutOfBoundsExceptionTooLess () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add(-1, "Андрей");
        });
    }

    @Test
    public void setByIndex () {
        String [] expectedArray = {"Дмитрий", "Елена", "Андрей"};

        out.add("Олег");
        out.add("Елена");
        out.add("Андрей");
        out.set(0,"Дмитрий");
        String [] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void setByIndexShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add("Rex");
            String s1 = null;
            out.set(0,s1);
        });
    }

    @Test
    public void setShouldMyArrayIndexOutOfBoundsExceptionTooMuch () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.set(2, "Андрей");
        });
    }

    @Test
    public void setShouldMyArrayIndexOutOfBoundsExceptionTooLess () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.set(-1, "Андрей");
        });
    }

    @Test
    public void remove () {
        String [] expectedArray = {"Дмитрий", "Елена", "Андрей"};

        out.add("Олег");
        out.add("Дмитрий");
        out.add("Оксана");
        out.add("Елена");
        out.add("Андрей");
        out.remove("Олег");
        out.remove("Оксана");
        String [] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void removeShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add("Rex");
            String s1 = null;
            out.remove(s1);
        });
    }

    @Test
    public void removeShouldItemNotFoundException () {
        assertThrows(ItemNotFoundException.class, () -> {
            out.add("Оксана");
            out.add("Елена");
            out.add("Андрей");
            out.remove("Олег");
        });
    }

    @Test
    public void removeByIndex () {
        String [] expectedArray = {"Дмитрий", "Елена", "Андрей"};

        out.add("Олег");
        out.add("Дмитрий");
        out.add("Оксана");
        out.add("Елена");
        out.add("Андрей");
        out.remove(0);
        out.remove(1);
        String [] result = out.toArray();

        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void removeShouldMyArrayIndexOutOfBoundsExceptionTooMuch () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add("Оксана");
            out.add("Елена");
            out.add("Андрей");
            out.remove(4);
        });
    }

    @Test
    public void removeShouldMyArrayIndexOutOfBoundsExceptionTooLess () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add("Оксана");
            out.add("Елена");
            out.add("Андрей");
            out.remove(-2);
        });
    }

    @Test
    public void contains () {
        out.add("Олег");
        out.add("Дмитрий");
        out.add("Оксана");
        out.add("Елена");
        out.add("Андрей");
        boolean temp = out.contains("Олег");

        assertTrue(temp);
    }

    @Test
    public void containsShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add("Rex");
            String s1 = null;
            out.contains(s1);
        });
    }

    @Test
    public void notContains () {
        out.add("Олег");
        out.add("Дмитрий");
        out.add("Оксана");
        out.add("Елена");
        out.add("Андрей");
        boolean temp = out.contains("Ольга");

        assertFalse(temp);
    }

    @Test
    public void indexOf () {
        int index = 3;

        out.add("Олег");
        out.add("Дмитрий");
        out.add("Оксана");
        out.add("Елена");
        out.add("Елена");
        int result = out.indexOf("Елена");

        assertEquals(index, result);
    }

    @Test
    public void indexOfShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add("Rex");
            String s1 = null;
            out.indexOf(s1);
        });
    }

    @Test
    public void indexOfNotFound () {
        int index = -1;

        out.add("Олег");
        out.add("Дмитрий");
        out.add("Оксана");
        out.add("Елена");
        out.add("Елена");
        int result = out.indexOf("карина");

        assertEquals(index, result);
    }

    @Test
    public void lastIndexOf () {
        int index = 4;

        out.add("Олег");
        out.add("Дмитрий");
        out.add("Оксана");
        out.add("Елена");
        out.add("Елена");
        int result = out.lastIndexOf("Елена");

        assertEquals(index, result);
    }

    @Test
    public void lastIndexOfShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            out.add("Rex");
            String s1 = null;
            out.lastIndexOf(s1);
        });
    }

    @Test
    public void lastIndexOfNotFound () {
        int index = -1;

        out.add("Олег");
        out.add("Дмитрий");
        out.add("Оксана");
        out.add("Елена");
        out.add("Елена");
        int result = out.lastIndexOf("карина");

        assertEquals(index, result);
    }

    @Test
    public void getByIndex () {
        String expected = "Андрей";

        out.add("Олег");
        out.add("Елена");
        out.add("Андрей");
        out.add("Дмитрий");
        String result = out.get(2);

        assertEquals(expected, result);
    }

    @Test
    public void getShouldMyArrayIndexOutOfBoundsExceptionTooMuch () {
        assertThrows(MyArrayIndexOutOfBoundsException.class, () -> {
            out.add("Олег");
            out.add("Елена");
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
        StringArrayListService sev2 = new StringArrayListService();
        sev2.add("Олег");
        sev2.add("Елена");
        sev2.add("Андрей");

        out.add("Олег");
        out.add("Елена");
        out.add("Андрей");

        boolean result = out.equals(sev2);

        assertTrue(result);
    }

    @Test
    public void equalsShouldNullPointerException () {
        assertThrows(NullPointerException.class, () -> {
            StringArrayListService sev2 = null;
            out.equals(sev2);
        });
    }

    @Test
    public void equalsShouldTypeIsNotValidException () {
        assertThrows(TypeIsNotValidException.class, () -> {
            IntegerArrayListService temp = new IntegerArrayListService();
            out.equals(temp);
        });
    }

    @Test
    public void size () {
        out.add("Олег");
        out.add("Елена");
        out.add("Андрей");
        out.add(0, "карина");
        out.add(0, "карина");
        out.add(0, "Марина");
        out.remove("карина");
        out.remove(3);

        int result = out.size();

        assertEquals(result, 4);
    }

    @Test
    public void isNotEmpty () {
        out.add("Олег");
        out.add("Елена");
        out.add("Андрей");

        boolean result = out.isEmpty();

        assertFalse(result);
    }

    @Test
    public void isEmpty () {
        out.add("Олег");
        out.remove(0);

        boolean result = out.isEmpty();

        assertTrue(result);
    }

    @Test
    public void clear () {
        out.add("Олег");
        out.add("Елена");
        out.add("Андрей");
        out.clear();

        boolean result = out.isEmpty();

        assertTrue(result);
    }
    
    @Test
    public void toArray () {
        String [] expected = {"Олег", "Елена", "Андрей"};

        out.add("Олег");
        out.add("Елена");
        out.add("Андрей");
        String [] result =  out.toArray();

        assertArrayEquals(expected, result);
    }
}
