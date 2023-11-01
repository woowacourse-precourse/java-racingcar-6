package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.view.InputView;

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
    }

    private void play(int round) {
        for (int i = 0; i < round; i++) {
            moveCars();
            
        }
    }

    private void displayCars() {

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
}
