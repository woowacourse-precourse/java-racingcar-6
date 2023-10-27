package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final RaceCount raceCount;

    public RacingGame(List<Car> cars, int raceCount) {
        this.cars = new Cars(cars);
        this.raceCount = new RaceCount(raceCount);
    }

    public void race(NumberGenerator numberGenerator) {
        cars.makeMoveOrStop(numberGenerator);

        raceCount.decrease();
    }

    public boolean isGameEnd() {
        return raceCount.isLastCount();
    }

    public List<String> findWinners() {
        validateGameState();

        return findWinners(cars.findMostMovedCars());
    }

    private List<String> findWinners(List<Car> mostMovedCars) {
        return mostMovedCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateGameState() {
        if (!isGameEnd()) {
            throw new IllegalArgumentException("게임이 종료되지 않은 상태에서 우승자를 찾을 수 없습니다.");
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
