package racingcar.domain;

import static racingcar.domain.constant.RandomNumberConstant.RANDOM_NUMBER_LAST_RANGE;
import static racingcar.domain.constant.RandomNumberConstant.RANDOM_NUMBER_START_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utill.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START_RANGE, RANDOM_NUMBER_LAST_RANGE);
    }
}
