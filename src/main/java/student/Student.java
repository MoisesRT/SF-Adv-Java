package student;

import java.util.List;

public final class Student {
  private String name;
  private int grade;
  private List<String> courses;

  // NOT valid overloads
//  Student(String name, String parentsName) {}
//  Student(String name, String fraternity) {}

  public static Student ofNameAndParentsName(String name, String parentsName) {
    // validate!!!
    return null; // probably want to return an ACTUAL student
  }

  public static Student ofNameAndFraternityName(String name, String fraternity) {
    // validate!!!
    return null;
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
  public static void main(String[] args) {
//    Student s = new Student(); // good, I should not do this anyway!
//    Student s = Student.of("Fred", 76, List.of("Math", "Physics"));
    Student s = Student.ofNameAndParentsName("Fred", "Mrs Smith");
    System.out.println("name of student is " + s.getName());

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
    sb = Student.builder();
    Student s2 = sb.name("Alex").build();

  }
}