package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private static final int MOVING_THRESHOLD = 4;

    public static int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void moveCarIfPossible(Car car, int randomValue) {
        if (randomValue >= MOVING_THRESHOLD) {
            car.move();
        }
    }


}
