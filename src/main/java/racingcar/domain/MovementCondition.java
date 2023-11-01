package racingcar.domain;

import static racingcar.util.GameConstants.MAX_NUMBER;
import static racingcar.util.GameConstants.MIN_NUMBER;
import static racingcar.util.GameConstants.MOVE_FORWARD_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementCondition {
    private final int randomNumber;

    private MovementCondition(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static MovementCondition generate() {
        int generatedNumber = Randoms.pickNumberInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
        return new MovementCondition(generatedNumber);
    }

    public boolean isMovable() {
        return this.randomNumber >= MOVE_FORWARD_THRESHOLD.getValue();
    }
}
