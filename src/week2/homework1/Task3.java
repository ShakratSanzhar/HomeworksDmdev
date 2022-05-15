package week2.homework1;

/**
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * <p>
 * Пример:
 * <p>
 *                             [-4, -18]
 * <p>
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 * <p>
 *                             [1, 9, 3]
 */
public class Task3 {

    public static void main(String[] args) {
        int[] array = {-4, 0, 1, 9, 0, -18, 3};
        printTwoDimensionalArray(getTwoDimensionalArray(array));
    }

    public static int[][] getTwoDimensionalArray(int[] array) {
        int[][] resultArray = new int[3][];
        int[] arrayOfAmounts = getArrayWithAmountsOfNegativeNullPositiveElements(array);
        int[] arrayOfNegativeNumbers = new int[arrayOfAmounts[0]];
        int[] arrayOfNullNumbers = new int[arrayOfAmounts[1]];
        int[] arrayOfPositiveNumbers = new int[arrayOfAmounts[2]];
        int indexOfNegativeNumbersArray = 0;
        int indexOfNullNumbersArray = 0;
        int indexOfPositiveNumbersArray = 0;
        for (int j : array) {
            if (j < 0) {
                arrayOfNegativeNumbers[indexOfNegativeNumbersArray++] = j;
            }
            if (j == 0) {
                arrayOfNullNumbers[indexOfNullNumbersArray++] = j;
            }
            if (j > 0) {
                arrayOfPositiveNumbers[indexOfPositiveNumbersArray++] = j;
            }
        }
        for (int i = 0; i < resultArray.length; i++) {
            if (i == 0) {
                resultArray[i] = arrayOfNegativeNumbers;
            }
            if (i == 1) {
                resultArray[i] = arrayOfNullNumbers;
            }
            if (i == 2) {
                resultArray[i] = arrayOfPositiveNumbers;
            }
        }
        return resultArray;
    }

    public static int[] getArrayWithAmountsOfNegativeNullPositiveElements(int[] array) {
        int[] res = new int[3];
        int negativeAmount = 0;
        int nullAmount = 0;
        int positiveAmount = 0;
        for (int i : array) {
            if (i < 0) {
                negativeAmount++;
            } else if (i == 0) {
                nullAmount++;
            } else {
                positiveAmount++;
            }
        }
        res[0] = negativeAmount;
        res[1] = nullAmount;
        res[2] = positiveAmount;
        return res;
    }

    public static void printTwoDimensionalArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

