package racingcar.domain;

import static racingcar.util.GameConfig.MAX_NUMBER;
import static racingcar.util.GameConfig.MIN_NUMBER;
import static racingcar.util.GameConfig.MOVE_FORWARD_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private final int randomNumber;

    private RandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static RandomNumber generate() {
        int generatedNumber = Randoms.pickNumberInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
        return new RandomNumber(generatedNumber);
    }

    public boolean isEqualOrGreaterThanFour() {
        return this.randomNumber >= MOVE_FORWARD_THRESHOLD.getValue();
    }
}
