import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Point Class Test")
class PointTest {
  static final Pattern POINT_REGEX =
      Pattern.compile("\\([0-9]{0,4}(\\.[0-9]{0,2})? , [0-9]{0,4}(\\.[0-9]{0,2})?\\)");
  Point point;

  @BeforeAll
  static void beforeAll() {}

  @BeforeEach
  void setUp() {
    this.point = new Point(0.7694565063446747, 0.41573156235168796);
  }

  @Test
  void getX() {
    assertEquals(point.getX(), 0.7694565063446747);
  }

  @Test
  void getY() {
    assertEquals(point.getY(), 0.41573156235168796);
  }

  @Test
  void testToString() {
    assertTrue(point.toString().matches(POINT_REGEX.pattern()));
    System.out.println(point.toString());
  }
}
