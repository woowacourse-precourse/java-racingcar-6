package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;

public class Race {
    private final List<Car> cars;
    private final Integer round;

    public Race(List<Car> cars, Integer round) {
        this.cars = cars;
        this.round = round;
    }

    public void run() {
        begin();
        result();
    }

    private void begin() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < round; i++) {
            round();
        }
    }

    private void round() {
        for (Car car : cars) {
            if (RandomNumberGenerator.generate() >= 4) {
                car.forward();
            }
            System.out.println(car.toString());
        }
        System.out.println();
    }

    private void result() {
        System.out.println("최종 우승자 : " +
                String.join(", ", getWinners().stream()
                        .map(Car::getName)
                        .toList())
        );
    }

    private List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .toList();
    }
}
