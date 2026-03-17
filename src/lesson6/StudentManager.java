package lesson6;
import java.util.*;
class StudentManager {

    public static void deleteStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.canMoveToNextCourse()) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }
}
