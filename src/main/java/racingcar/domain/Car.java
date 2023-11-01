package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_MOVE_SIZE = 0;
    private static final int MAX_MOVE_SIZE = 9;
    private static final int POSSIBLE_MOVE_STANDARD_SIZE = 4;

    private final Name name;
    private int moveCounts;

    public Car(Name name) {
        this.name = name;
        this.moveCounts = 0;
    }


    void tryMove() {
        if (isMove()) {
            this.moveCounts++;
        }
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(MIN_MOVE_SIZE, MAX_MOVE_SIZE) >= POSSIBLE_MOVE_STANDARD_SIZE;
    }

    public int getMoveCounts() {
        return this.moveCounts;
    }
}
