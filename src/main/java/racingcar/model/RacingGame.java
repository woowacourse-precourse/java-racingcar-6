package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(List<String> carNames) {
        initCars(carNames);
    }

    private void initCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public String race() {
        for (Car racingCar : cars) {
            racingCar.move();
        }
        return new CurrentResultMap().getCurrentResultMap(cars);
    }

    public List<String> getWinners() {
        int maxMoveDistance = getMaxMoveDistance();
        List<String> winners = findWinners(maxMoveDistance);
        return winners;
    }

    private int getMaxMoveDistance() {
        return cars.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .getAsInt();
    }

    private List<String> findWinners(int maxMoveDistance) {
        return cars.stream()
                .filter(racingCar -> racingCar.getMoveDistance() == maxMoveDistance)
                .map(Car::getName)
                .toList();
    }
}
