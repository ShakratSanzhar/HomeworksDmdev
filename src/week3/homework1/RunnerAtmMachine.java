package week3.homework1;

public class RunnerAtmMachine {

    public static void main(String[] args) {
       AtmMachine atm = new AtmMachine(1,1,2);
       atm.getCash(270);
       atm.addBanknote20(3);
       atm.addBanknote50(2);
       atm.addBanknote100(2);
       atm.getCash(80);
       atm.getCash(100);
    }
}
