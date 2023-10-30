package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("이동한 거리 표현 테스트")
    @Test
    void expressMoveDistanceTest() {
        Car car = new Car("test");
        String expected = "test : --";
        car.moveForward(6);
        car.moveForward(7);

        String carDistance = car.expressMoveDistance();

        assertThat(carDistance).isEqualTo(expected);
    }
}