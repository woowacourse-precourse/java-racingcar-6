package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class CarGoingRandomNumber implements NumberGenerator {
    @Override
    public int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
