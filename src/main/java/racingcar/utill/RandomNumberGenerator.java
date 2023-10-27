package racingcar.utill;

import static racingcar.domain.DomainConstant.RANDOM_NUMBER_LAST_RANGE;
import static racingcar.domain.DomainConstant.RANDOM_NUMBER_START_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START_RANGE, RANDOM_NUMBER_LAST_RANGE);
    }
}
