package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Judgement {

    public String determineWinners(Racing racing) {
        List<Car> cars = racing.getCars();
        int maxForwardCount = calculateMaxForwardCount(cars);

        return cars.stream()
                .filter(car -> car.getForwardCount() == maxForwardCount)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int calculateMaxForwardCount(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }
}
