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
}
