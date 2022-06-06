package week5.homework1;

import java.util.List;

public class Student {

    private String name;
    private String surname;
    private int course;
    private List<Integer> marksList;

    public Student(String name, String surname, int course, List<Integer> marksList) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.marksList = marksList;
    }

    public double getAverageMark() {
        int sum = 0;
        int sumOfMarks = marksList.stream().reduce(sum, Integer::sum);
        return sumOfMarks / (double) marksList.size();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getMarksList() {
        return marksList;
    }
}
