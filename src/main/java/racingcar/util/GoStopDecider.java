package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

public class GoStopDecider {

    private static final int GO__NUMBER = 4;
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 9;

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
    }

    private boolean checkGoStop(int randomNumber) {
        return randomNumber >= GO__NUMBER;
    }

    public void moveCarOnRandomValue(Car car) {
        if (checkGoStop(getRandomNumber())) {
            car.upDistance();
        }
    }
}
