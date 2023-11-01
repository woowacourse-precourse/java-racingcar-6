package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진() {
        Car car = new Car("KIA");
        assertThat(car.getDistance()).isEqualTo(0);
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 정지() {
        Car car = new Car("BMW");
        assertThat(car.getDistance()).isEqualTo(0);
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(0);
                },
                STOP
        );
    }

    @Test
    void compareTo() {
        Car car1 = new Car("KIA", 1);
        Car car2 = new Car("BMW", 0);

        int number = car1.compareTo(car2);

        assertThat(number).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 위치면 true를 반환해야 한다.")
    void isSameDistance_o() {
        Car car1 = new Car("KIA", 1);
        Car car2 = new Car("BMW", 1);

        boolean bool = car1.isSameDistance(car2);

        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("같은 위치가 아니면 false를 반환해야 한다.")
    void isSameDistance_x() {
        Car car1 = new Car("KIA", 1);
        Car car2 = new Car("BMW", 0);

        boolean bool = car1.isSameDistance(car2);

        assertThat(bool).isFalse();
    }
}
