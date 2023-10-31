package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Rule;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(Rule.MIN_POSSIBILITY, Rule.MAX_POSSIBILITY);
    }
}
