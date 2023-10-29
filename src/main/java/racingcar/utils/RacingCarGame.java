package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarGame {
    private static int farthestDistance;

    public RacingCarGame() {
        farthestDistance = 0;
    }

    private static boolean isRandomForwardMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

}
