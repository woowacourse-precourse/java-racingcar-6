package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void testMoveForward() {
        Car car = new Car("Car1");
        car.moveForward();
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void testGetName() {
        Car car = new Car("Car2");
        assertThat(car.getName()).isEqualTo("Car2");
    }

    @Test
    void testGetLocation() {
        Car car = new Car("Car3");
        assertThat(car.getLocation()).isEqualTo(0);
    }
}
