package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public int create() {
        return Randoms.pickNumberInRange(0,9);
    }
}
