import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** */
class CircleTest {
  static final Pattern CIRCLE_REGEX =
      Pattern.compile(
          "^CIRC=\\["
              + PointTest.POINT_REGEX
              + " [0-9]{0,3}(\\.[0-9]{0,2})?\\] : [0-9]{0,5}(\\.[0-9]{0,2})?$");
  Circle circle;

  @BeforeEach
  void setUp() {
    circle = new Circle(4, 3, 2);
  }

  @Test
  void testToString() {
    assertTrue(this.circle.toString().matches(CIRCLE_REGEX.pattern()));
  }

  @Test
  void area() {
    assertEquals(circle.area(), (Math.pow(Math.PI * 2, 2)));
  }

  @Test
  void originDistance() {}
}
