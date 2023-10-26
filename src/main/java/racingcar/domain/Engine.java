package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    private static final int FORWARD_THRESHOLD = 4;

    public boolean tryToTurnOn() {
        return generateRandomNumber() >= FORWARD_THRESHOLD;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
