package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void testCarCreationWithInvalidName() {
        assertThatThrownBy(() -> new Car("veryLongCarName")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCarPickNumberInRange() {
        Car car = new Car("Car1");
        int number = car.pickNumber();
        assertThat(number).isBetween(0, 9);
    }

    @Test
    void testCarMove() {
        Car car = new Car("Car1");
        int initialMoveCnt = car.moveCnt;
        car.move();
        assertThat(car.moveCnt).isEqualTo(initialMoveCnt + 1);
    }

    @Test
    void testCarHowFar() {
        Car car = new Car("myCar");
        car.move();
        String expectedOutput = "myCar : -";
        assertThat(car.howFar()).isEqualTo(expectedOutput);
    }
}
