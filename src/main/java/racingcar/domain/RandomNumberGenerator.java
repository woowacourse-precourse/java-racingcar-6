package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.consts.SystemConst;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(SystemConst.MIN_DIGIT_SIZE, SystemConst.MAX_DIGIT_SIZE);
    }
}
