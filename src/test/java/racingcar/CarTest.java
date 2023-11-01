package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.car.CarImpl;

public class CarTest {

    @Test
    void carInitializationTest() {
        CarImpl car = new CarImpl("Test");
        assertThat(car.getName()).isEqualTo("Test");
    }

    @Test
    void carMoveTest() {
        CarImpl car = new CarImpl("Test");
        int initialPosition = car.getPosition();
        car.move(5);
        assertThat(car.getPosition()).isGreaterThan(initialPosition);
    }
}
