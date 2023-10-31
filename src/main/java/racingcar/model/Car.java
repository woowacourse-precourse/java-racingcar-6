package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.CarNameLength;
import racingcar.util.MessageFactory;
import racingcar.config.MoveThreshold;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > CarNameLength.MAX_LENGTH.getValue()) {
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

}