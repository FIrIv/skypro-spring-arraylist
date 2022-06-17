package pro.sky.skyprospringarraylist.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Sort {

    // худшая скорость
    public void sortBubble (Integer [] array) {
        for (int i=0; i<array.length; i++) {
            Integer temp=array[i];
            for (int j=0; j<array.length-1-i; j++) {
                if (array[j]>array[j+1]) {
                    swapElements(array, j, j+1);
                }
            }
        }
    }

    // средняя скорость
    public void sortMin (Integer [] array) {
        for (int i=0; i<array.length; i++) {
            Integer min = array[i];
            int minIndex = i;
            for (int j=i+1; j<array.length; j++) {
                if (array[j]<min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) swapElements(array, i, minIndex);
        }
    }

    // лучшая скорость
    public void sortInsertion(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            Integer temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    private void swapElements (Integer[] array, int index1, int index2) {
        Integer temp = array[index1];
        array[index1] = array[index2];
        array[index2]=temp;
    }

    // для замера скорости сортировок
    private void testSpeed () {
        Integer[] testArray = generateRandomArray(0, 1_000_000, 100_000);
        Integer[] array1 = Arrays.copyOf(testArray, testArray.length);
        Integer[] array2 = Arrays.copyOf(testArray, testArray.length);

        long start = System.currentTimeMillis();
        sortBubble(testArray);
        System.out.println("Скорость пузырьковой сортировки: " + (System.currentTimeMillis() - start));
        // получилась 223,032 сек

        start = System.currentTimeMillis();
        sortMin(array1);
        System.out.println("Скорость сортировки выбором: " + (System.currentTimeMillis() - start));
        // получилась 64,714 сек

        start = System.currentTimeMillis();
        sortMin(array2);
        System.out.println("Скорость сортировки вставкой: " + (System.currentTimeMillis() - start));
        // получилась 40,321 сек
    }

    private Integer[] generateRandomArray (int min, int max, int length) {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max-min) + min;
        }
        return arr;
    }
}
