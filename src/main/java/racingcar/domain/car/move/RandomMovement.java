package racingcar.domain.car.move;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovement extends Movement {
    @Override
    public void move() {
        if(isMovable()) {
            addPosition(1);
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

}
