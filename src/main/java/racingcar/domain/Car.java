package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private CarName carName;
    private Position position;
    private static final int MIMIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MOVING_STANDARD_NUMBER = 4;

    public Car(CarName carName){
        this.carName = carName;
    }

    public void movePosition(){
        if(isAbleToMove()){
            position = position.getIncreasedPosition();
        }
        position = position.getPausedPosition();
    }

    private boolean isAbleToMove(){
        int randomNumber = Randoms.pickNumberInRange(MIMIMUM_NUMBER, MAXIMUM_NUMBER);
        return randomNumber >= MOVING_STANDARD_NUMBER;
    }
}
