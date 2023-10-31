package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarGameException;

class CarTest {

  @Test
  @DisplayName("유효한 이름으로 차를 생성 시 제대로 생성되어야 한다.")
  void 파라미터_이름으로_차생성() {
    // given
    String str = "차1";

    // when
    Car car = Car.from(str);

    // then
    assertThat(car.getCarName()).isEqualTo(str);
  }

  @Test
  @DisplayName("이름 길이 제한을 초과하는 길이의 이름을 입력 시 예외가 발생해야 한다.")
  void 이름길이제한_초과시_예외발생() {
    // given
    String str = "이름길이제한5글자";

    // when & then
    assertThrows(RacingCarGameException.class, () -> Car.from(str));
  }

  @Test
  @DisplayName("공백을 차 이름으로 입력 시 예외가 발생해야 한다.")
  void 공백이름입력시_예외발생() {
    // given
    String str = "";

    // when & then
    assertThrows(RacingCarGameException.class, () -> Car.from(str));
  }

  @Test
  @DisplayName("null을 차 이름으로 지정 시 예외가 발생해야 한다.")
  void 널값이름입력시_예외발생() {
    // given
    String str = null;

    // when & then
    assertThrows(RacingCarGameException.class, () -> Car.from(str));
  }

  @Test
  @DisplayName("차 이름에 특수문자가 들어가면 예외가 발생해야 한다.")
  void 특수문자입력시_예외발생() {
    // given
    String str = "!@#*";
    // when & then
    assertThrows(RacingCarGameException.class, () -> Car.from(str));
  }
}
