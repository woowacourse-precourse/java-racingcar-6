package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("DY");
                    car.moveForward();
                    assertThat(car.getDistance()).isEqualTo(1);
                }, 7
        );
    }

    @Test
    void 자동차_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("DY");
                    car.moveForward();
                    assertThat(car.getDistance()).isEqualTo(0);
                }, 2
        );
    }

    @Test
    void 자동차_전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("DY");
                    car.moveForward();
                    car.moveForward();
                    car.moveForward();
                    assertThat(car.getDistance()).isEqualTo(2);
                }, 2, 9, 5
        );
    }
}
