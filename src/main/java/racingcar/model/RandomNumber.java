package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private static int randomNum;

    public static void make() {
        randomNum = pickNumberInRange(0, 9);
    }

    public static boolean isForward() {
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }
}
