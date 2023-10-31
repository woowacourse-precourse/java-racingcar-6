package racingcar.implementation;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomBooleanGenerator {
    public boolean randomBooleanGenerator() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4 && randomNumber <= 9) {
            return true;
        } else {
            return false;
        }
    }
}
