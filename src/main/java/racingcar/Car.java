package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int INITIAL_CAR_POSITION = 0;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVING_FORWARD_CRITERIA = 4;
    private final String name;
    public int position = INITIAL_CAR_POSITION;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        if (randomNumber >= MOVING_FORWARD_CRITERIA) {
            position++;
        }
    }
}
