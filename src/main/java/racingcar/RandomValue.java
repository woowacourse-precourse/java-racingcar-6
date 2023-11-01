package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RamdomValue {
    public boolean ramdomValueHamsu() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumber >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
