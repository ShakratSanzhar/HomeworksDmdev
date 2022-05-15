package week2.homework3;

/**
 * Задание 2
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * Посчитать сумму всех чисел из строки
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2 {

    public static void main(String[] args) {
        String string = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        System.out.println(getSumOfDigits(getArrayOfDigits(string)));
    }

    public static int[] getArrayOfDigits(String string) {
        char[] array = string.toCharArray();
        int counter = 0;
        for (char c : array) {
            if (Character.isDigit(c)) {
                counter++;
            }
        }
        int[] digitArray = new int[counter];
        int temp = 0;
        for (char c : array) {
            if (Character.isDigit(c)) {
                digitArray[temp] = Character.getNumericValue(c);
                temp++;
            }
        }
        return digitArray;
    }

    public static int getSumOfDigits(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
}
