package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    private static final int TURN_ON_THRESHOLD = 4;

    public boolean turnOn() {
        return generateRandomNumber() >= TURN_ON_THRESHOLD;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
