package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름이 1 이상 5 이하가 아닐 경우 예외가 발생한다.")
    @Test
    void validateCarName() {
        // given
        String carName = "liljay";
        Car car = new Car();

        // when, then
        assertThatThrownBy(() -> car.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}