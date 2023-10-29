package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.handler.ConstantsHandler.*;

public class RandomNumber {

    private final int randomNumber;

    private RandomNumber() {
        this.randomNumber = generateNumber();
    }

    public static RandomNumber create() {
        return new RandomNumber();
    }

    private int generateNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER,MAX_RANDOM_NUMBER);
    }

    public boolean isMovePossible() {
        return randomNumber >= NUMBER_POSSIBLE_TO_FORWARD;
    }
}
