package racingcar.domain.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.RacingConst;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(RacingConst.RACING_NUMBER_START,
                RacingConst.RACING_NUMBER_END);
    }

}
