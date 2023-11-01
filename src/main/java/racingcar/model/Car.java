package racingcar.model;

import racingcar.constant.Constants;
import racingcar.util.Utils;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void getResult() {
        if (Utils.getRandomNumber() > Constants.THRESHOLD) {
            this.distance += Constants.MOVE_AMOUNT;
        }
    }

    public String getRoundResult() {
        return name + Constants.KEY_VALUE_SEPARATOR + Utils.convertDistanceToSymbol(distance);
    }

    public int getDistance() {
        return distance;
    }

    public boolean isWinner(int winningDistance) {
        return this.distance == winningDistance;
    }

    public String getName() {
        return name;
    }
}
