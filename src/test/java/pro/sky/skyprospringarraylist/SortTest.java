package pro.sky.skyprospringarraylist;

import org.junit.jupiter.api.Test;
import pro.sky.skyprospringarraylist.services.Sort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {

    private final Sort sortService = new Sort();

    @Test
    public void sortBubble () {
        Integer [] expectedArray = {9, 10, 11, 11, 45, 54, 66, 69, 78, 89};

        Integer [] array = {54, 69, 78, 66, 9, 89, 10, 11, 11, 45};
        sortService.sortBubble(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void sortMin () {
        Integer [] expectedArray = {9, 10, 11, 11, 45, 54, 66, 69, 78, 89};

        Integer [] array = {54, 69, 78, 66, 9, 89, 10, 11, 11, 45};
        sortService.sortMin(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void sortInsertion () {
        Integer [] expectedArray = {9, 10, 11, 11, 45, 54, 66, 69, 78, 89};

        Integer [] array = {54, 69, 78, 66, 9, 89, 10, 11, 11, 45};
        sortService.sortInsertion(array);

        assertArrayEquals(expectedArray, array);
    }
}
