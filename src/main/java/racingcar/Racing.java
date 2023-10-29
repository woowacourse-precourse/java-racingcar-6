package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

    public static boolean isMovingForward() {
        return generateRandomNumber() >= 4;
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
