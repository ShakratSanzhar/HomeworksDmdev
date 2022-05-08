package week1.homework2;

/**
 * Задание 3
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 *
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 *
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */
public class Task3 {

    public static void main(String[] args) {
        int years = 0;
        int months = 2;
        int sumOfMonths = countOfMonths(years, months);
        getMyAccount(sumOfMonths);

    }

    public static void getMyAccount(int sumOfMonths){
        double account = 0;
        double brokerAccount = 0;
        double salary = 600;
        for (int i = 1; i <= sumOfMonths; i++) {

            if(i % 6 == 0){
                salary += 400;
            }
            account += salary;
            account -= 300;
            double brokerAddition = salary * 0.1;
            brokerAccount = brokerAccount + brokerAddition;
            account -= brokerAddition;
            if(i >= 2){
                brokerAccount += brokerAccount * 0.02;
            }

        }
        System.out.println("Свой счет: " + account + " ; " + "Брокерский счет: " + brokerAccount);

    }

    public static int countOfMonths(int years, int months) {
        return years * 12 + months;
    }
}
