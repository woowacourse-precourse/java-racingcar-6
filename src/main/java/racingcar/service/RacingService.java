package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {
    private final static int FORWARD_NUMBER = 4;

    public static boolean isMovingForward() {
        return generateRandomNumber() >= FORWARD_NUMBER;
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
