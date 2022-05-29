package week4.homework1.task1;

import java.util.*;

public class ChatRunner {

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>(Arrays.asList(new Chat("java", 2000), new Chat("python", 1000), new Chat("c++", 500), new Chat("php", 1000), new Chat("go", 2500), new Chat("c#", 1000)));
        System.out.println(chats);
        System.out.println(deleteChatWithNumberOfUsersLess1000(chats));
        System.out.println(sortListByComparator(chats));
        //System.out.println(sortListByNameDefault(chats));
    }

    public static List<Chat> deleteChatWithNumberOfUsersLess1000(List<Chat> list) {
        List<Chat> chats = list;
        Iterator<Chat> iterator = chats.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNumberOfUsers() < 1000) {
                iterator.remove();
            }
        }
        return chats;
    }

    public static List<Chat> sortListByComparator(List<Chat> list) {
        List<Chat> chats = list;
        chats.sort(new Chat.ChatComparator());
        return chats;
    }

    public static List<Chat> sortListByNameDefault(List<Chat> list) {
        List<Chat> chats = list;
        Collections.sort(chats);
        return chats;
    }
}
