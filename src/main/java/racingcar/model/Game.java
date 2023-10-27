package racingcar.model;

import java.util.List;
import java.util.OptionalInt;
import racingcar.util.MoveResolver;

public class Game {
    private final int MOVING_DISTANCE = 1;
    private final MoveResolver moveResolver = new MoveResolver();
    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(MOVING_DISTANCE,moveResolver);
        }
    }

    public List<Car> getWinnerCars() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        OptionalInt max = cars.stream().mapToInt(Car::getPosition).max();
        return max.orElse(0);
    }
}
