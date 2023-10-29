package racingcar.controller;

import racingcar.InputValidator;
import racingcar.model.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private CarRacing carRacing;
    private int count;

    public void proceedGame() {
        initCarRacing();
        inputRacingCars();
        inputCount();
        playCountTimes();
        showFinalWinners();
    }

    private void inputRacingCars() {
        List<String> racingCarsName = inputRacingCarsName();
        carRacing = new CarRacing(racingCarsName);
    }

    private List<String> inputRacingCarsName() {
        String racingCarsName = InputView.inputRacingCarsName();
        return InputValidator.validateRacingCarsName(racingCarsName);
    }

    private void inputCount() {
        String count = InputView.inputCount();
        this.count = InputValidator.validateCount(count);
    }

    private void playCountTimes() {
        showResultMessage();
        for (int i = 0; i < count; ++i) {
            carRacing.play();
            showResult();
        }
    }

    private void showResultMessage() {
        OutputView.printResult();
    }

    private void showResult() {
        OutputView.printMove(carRacing.makeResultMap());
    }

    private void showFinalWinners() {
        List<String> winners = carRacing.getWinners();
        OutputView.printFinalWinners(winners);
    }
}
