package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private String distance;
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MOVEMENT_POSSIBLE_NUMBER = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int generateRandomNumber() {
        return pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public void moveForward() {
        if (generateRandomNumber() >= MOVEMENT_POSSIBLE_NUMBER) {
            distance += "-";
        }
    }

    @Override
    public String toString() {
        return name + " : " + distance;
    }
}
