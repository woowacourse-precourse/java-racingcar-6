package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Global.Constants;

public class RandomNumberGenerator {

    public int getRandomNumberResult() {
        return Randoms.pickNumberInRange(Constants.minRange, Constants.maxRange);
    }
}
