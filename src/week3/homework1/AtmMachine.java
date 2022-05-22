package week3.homework1;

public class AtmMachine {
    private static final int NOMINAL100 = 100;
    private static final int NOMINAL50 = 50;
    private static final int NOMINAL20 = 20;
    private int banknote20;
    private int banknote50;
    private int banknote100;

    public AtmMachine(int banknote20, int banknote50, int banknote100) {
        this.banknote20 = banknote20;
        this.banknote50 = banknote50;
        this.banknote100 = banknote100;
    }

    public void addBanknote20(int amount) {
        banknote20 += amount;
    }

    public void addBanknote50(int amount) {
        banknote50 += amount;
    }

    public void addBanknote100(int amount) {
        banknote100 += amount;
    }

    public boolean getCash(int moneySumToWithdraw) {
        int amountOfBanknote100BeforeOperation = banknote100;
        int amountOfBanknote50BeforeOperation = banknote50;
        int amountOfBanknote20BeforeOperation = banknote20;
        if (moneySumToWithdraw > getSumOfMoneyInAtmMachine()) {
            System.out.println("К сожалению, брат, в бакномате недостаточно средств");
            return false;
        }
        int moneySumAfterOperationWithBanknote100 = getRemainingOfMoney(banknote100, moneySumToWithdraw, NOMINAL100);
        banknote100 = getRemainingOfBanknotes(banknote100, moneySumToWithdraw, NOMINAL100);
        int moneySumAfterOperationWithBanknote50 = getRemainingOfMoney(banknote50, moneySumAfterOperationWithBanknote100, NOMINAL50);
        banknote50 = getRemainingOfBanknotes(banknote50, moneySumAfterOperationWithBanknote100, NOMINAL50);
        int moneySumAfterOperationWithBanknote20 = getRemainingOfMoney(banknote20, moneySumAfterOperationWithBanknote50, NOMINAL20);
        banknote20 = getRemainingOfBanknotes(banknote20, moneySumAfterOperationWithBanknote50, NOMINAL20);
        return printStatusOfOperation(moneySumAfterOperationWithBanknote20, amountOfBanknote100BeforeOperation, amountOfBanknote50BeforeOperation, amountOfBanknote20BeforeOperation);
    }

    private boolean printStatusOfOperation(int RemainingSum, int amountOfBanknote100BeforeOperation, int amountOfBanknote50BeforeOperation, int amountOfBanknote20BeforeOperation) {
        if (RemainingSum == 0) {
            System.out.println("Количество купюр номиналом 100 составляет: " + (amountOfBanknote100BeforeOperation - banknote100));
            System.out.println("Количество купюр номиналом 50 составляет: " + (amountOfBanknote50BeforeOperation - banknote50));
            System.out.println("Количество купюр номиналом 20 составляет: " + (amountOfBanknote20BeforeOperation - banknote20));
            System.out.println("Операция прошла успешно");
            return true;
        } else {
            System.out.println("Вы ввели некорректную сумму денег, попробуйте ввести другую сумму");
            return false;
        }
    }

    private int getRemainingOfBanknotes(int banknote, int moneySum, int nominal) {
        if (banknote >= moneySum / nominal) {
            return banknote - moneySum / nominal;
        } else {
            return 0;
        }
    }

    private int getRemainingOfMoney(int banknote, int moneySum, int nominal) {
        if (banknote >= moneySum / nominal) {
            return moneySum % nominal;
        } else {
            return moneySum - banknote * nominal;
        }
    }

    private int getSumOfMoneyInAtmMachine() {
        return banknote20 * NOMINAL20 + banknote50 * NOMINAL50 + banknote100 * NOMINAL100;
    }

    public int getBanknote20() {
        return banknote20;
    }

    public void setBanknote20(int banknote20) {
        this.banknote20 = banknote20;
    }

    public int getBanknote50() {
        return banknote50;
    }

    public void setBanknote50(int banknote50) {
        this.banknote50 = banknote50;
    }

    public int getBanknote100() {
        return banknote100;
    }

    public void setBanknote100(int banknote100) {
        this.banknote100 = banknote100;
    }
}
