package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.output.CarInfo;
import racingcar.dto.output.WinnerInfo;
import racingcar.racing.MoveStrategy;

public class RacingCars {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public static RacingCars createCars(String[] names, MoveStrategy moveStrategy) {
        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .toList();
        return new RacingCars(cars, moveStrategy);
    }

    private RacingCars(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        cars.forEach(this::tryMoveCar);
    }

    public List<CarInfo> roundResults() {
        return cars.stream()
                .map(Car::toCarInfo)
                .toList();
    }

    public WinnerInfo getWinner() {
        int winnerScore = determineWinnerScore();
        return new WinnerInfo(getWinnerNames(winnerScore));
    }

    private void tryMoveCar(Car car) {
        if (moveStrategy.isMovable()) {
            car.increaseMoveCount();
        }
    }

    private int determineWinnerScore() {
        int maxMoveCount = 0;
        for (Car car : cars) {
            maxMoveCount = car.updateMax(maxMoveCount);
        }
        return maxMoveCount;
    }

    private List<String> getWinnerNames(int winnerScore) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            car.addWinnerToList(winnerScore, winnerNames);
        }
        return winnerNames;
    }
}
