package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차의 winCount 가 증가한다.")
    @Test
    void plusWinCount() {
        // given
        Car car = Car.createCar("pobi");

        // when
        car.plusWinCount();
        car.plusWinCount();

        // then
        assertThat(car.getWinCount()).isEqualTo(2);
    }
}