package racingcar.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {

    public int getRandomNumber() {
        return pickNumberInRange(0, 9);
    }
}
