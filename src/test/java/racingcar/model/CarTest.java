package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
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
        assertThat(car.isFront(other)).isFalse();
        assertThat(car.isSamePosition(other)).isTrue();
    }

    @Test
    @DisplayName("compare one is over other  Position")
    public void carDiffPostionPlusTest(){
        other.moveCarByState(MovementState.MOVE);
        assertThat(other.isFront(car)).isTrue();
    }
    @Test
    @DisplayName("compare two Cars  Position")
    public void carDiffPostionCompareTest() {
        other.moveCarByState(MovementState.MOVE);
        other.moveCarByState(MovementState.MOVE);

        assertThat(other.comparePosition(car).state()).isEqualTo(ComparePositionState.FRONT);
    }
    @Test
    @DisplayName("compare two Cars  PositionSame")
    public void carDiffPostionSameCompareTest() {
        assertThat(other.comparePosition(car).state()).isEqualTo(ComparePositionState.SAME);
    }

    @Test
    @DisplayName("compare two Cars  Position")
    public void carDiffPositionCompareWhenBackTest() {
        other.moveCarByState(MovementState.MOVE);
        other.moveCarByState(MovementState.MOVE);
        assertThat(car.comparePosition(other).state()).isEqualTo(ComparePositionState.BACK);
    }
}