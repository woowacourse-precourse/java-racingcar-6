package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 전진() {
        Car car = Car.of("test");
        assertRandomNumberInRangeTest(
            () -> {
                car.move();
                assertThat(car.getPosition()).isEqualTo(1);
            },
            4
        );
    }

    @Test
    void 정지() {
        Car car = Car.of("test");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(0);
                },
                2
        );
    }
}