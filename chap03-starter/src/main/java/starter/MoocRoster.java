package starter;

public class MoocRoster implements Roster {
  private Student[] students;
  private int numStudents;

  public MoocRoster(int size) {
    students = new Student[size];
    numStudents = 0;
  }

  @Override
  public void add(Student student) {

  }

  @Override
  public void remove(Student student) {

  }

  @Override
  public Student find(String email) {

  }
}
