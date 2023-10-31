package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class CarTest {

    @Test
    void 전진_후_거리_확인() {
        Car car = new Car("Test");
        assertThat(car.getDistance())
                .isEqualTo(0);
        car.advance();
        assertThat(car.getDistance())
                .isEqualTo(1);
    }

}
