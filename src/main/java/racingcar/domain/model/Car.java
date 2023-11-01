package racingcar.domain.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RacingGameConstant;

public class Car {
    private static final int MOVE_THRESHOLD = RacingGameConstant.MOVE_THRESHOLD;
    private static final int INITIAL_POSITION = RacingGameConstant.INITIAL_POSITION;
    private static final int RANDOM_MIN = RacingGameConstant.RANDOM_MIN;
    private static final int RANDOM_MAX = RacingGameConstant.RANDOM_MAX;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void move() {
        if (shouldMove()) {
            increasePosition();
        }
    }

    private boolean shouldMove() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= MOVE_THRESHOLD;
    }

    private void increasePosition() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}