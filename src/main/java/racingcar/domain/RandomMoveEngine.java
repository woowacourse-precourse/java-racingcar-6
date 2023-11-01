package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.BooleanSupplier;

public class RandomMoveEngine implements BooleanSupplier {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean getAsBoolean() {
        int number = getRandomNumber();
        return number >= MOVE_THRESHOLD;
    }

    protected int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
