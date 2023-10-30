package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
public class CarTest {
    @Test
    void move_forward_when_random_number_is_greater_than_or_eqaul_to_4() {
        int canMove = 4;
        assertRandomNumberInRangeTest(
            () -> {
                Car car = new Car("testCar");
                int prevPosition = car.getPosition();
                car.move();
                assertThat(car.getPosition() - prevPosition).isEqualTo(1);
            },
            canMove
        );
    }

    @Test
    void stay_in_position_when_random_number_is_less_than_4() {
        int cantMove = 3;
        assertRandomNumberInRangeTest(
            () -> {
                Car car = new Car("testCar");
                int prevPosition = car.getPosition();
                car.move();
                assertThat(car.getPosition() - prevPosition).isEqualTo(0);
            },
            cantMove
        );
    }
}
