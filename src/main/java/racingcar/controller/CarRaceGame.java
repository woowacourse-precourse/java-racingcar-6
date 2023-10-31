package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
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

    public void play() {
        createCars(InputView.getCarNames());
        
    }

    private void createCars(Set<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }
}
