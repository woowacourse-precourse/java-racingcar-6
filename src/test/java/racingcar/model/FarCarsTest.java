package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FarCarsTest {
    @Test
    @DisplayName("compare three to get Top ")
    public void compareThreeCarsTest() {

        Car car1 = new Car();
        car1.moveCarByState(MovementState.MOVE);

        Car car2 = new Car();
        car2.moveCarByState(MovementState.MOVE);
        car2.moveCarByState(MovementState.MOVE);

        Car car3 = new Car();
        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);

        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 3 ;

        assertThat(Cars.getTopPosition()).isEqualTo(targetNumber);
    }

    @Test
    @DisplayName("compare when given is SAME")
    public void compareThreeCarSAMETest() {

        Car car1 = new Car();
        car1.moveCarByState(MovementState.MOVE);

        Car car2 = new Car();
        car2.moveCarByState(MovementState.MOVE);

        Car car3 = new Car();
        car3.moveCarByState(MovementState.MOVE);

        Car givenCar = new Car();
        givenCar.moveCarByState(MovementState.MOVE);

        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 1 ;

        assertThat(Cars.getTopPosition()).isEqualTo(targetNumber);
    }
}
