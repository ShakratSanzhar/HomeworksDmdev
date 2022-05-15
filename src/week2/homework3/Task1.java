package week2.homework3;

/**
 * Задание 1
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * <p>
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */
public class Task1 {

    public static void main(String[] args) {
        String string = "abc Cpddd Dio OsfWw";
        System.out.println(deleteRepeats(deleteSpaces(string)));
    }

    public static String deleteSpaces(String string) {
        return string.replace(" ", "");
    }

    public static String deleteRepeats(String string) {
        StringBuilder result = new StringBuilder();
        char[] charArray = string.toUpperCase().toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i - 1] != charArray[i]) {
                result.append(charArray[i - 1]);
            }
        }
        result.append(charArray[charArray.length - 1]);
        return result.toString();
    }
}
