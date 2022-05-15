package week2.homework2;

public class Room {

    private boolean isPassage;

    public Room(boolean isPassage) {
        this.isPassage = isPassage;
    }

    public void print() {
        System.out.println("Комната проходная?: " + isPassage);
    }

    public boolean isPassage() {
        return isPassage;
    }

    public void setPassage(boolean passage) {
        isPassage = passage;
    }
}
