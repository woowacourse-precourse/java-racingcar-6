package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Console.ExceptionMessage;

public class Car {

    private static final int MAX_NAME_SIZE = 5;
    private static final int MIN_MOVE_SIZE = 0;
    private static final int MAX_MOVE_SIZE = 9;
    private static final int POSSIBLE_MOVE_STANDARD_SIZE = 4;

    private String name;
    private int moveCounts;

    public Car(String name) {
        isValidNameSize(name);
        this.name = name;
        this.moveCounts = 0;
    }

    private void isValidNameSize(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_CAR_NAME_SIZE_MESSAGE);
        }
    }

    void tryMove() {
        if (isMove()) {
            this.moveCounts++;
        }
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(MIN_MOVE_SIZE, MAX_MOVE_SIZE) >= POSSIBLE_MOVE_STANDARD_SIZE;
    }

    String getName() {
        return this.name;
    }

    int getMoveCounts() {
        return this.moveCounts;
    }
}
