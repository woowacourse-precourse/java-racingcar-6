package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Car {
    static final int MIN_NAME_LENGTH = 1;
    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_RANDOM_VALUE = 0;
    static final int MAX_RANDOM_VALUE = 9;
    static final int MIN_MOVE_CONDITION = 4;
    private String name;
    private Integer moveCount;

    public Car(String name) throws IllegalArgumentException {
        validateNameLength(name);
        this.moveCount = 0;
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("자동차 이름은 NULL이 될 수 없습니다.");
        }
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 "
                    + MIN_NAME_LENGTH + "글자 이상 "
                    + MAX_NAME_LENGTH + "글자 이하여야 합니다.");
        }
    }

    public void tryToMove() {
        int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        validateRandomValue(randomValue);

        if (isPossibleToMove(randomValue)) {
            moveCount++;
        }
    }

    private void validateRandomValue(final int randomValue) {
        if (randomValue < MIN_RANDOM_VALUE || randomValue > MAX_RANDOM_VALUE) {
            throw new IllegalArgumentException("랜덤 값은 "
                    + MIN_RANDOM_VALUE + "이상 "
                    + MAX_RANDOM_VALUE + "이하 값을 가져야 합니다.");
        }
    }

    private boolean isPossibleToMove(final int value) {
        if (value >= MIN_MOVE_CONDITION) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
