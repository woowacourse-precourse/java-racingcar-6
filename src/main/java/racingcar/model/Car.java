package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.CarNameLength;
import racingcar.util.MessageFactory;
import racingcar.config.MoveThreshold;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.isEmpty() || name.length() > CarNameLength.MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(MessageFactory.getInvalidCarNameMessage(CarNameLength.MAX_LENGTH.getValue()));
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getMoveResult() {
        return "-".repeat(Math.max(0, position));
    }

    public void move() {
        int move = Randoms.pickNumberInRange(0,9);
        if (move >= MoveThreshold.MIN_THRESHOLD.getValue()) {
            position++;
        }
    }
}