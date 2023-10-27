package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.util.Convertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private RacingResult racingResult;
    private RacingCars racingCars;

    public void startGame() {
        setParticipationCars();
        racing(setTryCount());
        OutputView.printWinner(racingResult.getWinner());
    }

    private void setParticipationCars() {
        OutputView.printCarNameInputMessage();
        String carNames = InputView.inputCarNames();
        racingCars = new RacingCars(CarFactory.generateParticipationCarList(carNames));
    }

    private int setTryCount() {
        OutputView.printTryCountInputMessage();
        return Convertor.convertStringToInt(InputView.inputTryCount());
    }

    private void racing(int tryCount) {
        OutputView.printExecutionResultMessage();
        while (isNotRacingFinished(tryCount)) {
            racingCars.move();
            OutputView.printResult(getRacingResult(racingCars));
            tryCount--;
        }
    }

    private boolean isNotRacingFinished(int tryCount) {
        return tryCount > 0;
    }

    private RacingResult getRacingResult(RacingCars racingCars) {
        racingResult = racingCars.createRacingResult();
        return racingResult;
    }
}
