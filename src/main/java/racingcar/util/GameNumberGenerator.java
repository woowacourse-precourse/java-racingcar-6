package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class GameNumberGenerator implements NumberGenerator {
    @Override
    public int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
