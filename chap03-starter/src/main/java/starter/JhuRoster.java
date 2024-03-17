package starter;

public class JhuRoster implements Roster{
  public JhuRoster(int size) {
    super(size);
  }

  @Override
  public void add(Student student) {
    if (numStudents < students.length) {
      students[numStudents] = student;
    } else {
      System.out.println("The roster is full.");
    }
  }
  @Override
  public void remove(Student student){
    for (int i = 0; i < numStudents; i ++){
      if(student.getEmail().equals(students[i].getEmail())){

      }
    }
  }

  @Override
  public Student find(String email){

  }
}
