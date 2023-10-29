package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.domain.constants.number.MAX_RANDOM_NUMBER;
import static racingcar.domain.constants.number.MIN_RANDOM_NUMBER;
import static racingcar.domain.constants.number.MOVEMENT_POSSIBLE_NUMBER;

public class Car {
    private final String name;
    private String distance = "";


    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    public int generateRandomNumber() {
        return pickNumberInRange(MIN_RANDOM_NUMBER.getNumber(), MAX_RANDOM_NUMBER.getNumber());
    }

    public void moveForward(int number) {
        if (number >= MOVEMENT_POSSIBLE_NUMBER.getNumber()) {
            distance += "-";
        }
    }

    @Override
    public String toString() {
        return name + " : " + distance;
    }
}
