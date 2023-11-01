package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public int getRandomNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
