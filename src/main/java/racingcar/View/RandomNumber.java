package racingcar.View;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    public static int makeRandom() {
        return pickNumberInRange(0, 9);
    }
}
