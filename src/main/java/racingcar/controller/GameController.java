package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.List;

public class GameController {
    private final CarController carController = new CarController();
    private final RaceController raceController = new RaceController();
    private final InputView inputView = new InputView();

    public void race(List<Car> racingCars) {
        for (Car car : racingCars) {
            raceController.addRecord(car);
        }
    }

    public void proceed() {
        List<Car> racingCars = carController.getRacingCars();

        int count = inputView.getCountInput();
        for (int i = 0; i < count; i++) {
            race(racingCars);
        }
    }
}
