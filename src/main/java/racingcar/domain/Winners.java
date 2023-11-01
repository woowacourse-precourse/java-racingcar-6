package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Car> winners;
    private int MaxPosition;

    public Winners(List<Car> cars) {
        this.MaxPosition = getMaxPosition(cars);
        this.winners = getWinners(cars);
    }

    public int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(Integer.MIN_VALUE);
    }

    public List<Car> getWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        cars.forEach(car -> {
            if (car.getPosition() == this.MaxPosition) {
                winners.add(car);
            }
        });
        return winners;
    }

    public List<String> getWinnersName() {
        return winners.stream().map(Car::getName).collect(Collectors.toList());
    }

}
