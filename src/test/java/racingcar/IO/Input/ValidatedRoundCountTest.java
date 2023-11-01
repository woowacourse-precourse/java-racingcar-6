package racingcar.IO.Input;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.IO.Input.ValidatedRoundCount;

class ValidatedRoundCountTest {

  @DisplayName("레이스 횟수가 0 이하일 때 예외처리")
  @Test
  void if_input_zero_throw_exception() {
    // given
    String roundCount = "0";

    // when && then
    assertThrows(IllegalArgumentException.class, () -> ValidatedRoundCount.of(roundCount));
  }

  @DisplayName("입력값이 숫자가 아닐 때 예외처리")
  @Test
  void if_input_is_not_number_throw_exception() {
    // given
    String roundCount = "a";

    // when && then
    assertThrows(IllegalArgumentException.class, () -> ValidatedRoundCount.of(roundCount));
  }
}