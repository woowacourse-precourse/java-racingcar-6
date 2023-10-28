package racingcar.Utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
