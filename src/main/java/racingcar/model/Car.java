package racingcar.model;

import jdk.jshell.execution.Util;
import racingcar.Constants;
import racingcar.Utils;

public class Car {

    private final String NAME;
    private int position = 0;

    public Car(String name) {
        this.NAME = name;
    }

    public void moveForward() {
        if (Utils.getRandomNumber() >= Constants.BASELINE_NUM) {
            position++;
        }
    }
    public int getPosition() {
        return position;
    }
    public boolean isWinner(int winDistance) {
        return position == winDistance;
    }
    public String getRoundResult() {
        return NAME + Constants.ROUND_RESULT_DELIMITER + Utils.dashRepeat(position);
    }
}
