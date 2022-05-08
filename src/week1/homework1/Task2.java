package week1.homework1;

/**
Задание 2
 Даны 3 переменные:
 - operand1 (double)
 - operand2 (double)
 - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 Протестировать функцию в main.
 Например:
 Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 Результат: 34.5 (24.4 + 10.1)
*/

public class Task2 {

    public static void main(String[] args) {
        double operand1 = 24.4;
        double operand2 = 10.1;
        char operation = '-';
        System.out.println(operationResult(operand1,operand2,operation));
    }
    public static double operationResult(double operand1, double operand2, char operation) {
        return switch(operation) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            case '%' -> operand1 % operand2;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
        }
    }

