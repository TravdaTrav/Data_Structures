package starter;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IndexedListTest {
  private IndexedList<Integer> testList;

  static final private int LIST_SIZE = 10;

  static final private int DEFAULT_VALUE = 10;
  @BeforeEach
  void setup(){
    testList = new ArrayIndexedList<>(LIST_SIZE, DEFAULT_VALUE);
  }

  @Test
  @DisplayName("length() returns the default value after IndexedList is instantiated")
  void testLengthAfterConstruction(){
    assertEquals(LIST_SIZE, testList.length());
  }

  @Test
  @DisplayName("get() returns the default value after IndexedList is instantiated.")
  void testGetAfterConstruction() {
    for (int i = 0; i < testList.length(); i ++){
      assertEquals(DEFAULT_VALUE, testList.get(i));
    }
  }

  @Test
  @DisplayName("put() changes the default value after IndexedList is instantiated.")
  void testPutChangesValueAfterConstruction() {
    testList.put(2, 20);
    assertEquals(20, testList.get(2));
  }

  @Test
  @DisplayName("put() overwrites the existing value at given index to provided value.")
  void testPutUpdatesValueAtGivenIndex() {
    // TODO Implement me!
  }
}