package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public int generateRandomNumber() {
        return pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
