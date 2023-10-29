package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void carInitializationTest() {
        Car car = new Car("Test");
        assertThat(car.getName()).isEqualTo("Test");
    }

    @Test
    void carMoveTest() {
        Car car = new Car("Test");
        int initialPosition = car.getPosition();
        car.move(5);
        assertThat(car.getPosition()).isGreaterThan(initialPosition);
    }
}
