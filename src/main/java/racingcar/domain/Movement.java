package racingcar.domain;

import static racingcar.constant.GameNumber.RANDOM_NUMBER_MAXIMUM;
import static racingcar.constant.GameNumber.RANDOM_NUMBER_MINIMUM;

import camp.nextstep.edu.missionutils.Randoms;

public class Movement {
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM);
    }
}
