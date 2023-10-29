package racingcar;

import java.util.Objects;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private String name;
    private Integer moveCount;

    public Car(String name) throws IllegalArgumentException {
        if (!validateNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 "
                    + MIN_NAME_LENGTH + "글자 이상 "
                    + MAX_NAME_LENGTH + "글자 이하여야 합니다.");
        }

        this.moveCount = 0;
        this.name = name;
    }

    private boolean validateNameLength(String name) {
        if (Objects.isNull(name))
            return false;
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
            return false;
        return true;
    }
}
