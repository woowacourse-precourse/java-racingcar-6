package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
