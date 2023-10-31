package racingcar.model.movement;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Movement {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_MOVE_NUMBER = 4;

    public boolean canMove() {
        int randomNumber = generateRandomNumber();
        return randomNumber >= MIN_MOVE_NUMBER;
    }

    int generateRandomNumber() {
        return pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
