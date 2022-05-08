package week1.homework2;

/**
 * Задание 2
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 *
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2 {

    public static void main(String[] args) {
        int number = 987654321;
        System.out.println(number + " -> " + getReverseNumber(number));
    }
    public static int getReverseNumber(int number) {
        int reverseNumber = 0;
        int countOfDigits = getCountOfDigits(number);
        while(number > 0)
        {
            int digit = number % 10;
            reverseNumber = (int) (reverseNumber + digit * Math.pow(10, countOfDigits-1));
            number = number / 10;
            countOfDigits--;
        }
        return reverseNumber;
    }
    public static int getCountOfDigits(int number) {
        int countOfDigits = 0;
        while(number > 0)
        {
            number = number / 10;
            countOfDigits++;
        }
        return countOfDigits;
    }
}
