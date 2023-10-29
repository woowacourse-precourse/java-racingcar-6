package racingcar.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class Winner {
    private static final String DELIMITER = ", ";
    private final String winners;

    public Winner(Cars cars) {
        this.winners = judgeWinner(cars);
    }

    public String judgeWinner(Cars cars) {
        int maxPosition = getMaxPosition(cars);
        List<Car> target = cars.getCars();
        return target.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    public int getMaxPosition(Cars cars) {
        List<Car> target = cars.getCars();
        return target.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    @Override
    public String toString() {
        return winners;
    }
}
