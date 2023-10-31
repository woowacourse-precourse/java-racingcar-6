package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputManagerTest {

  @Test
  void 자동차이름_길이가5이하인경우_예외발생안함() {
    String carName = "Tesla";
    assertThatCode(() -> {
      if (carName.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
      }
    }).doesNotThrowAnyException();
  }

  @Test
  void 자동차이름_길이가6이상인경우_예외발생() {
    String carName = "Mercedes";
    assertThatThrownBy(() -> {
      if (carName.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
      }
    })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
  }

  @Test
  void 시도_횟수_5이상_예외처리() {
    int numAttempts = 0;
    assertThatThrownBy(() -> {
      if (numAttempts <= 0) {
        throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
      }
    })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
  }
}