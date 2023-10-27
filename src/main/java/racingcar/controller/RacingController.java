package racingcar.controller;

import racingcar.domain.CarGenerator;
import racingcar.domain.RacingCars;
import racingcar.util.Convertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        OutputView.printCarNameInputMessage();
        String carNames = InputView.inputCarNames();
        RacingCars racingCars = new RacingCars(CarGenerator.generateParticipationCarList(carNames));
        OutputView.printTryCountInputMessage();
        int tryCount = Convertor.convertStringToInt(InputView.inputTryCount());
        racing(racingCars, tryCount);
        OutputView.printWinner(racingCars.getWinner());
    }

    private void racing(RacingCars racingCars, int tryCount) {
        OutputView.printExecutionResultMessage();
        while (tryCount > 0) {
            racingCars.move();
            OutputView.printResult(racingCars.getCarStatuses());
            tryCount--;
        }
    }
}
