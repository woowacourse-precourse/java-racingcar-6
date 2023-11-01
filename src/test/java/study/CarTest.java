package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    public void carShouldMoveForward() {
        Car car = new Car("TestCar");
        car.moveForward();
        assertThat(car.movementHistory()).isEqualTo("[-]");
    }

    @Test
    public void carShouldReturnItsName() {
        Car car = new Car("TestCar");
        assertThat(car.name()).isEqualTo("TestCar");
    }
}

