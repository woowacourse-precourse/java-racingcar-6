package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FarCarsTest {
    Car car1;
    Car car2;
    Car car3;
    Car givenCar;
    Car car;
    Car other ;
    @BeforeEach
    void setUP(){
        car1 = new Car("hel");
        car2 = new Car("hll");
        car3 = new Car("apple");
        givenCar = new Car("given");
        car = new Car("cn");
        other = new Car("other");
    }

    @Test
    @DisplayName("compare three to get Top ")
    public void compareThreeCarsTest() {

        car1.moveCarByState(MovementState.MOVE);

        car2.moveCarByState(MovementState.MOVE);
        car2.moveCarByState(MovementState.MOVE);

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


        car1.moveCarByState(MovementState.MOVE);

        car2.moveCarByState(MovementState.MOVE);


        car3.moveCarByState(MovementState.MOVE);


        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 1 ;

        assertThat(Cars.getTopPosition()).isEqualTo(targetNumber);
    }

    @Test
    @DisplayName("compare when given is 0,0,0")
    public void compareThreeCarsAllZeroTest() {






        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 0 ;

        assertThat(Cars.getTopPosition()).isEqualTo(targetNumber);
    }
    @Test
    @DisplayName("compare when given is 1,2,2")
    public void compareOneTwoTwoTest() {


        car1.moveCarByState(MovementState.MOVE);

        car2.moveCarByState(MovementState.MOVE);
        car2.moveCarByState(MovementState.MOVE);


        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);

        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 2 ;

        assertThat(Cars.getTopPosition()).isEqualTo(targetNumber);
    }
    @Test
    @DisplayName("compare when given is 1,1,2")
    public void compareOneOneTwoTest() {


        car1.moveCarByState(MovementState.MOVE);

        car2.moveCarByState(MovementState.MOVE);


        car3.moveCarByState(MovementState.MOVE);
        car3.moveCarByState(MovementState.MOVE);

        List<Car> cars = new ArrayList<>(Arrays.asList(car1,car2,car3));

        Cars Cars = new Cars(cars);

        Integer targetNumber  = 2 ;

        assertThat(Cars.getTopPosition()).isEqualTo(targetNumber);
    }
    @Test
    @DisplayName("compare when given is 1,1,2")
    public void compareOnlySinge() {
        Car car = new Car("22");
        car.moveCarByState(MovementState.MOVE);
        List<Car> cars = new ArrayList<>(Arrays.asList(car));
        Cars Cars = new Cars(cars);
        Integer targetNumber  = 1 ;
        assertThat(Cars.getTopPosition()).isEqualTo(targetNumber);
    }

}
