package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.Movement;
import racingcar.domain.car.Car;

public class CarTest {

    @Test
    void movementTest() {
        Car hello = new Car("hello");
        Car bye = new Car("bye");

        hello.move(Movement.FORWARD);
        bye.move(Movement.STOP);

        assertThat(hello.getPosition()).isEqualTo(1);
        assertThat(bye.getPosition()).isEqualTo(0);

    }
}
