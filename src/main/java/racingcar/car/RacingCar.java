package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private static final Integer START_NUMBER = 0;
    private static final Integer END_NUMBER = 9;
    private static final Integer MOVE_COUNT_INITIAL_NUMBER = 0;
    private static final Integer MAX_NAME_LENGTH = 5;
    private static final Integer MIN_MOVE_NUMBER = 4;

    private final String name;
    private Integer moveCount;

    public RacingCar(String name) {
        validateNameLength(name);
        this.name = name;
        this.moveCount = MOVE_COUNT_INITIAL_NUMBER;
    }

    public String getName() {
        return this.name;
    }

    public Integer getMoveCount() {
        return this.moveCount;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private Integer generateRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    public void moveOrStop() {
        if (generateRandomNumber() >= MIN_MOVE_NUMBER) {
            this.moveCount++;
        }
    }
}