package starter;

public class GradStudent extends Student{
  private String advisor;

  public GradStudent(String name, String email) {
    super(name, email);
  }

  public GradStudent(String name, String email, String advisor){
    super(name, email);
    this.advisor = advisor; //the parameter advisor would shadow the field advisor without the use of this.
  }

  public String getAdvisor() {
    return advisor;
  }

  public void setAdvisor(String advisor) {
    this.advisor = advisor;
  }

  public String toString(){
    return getName() + " " + getEmail();
  }
}