package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.InputValidator;
import racingcar.service.RacingCarGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingCarGameService racingCarGameService;
    private CarService carService;
    private InputValidator inputValidator;

    public RacingCarGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carService = new CarService();
        this.racingCarGameService = new RacingCarGameService();
        this.inputValidator = new InputValidator();
    }
    public void run() {
        String carName = inputView.getCarNames();
        inputValidator.isValidCarName(carName);

        String attemptStr = inputView.getAttemptStr();
        inputValidator.isValidAttemptNum(attemptStr);
        int attemptNum = Integer.parseInt(attemptStr);

        List<Car> carList = carService.createCar(carName);

        outputView.displayGameResult();
        racingCarGameService.displayGameProgress(attemptNum, carList);

        outputView.displayFinalWinner();
        racingCarGameService.displayWinnerCar(carList);

    }
}
