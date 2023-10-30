package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView INPUT_VIEW;
    private List<Car> cars;
    private int totalRoundCount;

    public GameController(InputView INPUT_VIEW) {
        this.INPUT_VIEW = INPUT_VIEW;
    }

    public void startGame() {
        List<String> carNames = INPUT_VIEW.inputName();
        this.cars = createCars(carNames);
        this.totalRoundCount = INPUT_VIEW.inputNumber();
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }
}
