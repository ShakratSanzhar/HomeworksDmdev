package week2.homework1;

/**
 * Задание 1
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции. main - только для тестирования написанного функционала.
 */
public class Task1 {

    public static void main(String[] args) {
        int[] array = {3, 5, -6, 3, 2, -9, 0, -123};
        printArray(getMultiplicationArray(deleteNegativeElements(array)));
    }

    public static int[] deleteNegativeElements(int[] array) {
        int temp = 0;
        for (int i : array) {
            if (i >= 0) {
                temp++;
            }
        }
        int[] result = new int[temp];
        int resIndex = 0;
        for (int j : array) {
            if (j >= 0) {
                result[resIndex++] = j;
            }
        }
        return result;
    }

    public static int[] getMultiplicationArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array.length;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
