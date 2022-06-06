package week5.homework1;

import java.util.List;

public class ObjectWithTwoFields {

    private List<StudentModel> list;
    private double averageMark;

    public ObjectWithTwoFields(List<Student> list) {
        this.list = StudentUtil.getMapWithListOfStudents(list).get(getCourse(list));
        this.averageMark = getAverageMark(list);
    }

    public List<StudentModel> getList() {
        return list;
    }

    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public String toString() {
        return "ObjectWithTwoFields{" +
                "list=" + list +
                ", averageMark=" + averageMark +
                '}';
    }

    private int getCourse(List<Student> list) {
        return list.get(0).getCourse();
    }

    private double getAverageMark(List<Student> list) {
        double sum = 0.0;
        for (Student student : list) {
            sum += student.getAverageMark();
        }
        return sum / list.size();
    }
}
