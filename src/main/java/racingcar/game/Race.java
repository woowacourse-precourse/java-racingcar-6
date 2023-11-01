package racingcar.game;

import racingcar.game.Car;

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
        System.out.println("실행 결과");

        while (count > 0) {
            cars.forEach(Car::move);
            cars.forEach(Car::printNameAndPosition);

            System.out.println();
            count--;
        }

        printWinners();
    }

    private void printWinners() {
        String winnerNames = cars.stream()
                .filter(car -> car.isWinner(cars))
                .map(Car::toString)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }
}
