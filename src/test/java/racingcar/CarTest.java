package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
public class CarTest {
  @Test
  public void 자동차_이름_길이_검증() {
    assertThrows(IllegalArgumentException.class, () -> new Car("abcdef"));
  }
}
