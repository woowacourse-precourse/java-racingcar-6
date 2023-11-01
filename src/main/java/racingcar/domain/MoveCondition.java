package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public enum MoveCondition {
    MOVE(1),
    STAY(0);

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int STANDARD = 4;

    private final int distance;

    MoveCondition(int distance) {
        this.distance = distance;
    }

    public static MoveCondition getCondition() {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (randomNumber >= STANDARD) {
            return MOVE;
        }
        return STAY;
    }

    public int getDistance() {
        return distance;
    }
}
