package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.util.Convertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        RacingCars racingCars = getParticipationCars();
        int tryCount = getTryCount();
        racing(racingCars, tryCount);
        finishRacing(racingCars);
    }

    private RacingCars getParticipationCars() {
        OutputView.printCarNameInputMessage();
        String carNames = InputView.inputCarNames();
        return new RacingCars(CarFactory.generateParticipationCarList(carNames));
    }

    private int getTryCount() {
        OutputView.printTryCountInputMessage();
        return Convertor.convertStringToInt(InputView.inputTryCount());
    }

    private void racing(RacingCars racingCars, int tryCount) {
        OutputView.printExecutionResultMessage();
        while (isNotRacingFinished(tryCount)) {
            racingCars.move();
            OutputView.printResult(racingCars.submitCarStatuses());
            tryCount--;
        }
    }

    private boolean isNotRacingFinished(int tryCount) {
        return tryCount > 0;
    }

    private void finishRacing(RacingCars racingCars) {
        RacingResult racingResult = new RacingResult(racingCars.submitCarStatuses());
        OutputView.printWinner(racingResult.findWinner());
    }
}
