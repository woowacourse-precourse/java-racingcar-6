package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.config.GameConfig.INITIAL_DISTANCE;
import static racingcar.config.GameConfig.MAX_RANDOM_VALUE;
import static racingcar.config.GameConfig.MIN_RANDOM_VALUE;
import static racingcar.config.GameConfig.MIN_TO_MOVE;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;

    public Car(final String name) {
        this.name = name;
        this.distance = INITIAL_DISTANCE;
    }

    public void move() {
        final int randomNumber = createRandomNumber();
        if (randomNumber >= MIN_TO_MOVE) {
            distance++;
        }
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(final Car other) {
        return Integer.compare(this.distance, other.distance);
    }
}
