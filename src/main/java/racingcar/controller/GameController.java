package racingcar.controller;

import racingcar.model.Car;
import racingcar.validator.CountInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final CarController carController = new CarController();
    private final RaceController raceController = new RaceController();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CountInputValidator countInputValidator = new CountInputValidator();

    public void proceed() {
        List<Car> racingCars = carController.getRacingCars(inputView.getCarNameInput());
        StringBuilder raceResult = new StringBuilder();
        int count = getValidatedCount(inputView.getCountInput());

        for (int i = 0; i < count; i++) {
            raceController.race(racingCars);
            raceResult.append(raceController.getNameAndRecord(racingCars));

            if (i == count - 1) {
                continue;
            }

            raceResult.append("\n");
        }

        outputView.printNameAndRecord(raceResult.toString());
        outputView.printWinnerName(raceController.getWinnerName(racingCars));
    }

    public int getValidatedCount(String playerInput) {
        countInputValidator.validate(playerInput);
        return Integer.parseInt(playerInput);
    }
}
