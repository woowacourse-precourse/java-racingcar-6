package racingcar.model;

import static racingcar.Constant.RANDOM_MAXIMUM_NUMBER;
import static racingcar.Constant.RANDOM_MINIMUM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class GameRandomNumber implements RandomNumber {

    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(RANDOM_MINIMUM_NUMBER.getValue(), RANDOM_MAXIMUM_NUMBER.getValue());
    }
}
