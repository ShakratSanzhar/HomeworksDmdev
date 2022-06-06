package week5.homework1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class StudentUtil {

    private StudentUtil() {

    }

    public static Map<Integer, Double> getMapWithAverageMarkOfStudents(List<Student> list) {
        return list.stream()
                .filter(student -> student.getMarksList().size() > 3)
                .collect(Collectors.groupingBy(Student::getCourse, Collectors.averagingDouble(Student::getAverageMark)));
    }

    public static Map<Integer, List<StudentModel>> getMapWithListOfStudents(List<Student> list) {
        return list.stream()
                .sorted(new StudentComparator1())
                .sorted(new StudentComparator2())
                .collect(Collectors.groupingBy(Student::getCourse, Collectors.mapping(StudentModel::new, Collectors.toList())));
    }

    public static Map<Integer, ObjectWithTwoFields> getMapWithObjectWithTwoFields(List<Student> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Student::getCourse, Collectors.collectingAndThen(Collectors.toList(), ObjectWithTwoFields::new)));
    }

    public static <T> void printMapOfStudents(Map<Integer, T> map) {
        for (Map.Entry<Integer, T> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    private static class StudentComparator1 implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    private static class StudentComparator2 implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
}
