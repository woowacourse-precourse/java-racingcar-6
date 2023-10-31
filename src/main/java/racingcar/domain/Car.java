package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.domain.constants.Number.MAX_RANDOM_NUMBER;
import static racingcar.domain.constants.Number.MIN_RANDOM_NUMBER;
import static racingcar.domain.constants.Number.MOVEMENT_POSSIBLE_NUMBER;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;


    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int generateRandomNumber() {
        return pickNumberInRange(MIN_RANDOM_NUMBER.getNumber(), MAX_RANDOM_NUMBER.getNumber());
    }

    public void moveForward(int number) {
        if (number >= MOVEMENT_POSSIBLE_NUMBER.getNumber()) {
            distance++;
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.distance - o.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Car car) {
            return this.distance == car.distance;
        }
        return false;
    }

}
