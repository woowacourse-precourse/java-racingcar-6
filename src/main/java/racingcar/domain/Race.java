package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void play() {
        start();
        printProgress();
    }

    public void printWinner() {
        List<Car> winners = pickWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + winnerNames);
    }

    private void start() {
        cars.forEach(Car::move);
    }

    private void printProgress() {
        cars.forEach(System.out::println);
    }

    private List<Car> pickWinners() {
        int winnerPosition = this.getWinningPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    private int getWinningPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
