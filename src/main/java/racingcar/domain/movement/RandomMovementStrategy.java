package racingcar.domain.movement;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.utils.RacingConfig.MAX_NUMBER;
import static racingcar.utils.RacingConfig.MIN_NUMBER;
import static racingcar.utils.RacingConfig.MOVE_FORWARD_VALUE;

public class RandomMovementStrategy implements MovementStrategy {
    @Override
    public boolean couldMove() {
        int randomValue = generateRandomNumber();
        return randomValue >= MOVE_FORWARD_VALUE;
    }

    private int generateRandomNumber() {
        return pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
    }
}
