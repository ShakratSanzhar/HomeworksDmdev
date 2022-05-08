package week1.homework2;

/**
 * Задание 1
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция - нечетных).
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {

    public static void main(String[] args) {
        int number = 228910;
        System.out.println("Сумма четных цифр равна: " + getSumOfEvenDigits(number));
        System.out.println("Сумма нечетных цифр равна: " + getSumOfOddDigits(number));
    }
    public static int getSumOfEvenDigits(int number) {
        int result = number;
        int sum = 0;
        System.out.print("Четные цифры: ");
        while(result > 0)
        {
            int digit = result % 10;
            if(digit % 2 == 0)
            {
                System.out.print(digit + "; ");
                sum++;
            }
            result = result / 10;
        }
        return sum;
    }
    public static int getSumOfOddDigits(int number) {
        int result = number;
        int sum = 0;
        System.out.print("Нечетные цифры: ");
        while(result > 0)
        {
            int digit = result % 10;
            if(digit % 2 != 0)
            {
                System.out.print(digit + "; ");
                sum++;
            }
            result = result / 10;
        }
        return sum;
    }

}
