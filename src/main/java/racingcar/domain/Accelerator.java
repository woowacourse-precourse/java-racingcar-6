package racingcar.domain;

import static racingcar.utils.Constants.MAX_STRENGTH;
import static racingcar.utils.Constants.MIN_STRENGTH;

import camp.nextstep.edu.missionutils.Randoms;

public class Accelerator {
    public boolean press() {
        int pressStrength = Randoms.pickNumberInRange(MIN_STRENGTH, MAX_STRENGTH);
        return canGo(pressStrength);
    }

    public boolean canGo(int strength) {
        if (strength >= 4) {
            return true;
        }
        return false;
    }
}
