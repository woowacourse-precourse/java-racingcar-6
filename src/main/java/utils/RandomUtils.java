package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean isPossibleMoveAhead() {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= 4) {
           return true;
        }
        return false;
    }
}
