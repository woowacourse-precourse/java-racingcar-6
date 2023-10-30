package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Util implements NumberGenerator {
    public boolean isNullOrEmpty(String string) {
        if (string == null) {
            return true;
        }
        if (string.isEmpty()) {
            return true;
        }
        if (string.isBlank()) {
            return true;
        }
        return false;
    }

    public int getRandomDecimalNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
