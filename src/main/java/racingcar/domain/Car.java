package racingcar.domain;

import static racingcar.domain.enums.Constants.MAX_NAME_LENGTH;
import static racingcar.domain.enums.Constants.MIN_MOVE_THRESHOLD;
import static racingcar.domain.enums.Constants.RANDOM_END_RANGE;
import static racingcar.domain.enums.Constants.RANDOM_START_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        validateNameLength(name);
        this.name = name;
        this.moveCount = moveCount;
    }

    public Car(String name) {
        this(name, 0);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void moveWithRandomNumber() {
        int num = Randoms.pickNumberInRange(RANDOM_START_RANGE, RANDOM_END_RANGE);
        if (num >= MIN_MOVE_THRESHOLD) {
            this.moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", moveCount=" + moveCount +
                '}';
    }
}
