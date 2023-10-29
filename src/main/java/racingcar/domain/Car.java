package racingcar.domain;

import static racingcar.enums.RacingConfig.*;

public class Car {
    private final String name;
    private int movedCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.movedCount = 0;
    }

    private void validateName(String name) {
        if (name.isBlank() || name.length() > CAR_NAME_MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(
                    String.format("rejected value: %s\n자동차 이름은 1자 이상 %d자 이하만 가능합니다.",
                            name, CAR_NAME_MAX_LENGTH.getValue())
            );
        }
    }

    public String getName() {
        return name;
    }

    public int getMovedCount() {
        return movedCount;
    }

    public void move() {
        movedCount++;
    }

    public boolean isSameMovedCount(int movedCount) {
        return this.movedCount == movedCount;
    }
}
