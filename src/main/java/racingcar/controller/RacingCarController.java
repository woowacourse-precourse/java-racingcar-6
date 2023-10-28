package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void playGame() {
        String carNames = carNameProcess();
        racingCarService.createCar(carNames);
    }

    private String carNameProcess() {
        outputView.printInputCarNameMessage();
        return inputView.inputCarName();
    }
}
