package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameModel {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN, Constants.MAX);
    }

    public static boolean decideGoAndStop() {
        if (generateRandomNumber() >= Constants.CRITICAL_NUMBER) {
            return true;
        }
        return false;
    }
}
