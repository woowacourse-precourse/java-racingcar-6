package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGroup {

    private List<Car> carGroup;

    public CarGroup(List<Car> cars) {
        this.carGroup = cars;
    }

    public void move(int roundNumber) {
        IntStream.range(0, roundNumber)
            .forEach(round -> carGroup.forEach(Car::move));
    }

    public List<String> calculateWinners() {
        return carGroup.stream()
            .filter(car -> car.getPosition() == getMaxPosition())
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carGroup.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    public List<Car> getCars() {
        return carGroup;
    }
}
