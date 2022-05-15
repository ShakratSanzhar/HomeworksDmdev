package week2.homework2;

/**
 * Задание 1
 * Представить в виде классов и их композиции следующую модель.
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * В каждом классе реализовать метод print, который на консоль выводит информацию об объекте (должны присутствовать все поля объекта!).
 * Например, метод print класса этаж должен выводить на консоль:
 * “Этаж 2, количество квартир 18”
 * Создание всех объектов вынести в отдельный класс с методом main.
 * Там же реализовать метод printAllInformation, который на вход принимает объект типа дом, и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
 */
public class HouseRunner {

    public static void main(String[] args) {
        Room room1 = new Room(true);
        Room room2 = new Room(true);
        Room room3 = new Room(false);
        Room[] rooms = {room1, room2, room3};
        Flat flat1 = new Flat(8, rooms);
        Flat[] flats = {flat1};
        Floor floor1 = new Floor(1, flats);
        Floor floor2 = new Floor(2, flats);
        Floor floor3 = new Floor(3, flats);
        Floor[] floors = {floor1, floor2, floor3};
        House house = new House(2, floors);
        printAllInformation(house);
    }

    public static void printAllInformation(House house) {
        house.print();
        for (Floor floor : house.getFloors()) {
            floor.print();
            for (Flat flat : floor.getFlats()) {
                flat.print();
                for (Room room : flat.getRooms()) {
                    room.print();
                }
            }
        }
    }
}
