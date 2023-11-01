package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @Test
    void 정지_테스트() {
        car.move(3, car);
        int actualDistance = car.distance;
        String actualStatus = car.status;

        assertThat(actualDistance).isEqualTo(0);
        assertThat(actualStatus).isEqualTo("");
    }

    @Test
    void 전진_테스트1() {
        car.move(4, car);
        int actualDistance = car.distance;
        String actualStatus = car.status;

        assertThat(actualDistance).isEqualTo(1);
        assertThat(actualStatus).isEqualTo("-");
    }

    @Test
    void 전진_테스트2() {
        car.move(5, car);
        int actualDistance = car.distance;
        String actualStatus = car.status;

        assertThat(actualDistance).isEqualTo(1);
        assertThat(actualStatus).isEqualTo("-");
    }
}