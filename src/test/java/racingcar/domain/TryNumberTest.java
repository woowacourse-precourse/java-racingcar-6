package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.message.InputErrorMessage;

class TryNumberTest {
  @Test
  void TryNumber_생성자의_인자가_숫자가아니면_예외() {
    Assertions.assertThatThrownBy(() -> {
              new TryNumber("1000j");
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(InputErrorMessage.INPUT_TRY_NUMBER_TYPE_ERROR.getMessage());
  }
}
