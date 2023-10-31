package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionConstants;
import racingcar.exception.RacingCarGameException;

class CarTest {

  @Test
  @DisplayName("[Success] 유효한 이름으로 차를 생성 시 제대로 생성되어야 한다.")
  void 유효한_이름으로_차_생성() {
    // given
    String validName = "차1";

    // when
    Car car = Car.from(validName);

    // then
    assertThat(car.getCarName()).isEqualTo(validName);
  }

  @Test
  @DisplayName("[Error] 이름 길이 제한을 초과하는 길이의 이름을 입력 시 예외가 발생해야 한다.")
  void 이름길이제한_초과시_예외발생() {
    // given
    String invalidName = "이름길이제한5글자";

    // when & then
    assertThrows(RacingCarGameException.class, () -> Car.from(invalidName));
    assertThatThrownBy(() -> Car.from(invalidName))
        .isInstanceOf(RacingCarGameException.class)
        .hasMessageContaining(ExceptionConstants.INVALID_SCOPE_NAME);
  }

  @Test
  @DisplayName("[Error] 공백을 차 이름으로 입력 시 예외가 발생해야 한다.")
  void 공백이름입력시_예외발생() {
    // given
    String invalidName = "";

    // when & then
    assertThatThrownBy(() -> Car.from(invalidName))
        .isInstanceOf(RacingCarGameException.class)
        .hasMessageContaining(ExceptionConstants.EMPTY_CAR_NAME);
  }

  @Test
  @DisplayName("[Error] null을 차 이름으로 지정 시 예외가 발생해야 한다.")
  void 널값이름입력시_예외발생() {
    // given
    String invalidName = null;

    // when & then
    assertThatThrownBy(() -> Car.from(invalidName))
        .isInstanceOf(RacingCarGameException.class)
        .hasMessageContaining(ExceptionConstants.EMPTY_CAR_NAME);
  }

  @Test
  @DisplayName("[Error] 차 이름에 특수문자가 들어가면 예외가 발생해야 한다.")
  void 특수문자입력시_예외발생() {
    // given
    String invalidName = "!@#*";
    // when & then
    assertThatThrownBy(() -> Car.from(invalidName))
        .isInstanceOf(RacingCarGameException.class)
        .hasMessageContaining(ExceptionConstants.UNALLOWED_SPECIAL_SYMBOL);
  }
}
