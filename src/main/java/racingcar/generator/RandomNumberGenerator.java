package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    static public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
