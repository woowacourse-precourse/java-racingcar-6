package racingcar.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    public static int getRandomNumber() {
        return pickNumberInRange(0, 9);
    }
}
