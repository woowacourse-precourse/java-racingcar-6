package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int THRESHOLD = 4;

    @Override
    public boolean isAbleToMove() {
        return getRandomNumber() >= THRESHOLD;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
