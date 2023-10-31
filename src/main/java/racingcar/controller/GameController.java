package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final CarController carController = new CarController();
    private final RaceController raceController = new RaceController();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private void race(List<Car> racingCars) {
        for (Car car : racingCars) {
            raceController.addRecord(car);
        }
    }

    public void proceed() {
        String playerInput = inputView.getCarNameInput();
        List<Car> racingCars = carController.getRacingCars(playerInput);
        StringBuilder raceResult = new StringBuilder();

        int count = inputView.getCountInput();
        for (int i = 0; i < count; i++) {
            race(racingCars);
            raceResult.append(raceController.getNameAndRecord(racingCars));

            if (i == count - 1) {
                continue;
            }

            raceResult.append("\n");
        }

        outputView.printNameAndRecord(raceResult.toString());
        outputView.printWinnerName(raceController.getWinnerName(racingCars));
    }


}
