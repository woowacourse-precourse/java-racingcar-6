package racingcar.controller;

import static racingcar.view.input.Input.inputNames;
import static racingcar.view.input.Input.inputTrialAmount;
import static racingcar.view.output.Output.printMessage;
import static racingcar.view.output.Output.printNewLine;

import racingcar.domain.car.Cars;
import racingcar.service.CarService;
import racingcar.view.output.OutputMessage;

public class GameController {

    private static final String CAR = "자동차";

    public void startCarGame() {
        printMessage(OutputMessage.PLEASE_ENTER_CAR_NAME, CAR);
        Cars cars = new Cars(inputNames());

        printMessage(OutputMessage.HOW_MANY_TIME);
        int trialAmount = inputTrialAmount();
        printNewLine();

        CarService carService = new CarService(cars);

        carService.progressCarGame(trialAmount);
    }
}
