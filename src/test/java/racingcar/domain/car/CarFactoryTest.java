package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

  @Test
  @DisplayName("자동차 이름을 입력받아 자동차를 생성한다.")
  void 자동차_이름을_입력받아_자동차를_생성한다() {
    // given
    var carNames = List.of("pobi", "crong", "honux");

    // when
    var cars = CarFactory.createCars(carNames);

    // then
    assertThat(cars).isInstanceOf(List.class)
        .hasOnlyElementsOfType(Car.class)
        .hasSize(3);
  }
}
