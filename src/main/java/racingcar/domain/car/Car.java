package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    static final int MINIMUM_RANGE = 0;
    static final int MAXIMUM_RANGE = 9;
    static final int THRESHOLD = 4;
    private final CarDistance carDistance;

    public Car() {
        carDistance = new CarDistance();
    }

    public void tryMoveForward() {
        if(determineMoving()){
            carDistance.moveForward();
        }
    }

    private boolean determineMoving() {
        return (getRandomNumber() >= THRESHOLD);
    }

    protected int getRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANGE,MAXIMUM_RANGE);
    }


    public int getDistance() {
        return carDistance.getDistance();
    }


}
