package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;
import racingcar.exception.ErrorMessages;

public class Car {
    private static final int MIN_MOVE_TO_INCREMENT = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int DEFAULT_MOVING_COUNT = 0;

    private String name;
    private int movingCount;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.movingCount = DEFAULT_MOVING_COUNT;
    }

    private void validateName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(ErrorMessages.NAME_BLANK_ERROR);
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH_ERROR);
        }
    }

    public Car(String name, int movingCount) {
        this.name = name;
        this.movingCount = movingCount;
    }

    public void moveAccordingToInput(int number) {
        if (number >= MIN_MOVE_TO_INCREMENT) {
            this.moving();
        }
    }

    private void moving() {
        this.movingCount++;
    }

    public int getMovingCount() {
        return this.movingCount;
    }

    public String getName() {
        return name;
    }
}
