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

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                Integer randomNumber = RandomNumberGenerator.generate();
                if (randomNumber >= 4) {
                    car.forward();
                }
                System.out.println(car.toString());
            }
            System.out.println();
        }
    }

    public void result() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);

        List<Car> winners = cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winners.stream().map(Car::getName).toList()));
    }
}
