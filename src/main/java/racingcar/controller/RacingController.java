package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.RacingCars;
import racingcar.util.Convertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        OutputView.printCarNameInputMessage();
        String carNames = InputView.inputCarNames();
        RacingCars racingCars = new RacingCars(CarFactory.generateParticipationCarList(carNames));
        OutputView.printTryCountInputMessage();
        int tryCount = Convertor.convertStringToInt(InputView.inputTryCount());
        racing(racingCars, tryCount);
        OutputView.printWinner(racingCars.getWinner());
    }

    private void racing(RacingCars racingCars, int tryCount) {
        OutputView.printExecutionResultMessage();
        while (isNotRacingFinished(tryCount)) {
            racingCars.move();
            OutputView.printResult(racingCars.getCarStatuses());
            tryCount--;
        }
    }

    private boolean isNotRacingFinished(int tryCount) {
        return tryCount > 0;
    }
}
