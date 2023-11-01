package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private List<Car> cars;

    public void generateCars(List<String> carName) {
        List<Car> cars = carName.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = cars;
    }

    public void racing() {
        cars.forEach(car -> car.moveForward(car.generateNumber()));
    }

    public void printRoundResult() {
        cars.forEach(Car::printCurrentPosition);
        System.out.println();
    }

    public List<String> getWinner() {
        int maxCnt = cars.stream()
                .mapToInt(Car::getMoveCnt)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getMoveCnt() == maxCnt)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
