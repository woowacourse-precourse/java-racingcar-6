package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private CarName carName;
    private Position position = new Position();
    private static final int MIMIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MOVING_STANDARD_NUMBER = 4;

    public Car(CarName carName){
        this.carName = carName;
    }

    public void movePosition(){
        if(isAbleToMove()){
            position = Position.getIncreasedPosition(position.getPosition());
        }
        position = Position.getPausedPosition(position.getPosition());
    }

    private boolean isAbleToMove(){
        int randomNumber = Randoms.pickNumberInRange(MIMIMUM_NUMBER, MAXIMUM_NUMBER);
        return randomNumber >= MOVING_STANDARD_NUMBER;
    }

    public Position getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }
}
