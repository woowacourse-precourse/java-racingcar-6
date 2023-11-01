package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public int generator() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
