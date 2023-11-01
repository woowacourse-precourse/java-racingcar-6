package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public void runGame(int number) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < number; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }

        List<Car> winners = determineWinners();
        System.out.println("최종 우승자 : " + joinCarNames(winners));
    }

    private List<Car> determineWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }

    private String joinCarNames(List<Car> cars) {
        return cars.stream().map(Car::getName).collect(Collectors.joining(", "));
    }
}