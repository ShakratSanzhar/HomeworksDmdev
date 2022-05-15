package week1.homework1;

/**
 Задание 1
 В переменной minutes лежит число от 0 до 59.
 Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 Протестировать функцию в main.
*/

public class Task1 {

    public static void main(String[] args) {
        int minutes = 34;
        printQuarter(minutes);
    }
    public static void printQuarter(int minutes) {
        if (minutes >= 0 && minutes <= 15)
            System.out.println("в первую");
        else if (minutes >= 16 && minutes <= 30)
            System.out.println("во вторую");
        else if (minutes >= 31 && minutes <= 45)
            System.out.println("в третью");
        else if (minutes >= 46 && minutes <= 59)
            System.out.println("в четвертую");
        else
            System.out.println("не входит в диапазон");
    }
}
