package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("움직이는지 확인")
    void test1() {
        Car car = new Car("asdf");

        car.canMove(8);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
