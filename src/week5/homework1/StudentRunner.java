package week5.homework1;

import java.util.ArrayList;
import java.util.List;

public class StudentRunner {

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", "Ivanov", 2, List.of(4, 3, 5, 4, 5));
        Student student2 = new Student("Stepan", "Stepanov", 1, List.of(5, 5, 5, 4, 3));
        Student student3 = new Student("Vladimir", "Vladimirov", 3, List.of(3, 3, 2, 5, 4));
        Student student4 = new Student("Vasiliy", "Vasilyev", 4, List.of(5, 4, 5, 5, 4, 5));
        Student student5 = new Student("Denis", "Denisov", 4, List.of(4, 3));
        Student student6 = new Student("Anatoliy", "Anatolyev", 2, List.of(5, 3, 4));
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        StudentUtil.printMapOfStudents(StudentUtil.getMapWithAverageMarkOfStudents(list));
        StudentUtil.printMapOfStudents(StudentUtil.getMapWithListOfStudents(list));
        StudentUtil.printMapOfStudents(StudentUtil.getMapWithObjectWithTwoFields(list));
    }
}
