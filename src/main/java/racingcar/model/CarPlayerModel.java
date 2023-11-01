package racingcar.model;

import static racingcar.Constants.MOVE_CONDITION;
import static racingcar.Constants.START_POSITION;

import util.CarRandoms;

public class CarPlayerModel {
    private final String carName;
    //현재 위치
    private int currentPosition;

    public CarPlayerModel(String carName) {
        this.carName = carName;
        this.currentPosition = START_POSITION;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getCarName() {
        return carName;
    }

    public void move() {
        if (isMoveAllowed()) {
            this.currentPosition++;
        }
    }

    public boolean isMoveAllowed() {
        return CarRandoms.getRandomNumber() >= MOVE_CONDITION;
    }
}
