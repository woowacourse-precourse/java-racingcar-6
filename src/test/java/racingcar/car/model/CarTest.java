package racingcar.car.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름_반환() {
        Car car = new Car("자동차");

        assertThat(car.getName()).isEqualTo("자동차");
    }

    @Test
    void 자동차_위치_반환() {
        Car car = new Car("자동차");

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
