package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.ExceptionMessage;

public class Car {
    private final static int MAX_NAME_LENGTH = 5;
    private final static int NO_MOVE_CAR_NUMBER = 3;
    private final String name;
    private int distance;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        distance = 0;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_MAX_LENGTH_EXCEEDED
                    .getErrorMessage());
        }
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) > NO_MOVE_CAR_NUMBER) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
