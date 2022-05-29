package week4.homework1.task2;

import java.util.List;

public class Chat {

    private String name;
    private List<User> listOfUsers;

    public Chat(String name, List<User> listOfUsers) {
        this.name = name;
        this.listOfUsers = listOfUsers;
    }

    public String getName() {
        return name;
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", listOfUsers=" + listOfUsers +
                '}';
    }
}
