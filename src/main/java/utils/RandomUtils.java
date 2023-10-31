package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean isPossibleMoveAhead() {
        int randomNumber = generateRandomNumber();
        if (isGreaterOrEqualThanFour(randomNumber)) {
           return true;
        }
        return false;
    }

    private static boolean isGreaterOrEqualThanFour(int randomNumber) {
        return randomNumber >= 4;
    }
}
