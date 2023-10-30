package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void moveForward() {
        String name = "carName";
        Car car = new Car(name);

        assertRandomNumberInRangeTest(
                () -> {
                    car.moveForward();
                    assertThat(car.getTotalMovements()).isEqualTo(1);
                },
                5
        );
    }
}