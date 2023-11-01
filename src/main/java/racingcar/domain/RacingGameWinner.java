package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameWinner {
    private ArrayList<Car> cars;

    public RacingGameWinner(ArrayList<Car> cars) {
        this.cars = cars;
    }

    private List<String> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getScore() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void printWinners() {
        List<String> winners = findWinners(cars);
        String result = String.join(",", winners);
        System.out.print("최종 우승자 : " + result);
    }
}
