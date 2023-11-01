package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCarStateGenerator {

    private static final int MIN_MOVE_NUMBER = 0;
    private static final int MAX_MOVE_NUMBER = 9;
    private static final int MOVE_STANDARD_NUMBER = 4;

    public static CarState generate() {
        return CarState.from(isMove());
    }

    private static boolean isMove() {
        return getRandomNumber() >= MOVE_STANDARD_NUMBER;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER);
    }
}