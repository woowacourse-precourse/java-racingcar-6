package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomRacingCarMoveStrategy implements RacingCarMoveStrategy {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int DELIMITER_NUMBER = 4;


    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) <= DELIMITER_NUMBER;
    }
}
