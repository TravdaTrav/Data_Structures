package Test;

public class Animal {
  private String name;

  Animal(String name){
    this.name = name;
  }

  String printName(){
    return name;
  }

  String getName(){
    return name;
  }

  public static void main(String[] args){
    Animal[] animals = new Animal[3];

    animals[0] = new Cat("Bill");
    animals[1] = new Dog("Bob");

    System.out.println(animals[0].printName());
    System.out.println(animals[1].printName());
  }
}
