package Test;

public class Cat extends Animal{
  Cat(String name){
    super(name);
  }

  @Override
  String printName(){
    return getName() + ": Cat";
  }
}
