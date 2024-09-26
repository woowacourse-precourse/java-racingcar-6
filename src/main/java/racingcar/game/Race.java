package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private int count;
    private final List<Car> cars = new ArrayList<>();

    public Race(String[] carNames, int count) {
        this.count = count;
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void start() {
        while (count > 0) {
            moveAndPrint();
            count--;
        }
    }

    public void result() {
        System.out.println("최종 우승자 : " + getWinners());
    }

    private void moveAndPrint() {
        cars.forEach(Car::move);
        cars.forEach(Car::printNameAndPosition);
        System.out.println();
    }

    private String getWinners() {
        return cars.stream()
                .filter(car -> car.isWinner(cars))
                .map(Car::toString)
                .collect(Collectors.joining(", "));
    }
}
