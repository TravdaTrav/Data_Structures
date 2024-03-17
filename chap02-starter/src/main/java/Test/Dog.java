package Test;

public class Dog extends Animal{
  Dog(String name){
    super(name);
  }

  @Override
  String printName(){
    return getName() + ": Dog";
  }
}
