package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarGameConsole {
    private static final int MOVE_JUDGE_INTEGER = 4;
    private Car car;
    private int carIndex = 0;

    private void updateCarMovement() {
        if (moveAllowed()) {
            car.move(carIndex);
        }
    }

    private boolean moveAllowed() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= MOVE_JUDGE_INTEGER;
    }
}
