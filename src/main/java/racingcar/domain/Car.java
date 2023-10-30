package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        String trimmedName = trimWhitespace(name);

        validateInput(trimmedName);

        this.name = name;
        this.position = 0;
    }

    private String trimWhitespace(String name) {
        return name.trim();
    }

    private static final String INVALID_INPUT_IS_EMPTY = "입력값이 공백입니다.";
    private static final String INVALID_INPUT_SIZE_MESSAGE = "입력은 5자 이하입니다.";

    public void validateInput(String name) {
        validateInputNotEmpty(name);
        validateInputSize(name);
    }

    private void validateInputNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_IS_EMPTY);
        }
    }

    private void validateInputSize(String name) {
        if (Constants.MAX_INPUT_SIZE < name.length())
            throw new IllegalArgumentException(INVALID_INPUT_SIZE_MESSAGE);
    }

    public void moveForward() {
        int randomNumber = Randoms.pickNumberInRange(Constants.MIN_INPUT_RANGE, Constants.MAX_INPUT_RANGE);
        if (randomNumber >= Constants.MIN_MOVE_THRESHOLD) {
            increasePosition();
        }
    }

    public void increasePosition() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
