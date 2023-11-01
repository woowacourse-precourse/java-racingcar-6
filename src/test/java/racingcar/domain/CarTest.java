package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void Car_이름을_가져온다() {
        Car car = new Car("자동차");
        String result = car.getName();
        String expected = "자동차";
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void Car_위치를_가져온다() {
        Car car = new Car("자동차");

        int result = car.getLocation();

        int expected = 0;
        Assertions.assertThat(result).isEqualTo(expected);
    }
}