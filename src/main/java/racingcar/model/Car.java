package racingcar.model;

import static racingcar.constant.RacingGameConstants.CAR_NAME_LENGTH_MAX;
import static racingcar.constant.RacingGameConstants.CAR_NAME_LENGTH_MIN;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        validateNull(name);
        validateNameLength(name);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null이 입력되었습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(
                    "이름은 " + CAR_NAME_LENGTH_MIN + "자 이상 " + CAR_NAME_LENGTH_MAX + "자 이하여야 합니다.");
        }
    }

    public void moveOneStep() {
        position++;
    }
}
