package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.ExceptionConstants.EMPTY_CAR_NAME;
import static racingcar.constant.ExceptionConstants.INVALID_SCOPE_NAME;
import static racingcar.constant.ExceptionConstants.UNALLOWED_SPECIAL_SYMBOL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarGameException;

class RacingCarNameValidatorTest {
  // given
  RacingCarNameValidator validator = new RacingCarNameValidator();
  String validCarName = "헬로월드";
  String invalidLongCarName = "oxdjww";
  String invalidCarNameWithSpecialSymbol = "asd!";
  String invalidCarNameComposedOfBlank = "";
  String invalidCarNameComposedOfNull = null;
  @Test
  @DisplayName("[Success] 차 이름에 대해 1~5글자, 특수문자 제외, 공백 금지를 검증한다.")
  void 유효한_차이름_검증_성공() {
    // when && then
    assertDoesNotThrow(
        () -> validator.validate(validCarName)
    );
  }

  @Test
  @DisplayName("[Error] 6글자 차 이름으로 검증 시 예외를 던진다.")
  void 다섯글자이상_차이름_검증실패() {
    // when && then
    assertThatThrownBy(() -> validator.validate(invalidLongCarName))
        .isInstanceOf(RacingCarGameException.class)
        .hasMessageContaining(INVALID_SCOPE_NAME);
  }
  @Test
  @DisplayName("[Error] 특수문자를 포함한 차이름은 예외를 던진다.")
  void 특수문자_차이름_검증실패() {
    // when && then
    assertThatThrownBy(() -> validator.validate(invalidCarNameWithSpecialSymbol))
        .isInstanceOf(RacingCarGameException.class)
        .hasMessageContaining(UNALLOWED_SPECIAL_SYMBOL);
  }

  @Test
  @DisplayName("[Error] 공백으로 구성된 차이름은 예외를 던진다.")
  void 공백_차이름_검증_실패() {
    // when && then
    assertThatThrownBy(() -> validator.validate(invalidCarNameComposedOfBlank))
        .isInstanceOf(RacingCarGameException.class)
        .hasMessageContaining(EMPTY_CAR_NAME);
  }
  @Test
  @DisplayName("[Error] null로 된 차이름은 예외를 던진다.")
  void null_차이름_검증실패() {
    // when && then
    assertThatThrownBy(() -> validator.validate(invalidCarNameComposedOfNull))
        .isInstanceOf(RacingCarGameException.class)
        .hasMessageContaining(EMPTY_CAR_NAME);
  }



}