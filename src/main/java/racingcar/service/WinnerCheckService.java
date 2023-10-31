package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class WinnerCheckService {

    public List<Car> getWinnersList(List<Car> cars) {
        int winnerPosition = getWinnerPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    private int getWinnerPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
