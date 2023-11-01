package racingcar.controller;

import java.util.List;
import racingcar.dto.Car;
import racingcar.model.service.CarService;
import racingcar.model.service.CarServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private CarService carService = CarServiceImpl.getInstance();
    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();

    public void run() {
        initRacingcar();
        simulRacingcar();
        awardRacingcar();
    }

    private void awardRacingcar() {
        outputView.printWinners(carService.selectWinnerNames());
    }

    private void simulRacingcar() {
        while (!carService.isRacingcarStop()) {
            carService.goOrStop();
            outputView.printAllCarResult(carService.showCarLineupInfo());
        }
    }

    private void initRacingcar() {
        carService.registerCarLineUp(inputView.inputCarNames());
        carService.registerTryCount(inputView.inputTryCount());
    }
}
