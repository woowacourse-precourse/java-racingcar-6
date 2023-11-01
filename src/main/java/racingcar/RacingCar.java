package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private static final int MOVING_STANDARD = 4;
    private static final int STARTING_POSITION = 0;
    private static final int RANDOM_NUMBER_START_RANGE = 0;
    private static final int RANDOM_NUMBER_END_RANGE = 9;

    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = STARTING_POSITION;
    }

    public void race() {
        if (canMoveForward()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean canMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(
            RANDOM_NUMBER_START_RANGE, RANDOM_NUMBER_END_RANGE);
        return randomNumber >= MOVING_STANDARD;
    }
}
