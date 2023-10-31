package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Dice {
    private Dice() {
    }

    public static boolean isSuccess() {
        return (getRandomNumber() >= 4);
    }

    private static int getRandomNumber() {
        return pickNumberInRange(0, 9);
    }
}
