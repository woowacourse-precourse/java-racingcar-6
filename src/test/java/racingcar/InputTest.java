package racingcar;

import java.util.Collections;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import racingcar.validator.CarNameValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {

  @DisplayName("자동자 이름 범위 테스트")
  @Test
  void 자동차_이름_범위_테스트() {
    final List<String> input = Collections.singletonList("car1,qncj5224");

    assertThrows(IllegalArgumentException.class, () -> {
      CarNameValidator.isNameLengthValid(input);
    });
  }

  @DisplayName("자동자 이름 개수 테스트")
  @Test
  void 자동차_이름_개수_테스트() {
    final List<String> input = Collections.singletonList("a");

    assertThatThrownBy(() -> CarNameValidator.isNumberOfCarsValid(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
