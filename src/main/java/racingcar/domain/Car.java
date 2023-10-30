package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.ErrorMessage;

public class Car {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMAL_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.OVER_FIVE_LENGTH.toString());
        }
    }

    public void moveForward() {
        if (Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MINIMAL_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String mapRecord() {
        return name + " : " + "-".repeat(position);
    }
}
