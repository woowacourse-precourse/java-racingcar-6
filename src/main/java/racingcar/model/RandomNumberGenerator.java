package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.constants.RandomConstants;

public class RandomNumberGenerator implements NumberGenerator{

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RandomConstants.START_NUMBER, RandomConstants.END_NUMBER);
    }
}
