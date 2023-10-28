package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    public final List<Car> cars;
    public final int tryCount;

    public Race(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startRace(ResultView resultView) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move(new MoveStatus());
            }
            resultView.printRace(cars);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
