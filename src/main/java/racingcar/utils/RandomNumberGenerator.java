package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
