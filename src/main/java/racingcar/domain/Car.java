package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.ErrorMessage;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.OVER_FIVE_LENGTH.toString());
        }
    }

    public void moveForward() {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
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
