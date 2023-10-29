package domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovingStrategy implements MoveStrategy{
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVABLE_STANDARD = 4;

    @Override
    public boolean isMove() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVABLE_STANDARD;
    }
}
