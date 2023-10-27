package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.domain.CarConstants.*;

public class RandomCarStateGenerator {

    private static final int MOVE_STANDARD_NUMBER = 4;

    public static CarState generate() {
        return CarState.from(isMoving());
    }

    private static boolean isMoving() {
        return getRandomNumber() >= MOVE_STANDARD_NUMBER;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER);
    }
}
