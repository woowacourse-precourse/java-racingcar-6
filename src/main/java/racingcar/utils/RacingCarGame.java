package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.RacingCar;

public class RacingCarGame {
    private static int farthestDistance;

    public RacingCarGame() {
        farthestDistance = 0;
    }

    private static boolean isRandomForwardMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

    public static void moveCarsForward(RacingCar car) {
        if (isRandomForwardMove()) {
            car.moveForword();
        }
    }

}
