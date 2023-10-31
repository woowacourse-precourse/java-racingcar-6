package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    int randomNumber;
    public int numberGenerator() {
        randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}