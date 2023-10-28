package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

public class Car {
    private String name;
    private int movingCount;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.movingCount = 0;
    }

    private void validateName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException();
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public Car(String name, int movingCount) {
        this.name = name;
        this.movingCount = movingCount;
    }

    public void moveAccordingToInput(int number) {
        if (number >= 4) {
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
