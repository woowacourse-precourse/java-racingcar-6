package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.CarPosition;
import racingcar.config.RandomConfig;

public class RandomUtils {

    public CarPosition determinePositionByRandomNumber() {
        int randomNumber = makeRandomNumber();
        if (randomNumber >= RandomConfig.DETERMINE_VALUE) {
            return CarPosition.STRAIGHT;
        } else {
            return CarPosition.STOP;
        }
    }

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(RandomConfig.MIN_VALUE, RandomConfig.MAX_VALUE);
    }
}
