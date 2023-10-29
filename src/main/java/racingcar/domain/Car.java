package racingcar.domain;

import static racingcar.message.MessageConstants.CAR_NAME_AND_POSITION_FORMAT;
import static racingcar.message.MessageConstants.FOUR;
import static racingcar.message.MessageConstants.HYPHEN;
import static racingcar.message.MessageConstants.ZERO;

public class Car {
    private final Names name;
    private int position;

    public Car(Names name) {
        this.name = name;
    }

    public void move(int power) {
        if (power >= FOUR) {
            position++;
        }
    }

    public String forwardStatus() {
        return String.format(CAR_NAME_AND_POSITION_FORMAT, name.value()) + HYPHEN.repeat(Math.max(ZERO, position));
    }

    public boolean isSamePosition(int maxPosition) {
        return position >= maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.value();
    }
}
