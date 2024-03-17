package starter;

public class Main {
  public static void main(String[] args){
    IndexedList<Integer> intList = new ArrayIndexedList<>(8, 7);

    for (int i = 0; i < intList.length(); i++) {
      System.out.println(intList.get(i) + " ");
    }

    System.out.println();

    IndexedList<String> stringList = new ArrayIndexedList<>(5, "---");

    for (int i = 0; i < stringList.length(); i++) {
      System.out.println(stringList.get(i) + " ");
    }

    System.out.println();
  }
}
