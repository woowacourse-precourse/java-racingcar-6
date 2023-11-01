package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;


public final class Race {

    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int MOVE_CARS_THRESHOLD = 4;
    private static final int ZERO_POSITION = 0;
    private static final int INITIAL_TURN = 0;
    private final List<Car> cars;
    private final int numberOfTurns;

    public Race(List<Car> cars, int numberOfTurns) {
        this.cars = cars;
        this.numberOfTurns = numberOfTurns;
    }

    public List<String> start() {
        OutputView.printRaceResultTitle();
        IntStream.range(INITIAL_TURN, numberOfTurns)
                .forEach(turn -> {
                    moveCars();
                    OutputView.printTurns(cars);
                });
        return judgmentWinners();
    }

    private void moveCars() {
        cars.stream().filter(car -> Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
                >= MOVE_CARS_THRESHOLD)
                .forEach(Car::movePosition);
    }

    private List<String> judgmentWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(ZERO_POSITION);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

    }

}
