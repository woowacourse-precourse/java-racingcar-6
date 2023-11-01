package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceGame {
    private static CarRaceGame instance;
    private final List<Car> cars;

    private CarRaceGame() {
        cars = new ArrayList<>();
    }

    public static CarRaceGame getInstance() {
        if (instance == null) {
            instance = new CarRaceGame();
        }
        return instance;
    }

    public void run() {
        createCars(InputView.getCarNames());
        play(InputView.getRound());
        OutputView.displayWinner(getWinner());
    }

    private void play(int round) {
        for (int i = 0; i < round; i++) {
            moveCars();
            displayCars();
        }
    }

    private void displayCars() {
        for (Car car : cars) {
            OutputView.displayCar(car);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int num = NumberGenerator.createRandomNumber();
            car.move(num);
        }
    }

    private void createCars(Set<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private List<String> getWinner() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }
}
