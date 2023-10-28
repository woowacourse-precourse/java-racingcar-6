package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import racingcar.validator.CarNameValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.FrequencyValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {

  @DisplayName("자동자 이름 범위 테스트")
  @Test
  void 자동차_이름_범위_테스트() {
    List<String> input = Arrays.asList("pobi", "qncj5224");

    assertThrows(IllegalArgumentException.class, () -> {
      CarNameValidator.isNameLengthValid(input);
    });
  }

  @DisplayName("자동자 이름 개수 테스트")
  @Test
  void 자동차_이름_개수_테스트() {
    List<String> input = List.of("pobi");

    assertThatThrownBy(() -> CarNameValidator.isNumberOfCarsValid(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("자동자 이름 중복 테스트")
  @Test
  void 자동차_이름_중복_테스트() {
    List<String> input = Arrays.asList("pobi", "pobi");

    assertThatThrownBy(() -> CarNameValidator.isNameDuplicate(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("자동자 이름 공백 테스트")
  @Test
  void 자동차_이름_공백_테스트() {
    List<String> input = Arrays.asList("pobi", " ");

    assertThatThrownBy(() -> CarNameValidator.isNameValid(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("회수가 숫자인지 테스트")
  @Test
  void 회수_숫자_테스트() {
    String input = "a";

    assertThatThrownBy(() -> FrequencyValidator.isCorrectFrequencyNumber(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("회수가 음수인지 테스트")
  @Test
  void 회수_음수_테스트() {
    String input = "-1";

    assertThatThrownBy(() -> FrequencyValidator.isNegativeNumber(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
