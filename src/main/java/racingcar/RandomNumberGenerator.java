package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {

    public int getRandomNumber() {
        return pickNumberInRange(1, 9);
    }
}
