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
        int initPostion = 0 ;
        int targetNumber = initPostion+0 ;
        assertThat(car.moveCarByState(MovementState.STOP)).isEqualTo(targetNumber);
    }
    @Test
    @DisplayName("move by move position")
    public void carPostionPlusTest(){
        int initPostion = 0 ;
        int targetNumber = initPostion+1 ;
        assertThat(car.moveCarByState(MovementState.MOVE)).isEqualTo(targetNumber);
    }
    @Test
    @DisplayName("compare in when both is same Position")
    public void carSamePositionTest(){
        Car other = new Car();
        assertThat(car.isFront(other)).isFalse();
        assertThat(car.isSamePosition(other)).isTrue();
    }

    @Test
    @DisplayName("compare one is over other  Position")
    public void carDiffPostionPlusTest(){
        Car other = new Car();
        other.moveCarByState(MovementState.MOVE);
        assertThat(other.isFront(car)).isTrue();
    }
    @Test
    @DisplayName("compare two Cars  Position")
    public void carDiffPostionCompareTest() {

        Car other = new Car();
        other.moveCarByState(MovementState.MOVE);
        other.moveCarByState(MovementState.MOVE);

        assertThat(other.comparePosition(car)).isEqualTo(ComparePositionState.FRONT);
    }
    @Test
    @DisplayName("compare two Cars  PositionSame")
    public void carDiffPostionSameCompareTest() {

        Car other = new Car();
        assertThat(other.comparePosition(car)).isEqualTo(ComparePositionState.SAME);
    }

    @Test
    @DisplayName("compare two Cars  Position")
    public void carDiffPositionCompareWhenBackTest() {
        Car other = new Car();
        other.moveCarByState(MovementState.MOVE);
        other.moveCarByState(MovementState.MOVE);
        assertThat(car.comparePosition(other)).isEqualTo(ComparePositionState.BACK);
    }
}