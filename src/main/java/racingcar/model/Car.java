package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Integer position;
    public Car() {
        this.position = 0;
    }

    public MovementState isMoveCar(Integer givenNumber){
        if(givenNumber >= 4) return MovementState.MOVE;
        return MovementState.STOP;
    }
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
    public Integer moveCarByState(MovementState movementState){
        if(movementState.equals(MovementState.MOVE)){
            position++;
        }
        return  position;
    }

    public boolean isFront(Car otherCar) {
        return this.position > otherCar.position ;
    }

    public boolean isSamePosition(Car other) {
        return this.position.equals(other.position);
    }

    public PairCompareResult comparePosition(Car otherCar) {
        if(isFront(otherCar)) return new PairCompareResult(ComparePositionState.FRONT,position);
        if(isSamePosition(otherCar)) return new PairCompareResult(ComparePositionState.SAME,position);
        return new PairCompareResult(ComparePositionState.BACK,position);
    }
}
