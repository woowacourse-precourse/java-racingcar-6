package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class RacingcarGame {
    private static final int COUNT_ONE = 1;
    private static final int NUMBER_FOUR = 4;
    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_NINE = 9;

    public void increaseMoveForwardCount(Car car) {
        if (isGreaterThanOrEqualFour()) {
            car.setMoveForwardCount(COUNT_ONE);
        }
    }

    public boolean isGreaterThanOrEqualFour() {
        return generateRandomNumber() >= NUMBER_FOUR;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(NUMBER_ZERO, NUMBER_NINE);
    }
}
