package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.InputValidator;

public class Car {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int NINE = 9;
    private static final int MOVE_CONDITION_NUMBER = 4;
    private static final String MOVE_STRING = "-";

    private final String name;
    private int moveCount;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void moveOrStop() {
        int random = getRandomNumber();
        if (isMoving(random)) {
            forward();
        }
    }

    public String getMoveCountToString() {
        return MOVE_STRING.repeat(this.moveCount);
    }

    public String getName() {
        return name;
    }

    private boolean isMoving(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(ZERO, NINE);
    }

    private void forward() {
        this.moveCount += ONE;
    }

    private void validateCarName(String name) {
        InputValidator.validateCarName(name);
    }
}
