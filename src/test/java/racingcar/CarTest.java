package racingcar;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int MOVING_FORWARD = 4;

    @Test
    void tryMoving메서드_테스트() {
        Car car = new Car("davin");
        assertRandomNumberInRangeTest(
                () -> {
                    car.tryMoving();
                    assertThat(car.getTotalForward()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void toString메서드_테스트() {
        Car car = new Car("davin", 3);
        assertThat(car.toString()).isEqualTo("davin : ---");
    }

    @Test
    void printMoving메서드_테스트() {
        Car car = new Car("davin", 5);
        assertThat(car.printMoving()).isEqualTo("-----");
    }

    @Test
    void compareTo메서드_테스트() {
        Car car1 = new Car("davin", 5);
        Car car2 = new Car("chanho", 2);
        int result = car1.compareTo(car2);
        assertThat(result).isEqualTo(1);
    }
}
