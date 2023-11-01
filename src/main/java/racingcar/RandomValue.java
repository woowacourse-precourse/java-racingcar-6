package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomValue {
    public boolean forwardDecision() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumber >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
