package racingcar.domain.game;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.formula.Formula;

public class RaceGame {

    private final int MINIMUM_ROUND = 1;

    private final List<Car> cars;
    private final Formula formula;
    private int round;

    public RaceGame(final Formula formula, final List<Car> cars, final int round) {
        validateRound(round);
        this.formula = formula;
        this.cars = cars;
        this.round = round;
    }

    private void validateRound(final int round) {
        isRoundPositive(round);
    }

    private void isRoundPositive(final int round) {
        if (round < MINIMUM_ROUND) {
            throw new IllegalArgumentException("시도할 회수는 1 이상이어야 합니다.");
        }
    }

    public void race(final Consumer<List<RaceGameResult>> consumer) {
        while (round >= MINIMUM_ROUND) {
            List<RaceGameResult> raceResults = cars.stream()
                    .map(car -> new RaceGameResult(car.getName(), car.move(formula)))
                    .collect(Collectors.toList());
            consumer.accept(raceResults);
            round--;
        }
    }

    private Car findHeadOfRace() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차 목록이 비어있습니다."));
    }

    private List<String> findSamePositionCar(final Car headOfRace) {
        return cars.stream()
                .filter(headOfRace::isSamePosition)
                .map(Car::getName)
                .toList();
    }

    public List<String> currentHeadOfRace() {
        final Car headOfRace = findHeadOfRace();
        return findSamePositionCar(headOfRace);
    }
}
