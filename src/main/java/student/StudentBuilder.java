package student;

import java.util.ArrayList;
import java.util.List;

public final class StudentBuilder {
    private String name;
    private int grade;
    private List<String> courses;

    StudentBuilder() {
        this.courses = new ArrayList<>();
    }

    public StudentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder grade(int grade) {
        this.grade = grade;
        return this;
    }

    public StudentBuilder course(String course) {
        this.courses.add(course);
        return this;
    }

    public Student build() throws Exception {
        return Student.ofNameAndGradeAndCourses(this.name, this.grade, this.courses);
    }
}
