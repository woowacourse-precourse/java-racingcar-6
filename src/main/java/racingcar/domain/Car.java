package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.CarNameValidator;

public class Car {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        CarNameValidator.validateCarName(name);
        return new Car(name);
    }

    public void play() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        int number = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
        return (number >= MOVE_THRESHOLD);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
