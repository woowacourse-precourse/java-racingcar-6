package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.service.CarService;
import racingcar.view.input.Input;
import racingcar.view.output.Output;
import racingcar.view.output.OutputMessage;

public class CarController {

    private static final String CAR = "자동차";

    public void startCarGame() {
        Output.printMessage(OutputMessage.PLEASE_ENTER_CAR_NAME, CAR);

        Cars cars = new Cars(Input.bringNames());
        CarService carService = new CarService(cars);

        carService.progressCarGame();
    }
}
