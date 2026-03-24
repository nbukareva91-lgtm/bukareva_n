package lesson6;
import java.util.*;
class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }
    public String getName() { return name; }
    public String getGroup() { return group; }
    public int getCourse() { return course; }
    public List<Integer> getGrades() { return new ArrayList<>(grades); }

    public void setCourse(int course) { this.course = course; }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public boolean canMoveToNextCourse() {
        return getAverageGrade() >= 3.0;
    }

    @Override
    public String toString() {
        return "Студент: " + name + ", группа: " + group + ", курс: " + course +
                ", средний балл: " + String.format("%.2f", getAverageGrade());
    }
}
