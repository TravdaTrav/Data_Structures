package starter;

public class Main {
  public static void main(String[] args){
    int[] intArray = new int[5];

    for (int i = 0; i < intArray.length; i++) {
      System.out.println(intArray[i]);
    }

    IndexedList<Integer> intList = new ArrayIndexedList(5, 7);

    for (int number : intList){
      System.out.println(number);
    }
  }
}
