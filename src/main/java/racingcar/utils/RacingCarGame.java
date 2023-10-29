package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
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

    public static void moveCarsForward(List<RacingCar> carList) {
        carList.forEach(car -> {
            if (isRandomForwardMove()) {
                car.moveForword();
            }
        });
    }

}
