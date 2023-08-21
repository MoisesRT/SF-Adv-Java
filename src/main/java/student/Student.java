package student;

import java.util.List;

public final class Student {
    private String name;
    private int grade;
    private List<String> courses;

    public static int validateGrade(int grade) throws Exception {
        boolean isValid = grade >= 0 && grade <= 100;
        if (!isValid) {
            throw new Exception("Grade must be between 0 and 100");
        }
        return grade;
    }

    public static String validateName(String name) throws Exception {
        boolean isValid = !name.isEmpty() && name.length() < 20;
        if (!isValid) {
            throw new Exception("Name length must be between 1 and 20");
        }
        return name;
    }

    public static List<String> validateCourses(List<String> courses) throws Exception {
        boolean isValid = !courses.isEmpty();
        if (!isValid) {
            throw new Exception("There must be at least one course");
        }
        return courses;
    }

    public static Student ofNameAndGradeAndCourses(String name, int grade, List<String> courses) throws Exception {
        return new Student(validateName(name), validateGrade(grade), validateCourses(courses));
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    private Student(String name, int grade, List<String> courses) {
        this.name = name;
        this.grade = grade;
        this.courses = courses; // generally bad...
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public List<String> getCourses() {
        return courses;
    }
}

class UseStudent {
    public static void main(String[] args) throws Exception {
        StudentBuilder sb = Student.builder();
        sb
                .name("Fred")
                .grade(78)
                .course("Math");
        // do other stuff
        sb.course("Physics")
                .course("Algebra");
        // do more other stuff
        Student s1 = sb.build();
        System.out.printf("%s %s %s", s1.getName(), s1.getGrade(), s1.getCourses());


    }
}
