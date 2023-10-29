package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();
    private final ValidateService validateService = new ValidateService();

    public void playGame() {
        String carNames = carNameInputOutputProcess();
        initGame(carNames);

        String inputNumber = numberInputOutputProcess();
        setCount(inputNumber);

    }

    private void setCount(String inputNumber) {
        validateService.validateInputNumber(inputNumber);
        racingCarService.setCount(inputNumber);
    }

    private String carNameInputOutputProcess() {
        outputView.printInputCarNameMessage();
        return inputView.inputCarName();
    }

    private void initGame(String carNames) {
        racingCarService.createCar(carNames);
    }

    private String numberInputOutputProcess() {
        outputView.printInputNumberMessage();
        return inputView.inputNumber();
    }

}
