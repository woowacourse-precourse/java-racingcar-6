package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.util.InputValidation;
import racingcar.view.OutputView;

public class RacingController {
    private final InputValidation inputValidation;

    public RacingController(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public void startGame() {
        InputView.greetingMessage();
        List<String> carNames = inputValidation.checkNameInputValid(InputView.inputCarsName());
        int round = inputValidation.checkRoundInputValid(InputView.inputRoundCount());
        OutputView.printResultConstant();

        doRound(carNames,round);
    }

    public void doRound(List<String> carNames, int round) {
        Cars cars = new Cars();
        cars.doRound(carNames, round);
    }

}
