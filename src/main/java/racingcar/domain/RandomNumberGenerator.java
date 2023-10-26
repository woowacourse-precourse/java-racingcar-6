package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int generateNumber() {
        int num = Randoms.pickNumberInRange(0, 9);
        return num;
    }
}