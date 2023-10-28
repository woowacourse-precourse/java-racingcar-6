package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class PrintResult {
    public void printWinner(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);

        List<String> winners = cars.stream()
                .filter(car -> car.getDistance().length() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.getDistance().length())
                .max()
                .orElse(0);
    }
}
