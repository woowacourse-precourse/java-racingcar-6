package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;
    @BeforeEach
    void setUp(){
        car = new Car();
    }
    @Test
    @DisplayName("stop")
    public void carMoveStopStateTest(){
        int number = 3 ;
        assertThat(car.isMoveCar(number)).isEqualTo(MovementState.STOP);
    }
    @Test
    @DisplayName("moveStart")
    public void carMoveMoveStateTest(){
        int number = 4 ;
        assertThat(car.isMoveCar(number)).isEqualTo(MovementState.MOVE);
    }

    @Test
    @DisplayName("stop by stop position")
    public void carSamePostionTest(){
        car = new Car();
        int initPostion = 0 ;
        int targetNumber = initPostion+0 ;
        assertThat(car.moveCarByState(MovementState.STOP)).isEqualTo(targetNumber);
    }
    @Test
    @DisplayName("move by move position")
    public void carPostionPlusTest(){
        car = new Car();
        int initPostion = 0 ;
        int targetNumber = initPostion+1 ;
        assertThat(car.moveCarByState(MovementState.MOVE)).isEqualTo(targetNumber);
    }

}