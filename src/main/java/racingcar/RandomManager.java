package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomManager {
    public static boolean isMovingCar() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }
}
