package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void moveForwardTest() {
        Car car = new Car("pobi");
        car.moveForward();
        assertThat(car.getMove()).isEqualTo(1);
    }

    @Test
    void getNameTest() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }
}
