package racingcar.model;

import racingcar.Rule;
import racingcar.Util;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        if (Util.getRandomNum() >= Rule.GO_NUM) {
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
        return name + Rule.ROUND_RESULT_DELIMETER + Util.dashRepeat(position);
    }

    public String getName() {
        return name;
    }

}
