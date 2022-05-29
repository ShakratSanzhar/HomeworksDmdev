package week4.homework1.task1;

import java.util.Comparator;

public class Chat implements Comparable<Chat> {

    private String name;
    private int numberOfUsers;

    public Chat(String name, int numberOfUsers) {
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public int compareTo(Chat o) {
        return this.getName().compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }

    public static class ChatComparator implements Comparator<Chat> {

        @Override
        public int compare(Chat o1, Chat o2) {
            return (o1.getNumberOfUsers() < o2.getNumberOfUsers()) ? 1 : ((o1.getNumberOfUsers() == o2.getNumberOfUsers()) ? o1.getName().compareTo(o2.getName()) : -1);
        }
    }
}
