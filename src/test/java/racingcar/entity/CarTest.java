package racingcar.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Car car = Car.from("pobi");
        Car otherCar = Car.from("pobi");

        assertThat(car).isEqualTo(otherCar);
    }
}
