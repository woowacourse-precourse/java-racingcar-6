package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


public final class Race {

    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int MOVE_CARS_THRESHOLD = 4;
    private final List<Car> cars;
    private final int numberOfTurns;

    public Race(List<Car> cars, int numberOfTurns) {
        this.cars = cars;
        this.numberOfTurns = numberOfTurns;
    }

    public List<String> start() {

    }

    private void moveCars() {
        cars.stream().filter(car -> Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
                >= MOVE_CARS_THRESHOLD)
                .forEach(Car::movePosition);
    }

    private List<String> judgmentWinners() {

    }

}
