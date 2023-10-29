package racingcar.model;

import static racingcar.Constants.MOVE_CONDITION;
import static racingcar.Constants.START_POSITION;

public class RacingCarPlayerModel {
    private final String carName;
    //현재 위치
    private int currentPosition;

    public RacingCarPlayerModel(String carName) {
        this.carName = carName;
        this.currentPosition = START_POSITION;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getCarName() {
        return carName;
    }

    public void move(){
        if(isMoveAllowed()) {
            this.currentPosition++;
        }
    }

    private boolean isMoveAllowed(){
        return util.RacingCarRandoms.getRandomNumber() >= MOVE_CONDITION;
    }
}
