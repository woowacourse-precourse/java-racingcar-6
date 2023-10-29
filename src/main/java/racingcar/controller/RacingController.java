package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.util.Convertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private RacingResult racingResult;

    public void startGame() {
        RacingCars racingCars = setParticipationCars();
        int tryCount = setTryCount();
        racing(racingCars, tryCount);
        OutputView.printWinner(racingResult.getWinner());
    }

    private RacingCars setParticipationCars() {
        OutputView.printCarNameInputMessage();
        String carNames = InputView.inputCarNames();
        return new RacingCars(CarFactory.generateParticipationCarList(carNames));
    }

    private int setTryCount() {
        OutputView.printTryCountInputMessage();
        return Convertor.convertStringToInt(InputView.inputTryCount());
    }

    private void racing(RacingCars racingCars, int tryCount) {
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
