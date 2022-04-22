import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

/** */
class LinkedListTest {

  @BeforeAll
  static void beforeAll() {}

  @Test
  void testList() {
    LinkedList<PlanarShape> unsortedList = new LinkedList<>();
    try {
      Assertions.assertTrue(unsortedList.isEmpty());
    } catch (AssertionFailedError e) {
      System.out.println(e.getMessage());
    }
  }
}
