package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import racingcar.util.MoveResolver;

public class Game {
    private final int MOVING_DISTANCE = 1;
    private final MoveResolver moveResolver = new MoveResolver();
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(MOVING_DISTANCE, moveResolver);
        }
    }

    public List<Car> getWinnerCars() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<GameResult> generateGameResultList() {
        return cars.stream()
                .map(Car::generateGameResult)
                .toList();
    }

    private int getMaxPosition() {
        OptionalInt max = cars.stream().mapToInt(Car::getPosition).max();
        return max.orElse(0);
    }
}
