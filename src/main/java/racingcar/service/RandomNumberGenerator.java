package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.IntegerConstant;

public class RandomNumberGenerator {

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(IntegerConstant.MIN_RANDOM_NUMBER.getValue(),
                IntegerConstant.MAX_RANDOM_NUMBER.getValue());
    }
}
