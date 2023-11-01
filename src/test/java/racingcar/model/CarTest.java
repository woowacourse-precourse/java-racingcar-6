package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.enums.Common;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private Car car;
    private final String inputNames = "isaac";
    private final int MOVE_FORWARD = Common.STANDARD_NUMBER.getIntValue();
    private final int STOP = Common.STANDARD_NUMBER.getIntValue() - 1;

    @BeforeEach
    @Test
    void init() {
        car = new Car(inputNames);
        assertRandomNumberInRangeTest(() -> {
            car.moveForwardByRandom();
        }, MOVE_FORWARD);
    }

    @Test
    void getNameTest() {
        assertThat(car.getName()).isEqualTo(inputNames);
    }

    @Test
    void getDistanceTest() {
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void moveForwardByRandomTest() {
        Car car = new Car(inputNames);
        assertRandomNumberInRangeTest(() -> {
            car.moveForwardByRandom();
            assertThat(car.getDistance()).isEqualTo(1);
        }, MOVE_FORWARD);

        Car car2 = new Car(inputNames);
        assertRandomNumberInRangeTest(() -> {
            car2.moveForwardByRandom();
            assertThat(car2.getDistance()).isEqualTo(0);
        }, STOP);
    }

    @Test
    void constructorBlankTest() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("  ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructorOverMaxLengthTest() {
        String input = "isaach"; // 6개
        assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructorSeparatorTest() {
        String input = ",";
        assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
    }
}