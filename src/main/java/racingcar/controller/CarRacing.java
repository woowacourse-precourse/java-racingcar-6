package racingcar.controller;

import racingcar.InputValidator;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRacing {
    private RacingCars racingCars;
    private int count;

    public void race() {
        inputRacingCars();
        inputCount();
        playCountTimes();
        showFinalWinners();
    }

    private void inputRacingCars() {
        List<String> racingCarsName = inputRacingCarsName();
        racingCars = new RacingCars(racingCarsName);
    }

    private List<String> inputRacingCarsName() {
        return validateRacingCarsName(InputView.inputRacingCarsName());
    }

    private List<String> validateRacingCarsName(String inputRacingCarsName) {
        return InputValidator.validateRacingCarsName(inputRacingCarsName);
    }

    private void inputCount() {
        count = validateCount(InputView.inputCount());
    }

    private int validateCount(String inputCount) {
        return InputValidator.validateCount(inputCount);
    }

    private void playCountTimes() {
        showResultMessage();
        for (int i = 0; i < count; ++i) {
            racingCars.play();
            showResult();
        }
    }

    private void showResultMessage() {
        OutputView.printResult();
    }

    private void showResult() {
        OutputView.printMove(racingCars.makeResultMap());
    }

    private void showFinalWinners() {
        List<String> winners = racingCars.getWinners();
        OutputView.printFinalWinners(winners);
    }
}
