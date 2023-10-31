package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.ConsoleWrapper;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {
    private final List<Car> cars;

    public RaceController(List<Car> cars) {
        this.cars = cars;
    }

    public void run(int numOfMoves) {
        for (int i = 0; i < numOfMoves; i++) {
            // 1. 각 차량을 순회하며 이동합니다.
            for (Car car : cars) {
                car.move();
            }
            // 2. 각 차수별 실행 결과 출력
            ConsoleWrapper.printRaceStatus(cars);
        }
    }

    public List<Car> getWinners() {
        // 3. 최종 우승자를 결정하여 반환합니다.
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}