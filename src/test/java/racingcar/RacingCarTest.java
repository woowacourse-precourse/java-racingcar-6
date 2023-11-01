package racingcar;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    public void moveCar_ShouldMoveForward_WhenRandomNumberIsGreaterThanFour() {
        RacingCar car = new RacingCar("TestCar");
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void moveCar_ShouldNotMove_WhenRandomNumberIsFourOrLess() {
        RacingCar car = new RacingCar("TestCar");
        car.move(3); // Random number is 4 or less
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
