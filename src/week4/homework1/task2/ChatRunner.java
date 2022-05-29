package week4.homework1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatRunner {

    public static void main(String[] args) {
        Chat java = new Chat("java", Arrays.asList(new User(1, "San", 22), new User(3, "Ivan", 85), new User(7, "Adil", 18)));
        Chat php = new Chat("php", Arrays.asList(new User(2, "Alex", 15), new User(8, "Irina", 24)));
        Chat unity = new Chat("unity", Arrays.asList(new User(4, "Petr", 32), new User(5, "Galina", 60), new User(6, "Nur", 12)));
        List<Chat> chats = new ArrayList<>(Arrays.asList(java, php, unity));
        List<User> listOfUsers = getListOfAllUsersWithAgeMore18(chats);
        System.out.println(listOfUsers);
        System.out.println(getAverageAgeOfUsers(listOfUsers));
    }

    public static List<User> getListOfAllUsersWithAgeMore18(List<Chat> list) {
        List<User> users = new ArrayList<>();
        for (Chat chat : list) {
            for (User user : chat.getListOfUsers()) {
                if (user.getAge() > 18) {
                    users.add(user);
                }
            }
        }
        return users;
    }

    public static int getAverageAgeOfUsers(List<User> list) {
        int sumOfAllAges = 0;
        for (User user : list) {
            sumOfAllAges += user.getAge();
        }
        return sumOfAllAges / list.size();
    }
}
