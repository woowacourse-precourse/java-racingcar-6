package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Car> winners = new ArrayList<>();

    public Winners(Cars cars) {
        int maxPosition = cars.getMaxPosition();
        winners = cars.getCars()
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        return winners;
    }

    public List<String> getNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
