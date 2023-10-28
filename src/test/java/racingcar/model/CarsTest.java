package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    Car car1;
    Car car2;
    Car car3;
    Car givenCar;
    @BeforeEach
    void setUP(){
        car1 = new Car("hel");
        car2 = new Car("hll");
        car3 = new Car("apple");
        givenCar = new Car("given");
    }
    @Test
    @DisplayName("compare when given is last only")
    public void compareThreeCarsTest() {
        car1.moveCarByState(MovementState.MOVE);

        car2.moveCarByState(MovementState.MOVE);
        car2.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);


        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 0 ;

        assertThat(Cars.comparePosition(givenCar).position()).isEqualTo(targetNumber);
        assertThat(Cars.comparePosition(givenCar).state()).isEqualTo(ComparePositionState.BACK);
    }
    @Test
    @DisplayName("compare when given is FRONT Only")
    public void compareThreeCarsFirstOnlyTest() {


        car1.moveCarByState(MovementState.MOVE);


        car2.moveCarByState(MovementState.MOVE);
        car2.moveCarByState(MovementState.MOVE);


        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);


        givenCar.moveCarByState(MovementState.MOVE);
        givenCar.moveCarByState(MovementState.MOVE);
        givenCar.moveCarByState(MovementState.MOVE);
        givenCar.moveCarByState(MovementState.MOVE);

        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 4 ;

        assertThat(Cars.comparePosition(givenCar).position()).isEqualTo(targetNumber);
        assertThat(Cars.comparePosition(givenCar).state()).isEqualTo(ComparePositionState.FRONT);
    }

    @Test
    @DisplayName("compare when given is SAME FRONT")
    public void compareThreeCarSameFrontTest() {


        car1.moveCarByState(MovementState.MOVE);


        car2.moveCarByState(MovementState.MOVE);
        car2.moveCarByState(MovementState.MOVE);


        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);


        givenCar.moveCarByState(MovementState.MOVE);
        givenCar.moveCarByState(MovementState.MOVE);
        givenCar.moveCarByState(MovementState.MOVE);

        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 3 ;

        assertThat(Cars.comparePosition(givenCar).position()).isEqualTo(targetNumber);
        assertThat(Cars.comparePosition(givenCar).state()).isEqualTo(ComparePositionState.FRONT);
    }
    @Test
    @DisplayName("compare when given is SAME BACK")
    public void compareThreeCarSameBackTest() {


        car1.moveCarByState(MovementState.MOVE);


        car2.moveCarByState(MovementState.MOVE);
        car2.moveCarByState(MovementState.MOVE);


        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);


        givenCar.moveCarByState(MovementState.MOVE);

        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 1 ;

        assertThat(Cars.comparePosition(givenCar).position()).isEqualTo(targetNumber);
        assertThat(Cars.comparePosition(givenCar).state()).isEqualTo(ComparePositionState.BACK);
    }

    @Test
    @DisplayName("compare when given is BACK")
    public void compareThreeCarBackTest() {


        car1.moveCarByState(MovementState.MOVE);


        car2.moveCarByState(MovementState.MOVE);
        car2.moveCarByState(MovementState.MOVE);


        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);



        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 0 ;

        assertThat(Cars.comparePosition(givenCar).position()).isEqualTo(targetNumber);
        assertThat(Cars.comparePosition(givenCar).state()).isEqualTo(ComparePositionState.BACK);
    }
    @Test
    @DisplayName("compare when given is SAME")
    public void compareThreeCarSAMETest() {


        car1.moveCarByState(MovementState.MOVE);


        car2.moveCarByState(MovementState.MOVE);


        car3.moveCarByState(MovementState.MOVE);


        givenCar.moveCarByState(MovementState.MOVE);

        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 1 ;

        assertThat(Cars.comparePosition(givenCar).position()).isEqualTo(targetNumber);
        assertThat(Cars.comparePosition(givenCar).state()).isEqualTo(ComparePositionState.SAME);
    }

}
