package racingcar.controller;

import static racingcar.view.input.Input.inputNames;
import static racingcar.view.output.Output.printMessage;

import racingcar.domain.car.Cars;
import racingcar.service.CarService;
import racingcar.view.output.OutputMessage;

public class CarController {

    private static final String CAR = "자동차";

    public void startCarGame() {
        printMessage(OutputMessage.PLEASE_ENTER_CAR_NAME, CAR);

        Cars cars = new Cars(inputNames());
        CarService carService = new CarService(cars);

        carService.progressCarGame();
    }
}
