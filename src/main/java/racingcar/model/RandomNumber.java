package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;
    private static final int MOVABLE_NUMBER = 4;
    private final int number;

    public RandomNumber() {
        int number = pickNumberInRange(START_RANGE, END_RANGE);
        this.number = number;
    }

    public boolean isMovable() {
        return number >= MOVABLE_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}