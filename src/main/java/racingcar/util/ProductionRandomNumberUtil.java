package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class ProductionRandomNumberUtil implements RandomNumberUtil {

    @Override
    public int generateNumberInRange(int startNumber, int endNumber) {
        return Randoms.pickNumberInRange(startNumber, endNumber);
    }
}
