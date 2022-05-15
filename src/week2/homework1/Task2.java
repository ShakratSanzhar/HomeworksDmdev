package week2.homework1;

/**
 * Задание 2
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class Task2 {

    public static void main(String[] args) {
        char[] array = {'a', '6', 'y', 'P', 'T', 'q', '9', '+' };
        printArray(getNumericalArray(array));
    }

    public static int[] getNumericalArray(char[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void printArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        int averageValue = sum / array.length;
        for (int i : array) {
            if (i > averageValue) {
                System.out.print(i + " ");
            }
        }
    }
}
