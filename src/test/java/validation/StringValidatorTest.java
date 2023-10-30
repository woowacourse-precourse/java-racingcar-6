package validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringValidatorTest {
  @Test
  void validateStringLengthOver_메서드_사용시_제한_길이_이하면_값을_그대로_반환() {
    String inputString = "pobi";
    int inputInteger = 5;

    String result = StringValidator.checkLengthOver(inputString, inputInteger);

    assertThat(result).isEqualTo(inputString);
  }

  @Test
  void validateStringLengthOver_메서드_사용시_제한_길이_초과면_에러_발생() {
    String inputString = "pobi";
    int inputInteger = 3;

    assertThatThrownBy(() -> StringValidator.checkLengthOver(inputString, inputInteger))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("자동차 이름은 " + inputInteger + "자 이하로 해주세요.");
  }

  @Test
  void checkNumberFormat_메서드_사용시_정수면_그대로_반환() {
    String inputString = "4";

    String result = StringValidator.checkIntegerFormat(inputString);

    assertThat(result).isEqualTo(inputString);
  }

  @Test
  void checkNumberFormat_메서드_사용시_정수가_아니면_에러_발생() {
    String inputString = "pobi";

    assertThatThrownBy(() -> StringValidator.checkIntegerFormat(inputString))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자를 입력해주세요");
  }
}
