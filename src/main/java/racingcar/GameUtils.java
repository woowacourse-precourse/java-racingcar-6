package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtils {

    public static String numToHyphen(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(num));
        return sb.toString();
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean canMoveForward(int num) {
        if (num >= 4) {
            return true;
        }
        return false;
    }


}
