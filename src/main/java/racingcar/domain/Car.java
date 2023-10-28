package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.ErrorMessage;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        validateNameNoWhitespace(name);

        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(String name) {
        if (name == null || name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH.getMessage());
        }
    }

    private void validateNameNoWhitespace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_NO_WHITESPACE.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void run() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (isMovable(randomNumber)) {
            this.position++;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= 4;
    }
}
